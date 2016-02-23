package ar.edu.unlp.info.hermescelascolus;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class AssetBitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
    private final WeakReference<ImageView> imageViewReference;
    private static Context appContext = null;

    public static void setAppContext(Context _appContext){
        appContext = _appContext;
    }

    static public void loadBitmap(String path, ImageView imageView) {
        if (appContext == null){
            throw new IllegalStateException("Can't load bitmap when appContext is not initialized!");
        }
        AssetBitmapWorkerTask task = new AssetBitmapWorkerTask(imageView);
        task.execute(path);
    }

    public AssetBitmapWorkerTask(ImageView imageView) {
        // Use a WeakReference to ensure the ImageView can be garbage collected
        imageViewReference = new WeakReference<>(imageView);
    }

    // Decode image in background.
    @Override
    protected Bitmap doInBackground(String... params) {
        String path = params[0];
        return decodeSampledBitmapFromAssets(appContext, path, 100, 100);
    }
    public static Bitmap decodeSampledBitmapFromAssets(Context context, String filePath, int reqWidth, int reqHeight) {
        AssetManager assetManager = context.getAssets();
        final BitmapFactory.Options options = new BitmapFactory.Options();

        // First decode with inJustDecodeBounds=true to check dimensions
        options.inJustDecodeBounds = true;

        BufferedInputStream bistr;
        InputStream istr;
        Bitmap bitmap;
        try {
            istr = assetManager.open(filePath);
            bistr = new BufferedInputStream(istr);
            BitmapFactory.decodeStream(bistr);
            bistr.close();
            istr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        try {
            istr = assetManager.open(filePath);
            bistr = new BufferedInputStream(istr);
            bitmap = BitmapFactory.decodeStream(bistr);
            bistr.close();
            istr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bitmap;
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    // Once complete, see if ImageView is still around and set bitmap.
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}