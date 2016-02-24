package ar.edu.unlp.info.hermescelascolus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import ar.edu.unlp.info.hermescelascolus.models.Notification;
import ar.edu.unlp.info.hermescelascolus.models.helpers.DateSerializer;

/**
 * Created by laura on 23/02/16.
 */
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
        String postUrl = "http://192.168.1.100:8000/load-notifications";
        try {
            URL urlToRequest = new URL(postUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content Type", "application/x-www-form-urlencoded");
            //prepare message size
            urlConnection.setFixedLengthStreamingMode(jsonString.getBytes().length);
            //send
            PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
            out.print(jsonString);
            out.close();

        }catch(MalformedURLException e){
            new RuntimeException("problem with URL");
        }
        catch(IOException e){
            new RuntimeException("problem with I/O");
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean == true){
            //the app could send the data
        }
        else{
            //you are screwed
        }
    }
}
