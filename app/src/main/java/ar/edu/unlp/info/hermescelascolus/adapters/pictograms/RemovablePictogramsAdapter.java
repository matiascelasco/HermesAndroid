package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.activities.TabsWithPictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class RemovablePictogramsAdapter extends PictogramsAdapter {

    public RemovablePictogramsAdapter(TabsWithPictogramsActivity context, String title, List<Pictogram> pictograms) {
        super(context, title, pictograms);
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
        v.setOnLongClickListener(new ImageView.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                // Removes the pictogram from the List and the database
                context.pictogramUnselected(pictogram);
                // Refresh the grid
                GridView parent = (GridView) v.getParent();
                parent.invalidateViews();
                return true;
            }
        });
    }
}
