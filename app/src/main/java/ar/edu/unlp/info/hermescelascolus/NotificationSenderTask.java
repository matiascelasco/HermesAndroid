package ar.edu.unlp.info.hermescelascolus;

import android.os.AsyncTask;

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

import ar.edu.unlp.info.hermescelascolus.models.Notification;
import ar.edu.unlp.info.hermescelascolus.models.Settings;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;
import ar.edu.unlp.info.hermescelascolus.models.helpers.DateSerializer;

public class NotificationSenderTask extends AsyncTask<ArrayList<Notification>, Void, Boolean> {

    @Override
    protected Boolean doInBackground(ArrayList<Notification>... params) {
        ArrayList<Notification> notificationToSend = params[0];
        //convert list to JSON
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .create();
        String jsonString = gson.toJson(notificationToSend);
        System.out.println(jsonString);

        //retrieved from general settings
        Settings settings = Daos.SETTINGS.all().get(0);
         String postUrl = String.format(
                 "http://%s:%s/load-notifications",
                 settings.getMonitorIp(),
                 settings.getMonitorPort()
         );
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
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean == true){
           // we have to empty the ArrayList
        }
        else{
            //you are screwed
        }
    }
}
