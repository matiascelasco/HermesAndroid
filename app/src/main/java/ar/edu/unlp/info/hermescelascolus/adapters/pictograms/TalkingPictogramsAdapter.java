package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.activities.PictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Notification;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.Settings;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;
import ar.edu.unlp.info.hermescelascolus.models.helpers.DateSerializer;

public class TalkingPictogramsAdapter extends PictogramsAdapter {
    private Context appContext;
    private Kid kid;
    private Settings settings;

    public TalkingPictogramsAdapter(Context appContext, PictogramsActivity context, Kid kid, String title, List<Pictogram> pictograms) {
        super(context, title, pictograms);
        this.appContext = appContext;
        this.kid = kid;
        this.settings = Daos.SETTINGS.all().get(0);
    }

    private class NotificationSenderTask extends AsyncTask<ArrayList<Notification>, Void, Boolean> {

        @Override
        protected Boolean doInBackground(ArrayList<Notification>... params) {
            ArrayList<Notification> notificationToSend = params[0];
            //convert list to JSON
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateSerializer())
                    .create();
            String jsonString = gson.toJson(notificationToSend);

            //retrieved from general settings
            Settings settings = Daos.SETTINGS.all().get(0);
            String postUrl = String.format(
                    "http://%s:%s/load-notifications",
                    settings.getMonitorIp(),
                    settings.getMonitorPort()
            );
            System.out.println(postUrl);
            System.out.println(jsonString);


            //trying (and failid) to use HTTPURLConnection
       /* URL urlToRequest = null;
        try {
            urlToRequest = new URL(postUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlConnection.setDoOutput(true);
        try {
            urlConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        urlConnection.setRequestProperty("Content Type", "application/x-www-form-urlencoded");
         //prepare message size
         urlConnection.setFixedLengthStreamingMode(jsonString.getBytes().length);
         //send
        PrintWriter out = null;
        try {
            out = new PrintWriter(urlConnection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(jsonString);
         out.close();*/
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(postUrl);
            System.out.println("Sending JSON message to monitor at " + postUrl);
            try {
                post.setEntity(new StringEntity(jsonString));
                post.setHeader("Content-type", "application/json");
                HttpResponse response = client.execute(post);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                System.out.println("Response from monitor:");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                //empty the notification list
                notificationToSend.clear();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (!success){
                showToast(R.string.monitor_fail_error_msg);
            }
        }
    }

    private void showToast(int resId){
        if (settings.shouldShowNetworkErrors()){
            Toast.makeText(
                    appContext,
                    appContext.getResources().getString(resId),
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PictogramSoundPlayer.play(appContext, pictogram);

                //creates the notification
                Notification notification = new Notification(kid, pictogram);

                /*



                //convert list to JSON
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Date.class, new DateSerializer())
                        .create();
                String jsonString = gson.toJson(notification);



                //retrieved from general settings
                Settings settings = Daos.SETTINGS.all().get(0);

                String uri = String.format(
                        "http://%s:%s/load-notifications",
                        settings.getMonitorIp(),
                        settings.getMonitorPort()
                );

                // Add any headers if required
                Header[] headers = new Header[] {
                        new Header("Content-Type", "application/json"),
                        // gzip content when posting
//                new Header("Content-Encoding", "gzip")
                };


                // Create the message to send
                Message message = null;
                try {
                    message = new Message(
                            new URI(uri),
                            jsonString,
                            headers);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

                // Send the message to Reyna
                StoreService.start(context, message);


                // set Reyna logging level, same constant values as android.util.log (ERROR, WARN, INFO, DEBUG, VERBOSE)
                StoreService.setLogLevel(Log.VERBOSE);

                */


                //store the notification for posterior sending
                Notification.queue.add(notification);

                //test notification sending
                ConnectivityManager connMgr = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    //send the notification in asynchronous way
                    new NotificationSenderTask().execute(Notification.queue);
                }
                else {
                    showToast(R.string.network_fail_error_msg);
                }


            }

        });
    }

}
