package ar.edu.unlp.info.hermescelascolus.adapters.pictograms;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.BitmapBuilder;
import ar.edu.unlp.info.hermescelascolus.activities.PictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public abstract class PictogramsAdapter extends BaseAdapter {

    protected PictogramsActivity context;
    protected List<Pictogram> pictograms;
    private String title;
    private Pictogram.Size size;

    protected abstract void subscribeHandlers(ImageView v, Pictogram pictogram);

    protected PictogramsAdapter(PictogramsActivity context, String title, List<Pictogram> pictograms, Pictogram.Size size){
        this.context = context;
        this.title = title;
        this.pictograms = pictograms;
        this.size = size;
    }

    public int getCount() {
        return pictograms.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(
                BitmapBuilder.build(context, pictograms.get(position).getImagePath(), size.getColumnWidth(), size.getColumnWidth())
        );

        subscribeHandlers(imageView, pictograms.get(position));

        return imageView;
    }

    public String getTitle() {
        return title;
    }

}
