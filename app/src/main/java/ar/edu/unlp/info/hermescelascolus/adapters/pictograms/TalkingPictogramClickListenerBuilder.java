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

import ar.edu.unlp.info.hermescelascolus.models.Notification;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TalkingPictogramClickListenerBuilder {

    public static ImageView.OnClickListener buildListener(final Context appContext, final Pictogram pictogram) {

        return new ImageView.OnClickListener() {
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


            }

        };
    }
}
