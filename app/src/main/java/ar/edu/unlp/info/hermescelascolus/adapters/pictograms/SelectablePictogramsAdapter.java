package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.activities.PictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class SelectablePictogramsAdapter extends PictogramsAdapter {

    private Set<Pictogram> selectedPictograms = new HashSet<>();

    public SelectablePictogramsAdapter(PictogramsActivity context,
                                       String title,
                                       List<Pictogram> pictograms,
                                       Set<Pictogram> selectedPictograms) {
        super(context, title, pictograms);
        this.selectedPictograms = selectedPictograms;
    }

    @Override
    protected void subscribeHandlers(ImageView v, final Pictogram pictogram) {
        v.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPictograms.contains(pictogram)) {
                    removeBorder(v);
                    context.pictogramUnselected(pictogram);
                } else {
                    addBorder(v);
                    context.pictogramSelected(pictogram);
                }
            }
        });
    }

    private void addBorder(View v){
        v.setBackgroundResource(R.drawable.pictogram_border);
    }

    private void removeBorder(View v){
        v.setBackgroundResource(0);
    }
    
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        if (selectedPictograms.contains(pictograms.get(position))) {
            addBorder(v);
        } else {
            removeBorder(v);
        }
        return v;
    }

}
