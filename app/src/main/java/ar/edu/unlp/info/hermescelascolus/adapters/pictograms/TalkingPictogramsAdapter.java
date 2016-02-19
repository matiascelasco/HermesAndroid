package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.activities.PictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TalkingPictogramsAdapter extends PictogramsAdapter {

    public TalkingPictogramsAdapter(PictogramsActivity context, String title, List<Pictogram> pictograms) {
        super(context, title, pictograms);
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
        v.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(context, pictogram.getSoundId());
                mp.start();
            }
        });
    }

}
