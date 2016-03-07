package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    RequestQueue requestQueue;

    public TalkingPictogramsAdapter(Context appContext, PictogramsActivity context, Kid kid, String title, List<Pictogram> pictograms, Pictogram.Size size) {
        super(context, title, pictograms, size);
        this.appContext = appContext;
        this.kid = kid;
        this.settings = Daos.SETTINGS.all().get(0);
        this.requestQueue = Volley.newRequestQueue(context);
    }

    private void maybeShowToast(int resId){
        if (settings.shouldShowNetworkErrors()){
            Toast.makeText(
                    context,
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

                //store the notification for posterior sending
                Notification.queue.add(notification);

                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Date.class, new DateSerializer())
                        .create();
                Map<String, List<Notification>> qwe = new HashMap<>();
                qwe.put("notifications", Notification.queue);
                String jsonString = gson.toJson(qwe);


                //retrieved from general settings
                String postUrl = String.format(
                        "http://%s:%s/load-notifications",
                        settings.getMonitorIp(),
                        settings.getMonitorPort()
                );

                // TODO: Unnecessary double parsing
                JSONObject json;
                try {
                    json = new JSONObject(jsonString);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Request request = new JsonObjectRequest(
                        postUrl,
                        json,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Notification.queue.clear();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                if (error.getMessage().toUpperCase().contains("ECONNREFUSED")){  //TODO: this is awful
                                    maybeShowToast(R.string.monitor_fail_error_msg);
                                }
                                else {
                                    maybeShowToast(R.string.network_fail_error_msg);
                                }
                            }
                        }
                );
                requestQueue.add(request);
            }

        });
    }

}
