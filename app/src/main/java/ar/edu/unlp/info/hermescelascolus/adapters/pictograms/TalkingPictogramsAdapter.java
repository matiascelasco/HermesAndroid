package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.NotificationSenderTask;
import ar.edu.unlp.info.hermescelascolus.activities.PictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Notification;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TalkingPictogramsAdapter extends PictogramsAdapter {
    Context appContext;
    Context activityContext;
    ArrayList<Notification> notif;
    String kidName;

    public TalkingPictogramsAdapter(PictogramsActivity context, String title, List<Pictogram> pictograms, Context appContext, ArrayList<Notification> notifications) {
        super(context, title, pictograms);
        this.appContext = appContext;
        this.activityContext = context;
        this.notif = notifications;
        this.kidName = title;
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
       /* v.setOnClickListener(TalkingPictogramClickListenerBuilder.buildListener(appContext, pictogram, activityContext));*/
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AssetFileDescriptor afd = appContext.getAssets().openFd(pictogram.getSoundPath());
                    MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepare();
                    mp.start();
                }
                catch(IOException e){
                    throw new RuntimeException(e);
                }
                //creates the notification
                Notification notification = new Notification();
                notification.setContent(pictogram.getName());
                notification.setKid(kidName);
                notification.setDateTimeSent(new Date());
                notification.setCategory(pictogram.getCategory().getDir());
                //store the notification for posterior sending
                notif.add(notification);

                //test notification sending
                ConnectivityManager connMgr = (ConnectivityManager) activityContext.getSystemService(appContext.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    //send the notification in asynchronous way
                    new NotificationSenderTask().execute(notif);
                    //empty the notification list
                    notif = new ArrayList<>();

                }
            }
        });
    }

}
