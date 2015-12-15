package ar.edu.unlp.info.hermescelascolus;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private final List<Pictogram> pictograms = new ArrayList<>();
    private String category;

    public ImageAdapter(Context c, List<Integer> pictogramIds, String category) {
        mContext = c;
        for (int id: pictogramIds){
            this.pictograms.add(Daos.PICTOGRAM.getById(id));
        }
        this.category = category;
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
            imageView = new ImageView(mContext);
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

        imageView.setImageResource(pictograms.get(position).getImageId());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(mContext, pictograms.get(position).getSoundId());
                mp.start();

            }
        });
        return imageView;
    }
}
