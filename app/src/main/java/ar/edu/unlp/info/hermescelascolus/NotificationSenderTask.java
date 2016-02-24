package ar.edu.unlp.info.hermescelascolus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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
         String postUrl = "http://192.168.0.18:8000/load-notifications";
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
