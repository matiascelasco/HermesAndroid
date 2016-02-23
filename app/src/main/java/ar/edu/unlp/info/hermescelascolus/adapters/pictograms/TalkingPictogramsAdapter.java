package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.activities.PictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TalkingPictogramsAdapter extends PictogramsAdapter {
    Context appContext;

    public TalkingPictogramsAdapter(PictogramsActivity context, String title, List<Pictogram> pictograms, Context appContext) {
        super(context, title, pictograms);
        this.appContext = appContext;
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
        v.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {

               /* MediaPlayer mp = MediaPlayer.create(context, pictogram.getSoundId());
                mp.start();*/
                //try to load the sound from the assets folder
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

            }
        });
    }

}
