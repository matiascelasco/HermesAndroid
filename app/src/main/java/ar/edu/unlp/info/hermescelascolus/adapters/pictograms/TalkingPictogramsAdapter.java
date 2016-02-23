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
    Context activityContext;

    public TalkingPictogramsAdapter(PictogramsActivity context, String title, List<Pictogram> pictograms, Context appContext) {
        super(context, title, pictograms);
        this.appContext = appContext;
        this.activityContext = context;
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
        v.setOnClickListener(TalkingPictogramClickListenerBuilder.buildListener(appContext, pictogram, activityContext));
    }

}
