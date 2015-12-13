package ar.edu.unlp.info.hermescelascolus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int page;

    public ImageAdapter(Context c, int page) {
        mContext = c;
        this.page = page;
    }

    public int getCount() {
        return 5;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
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

        imageView.setImageResource(mThumbIds[page * 5 + position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.comunicador__0029_vector_smart_object,
            R.drawable.comunicador__0030_vector_smart_object,
            R.drawable.comunicador__0031_vector_smart_object,
            R.drawable.comunicador__0032_vector_smart_object,
            R.drawable.comunicador__0033_vector_smart_object,
            R.drawable.comunicador__0034_vector_smart_object,
            R.drawable.comunicador__0035_vector_smart_object,
            R.drawable.comunicador__0036_vector_smart_object,
            R.drawable.comunicador__0037_vector_smart_object,
            R.drawable.comunicador__0038_vector_smart_object,
            R.drawable.comunicador__0039_vector_smart_object,
            R.drawable.comunicador__0040_vector_smart_object,
            R.drawable.comunicador__0041_vector_smart_object,
            R.drawable.comunicador__0042_vector_smart_object,
            R.drawable.comunicador__0042_vector_smart_object,
    };
}
