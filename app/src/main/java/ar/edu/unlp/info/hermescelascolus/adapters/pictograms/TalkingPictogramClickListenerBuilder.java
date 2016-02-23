package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TalkingPictogramClickListenerBuilder {
    public static ImageView.OnClickListener buildListener(final Context appContext, final Pictogram pictogram){
        return new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {

               /* MediaPlayer mp = MediaPlayer.create(context, pictogram.getSoundId());
                mp.start();*/
                //try to load the sound from the assets folder
                try {
                    System.out.println(pictogram.getSoundPath());
                    AssetFileDescriptor afd = appContext.getAssets().openFd(pictogram.getSoundPath());
                    MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepare();
                    mp.start();
                }
                catch(IOException e){
                    throw new RuntimeException(e);
                }

            }
        };
    }
}
