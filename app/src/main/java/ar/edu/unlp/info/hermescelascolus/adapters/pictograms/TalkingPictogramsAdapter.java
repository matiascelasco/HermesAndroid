package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.NotificationSenderTask;
import ar.edu.unlp.info.hermescelascolus.activities.PictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Notification;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TalkingPictogramsAdapter extends PictogramsAdapter {
    private Context appContext;
    private Kid kid;

    public TalkingPictogramsAdapter(Context appContext, PictogramsActivity context, Kid kid, String title, List<Pictogram> pictograms) {
        super(context, title, pictograms);
        this.appContext = appContext;
        this.kid = kid;
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    AssetFileDescriptor afd = appContext.getAssets().openFd(pictogram.getSoundPath());
                    MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                //creates the notification
                Notification notification = new Notification(kid, pictogram);

                //store the notification for posterior sending
                Notification.queue.add(notification);

                //test notification sending
                ConnectivityManager connMgr = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    //send the notification in asynchronous way
                    new NotificationSenderTask().execute(Notification.queue);
                }

            }

        });
    }

}
