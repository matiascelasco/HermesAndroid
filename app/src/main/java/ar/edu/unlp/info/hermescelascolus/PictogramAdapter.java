package ar.edu.unlp.info.hermescelascolus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.activities.TabsWithPictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class PictogramAdapter extends BaseAdapter {
    private TabsWithPictogramsActivity activity;
    private final List<Pictogram> pictograms = new ArrayList<>();

    public PictogramAdapter(Context c, List<Integer> pictogramIds, String category) {
        activity = (TabsWithPictogramsActivity) c;
        for (int id: pictogramIds){
            this.pictograms.add(Daos.PICTOGRAM.getById(id));
        }
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
            imageView = new ImageView(activity);
            imageView.setAdjustViewBounds(true);
            /*imageView.setLayoutParams(
                    new GridView.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    )
            );*/
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        BitmapWorkerTask.loadBitmap(pictograms.get(position).getImageId(), imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onPictogramClick((ImageView) view, pictograms.get(position));
            }
        });
        return imageView;
    }
}
