package ar.edu.unlp.info.hermescelascolus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.io.IOException;
import java.io.InputStream;

public class BitmapBuilder {

    public static Bitmap build(Context context, String path, int width, int height){
        Bitmap bm = decodeFile(path, width, height, context);
        Bitmap.Config config = bm.getConfig();
        int w = bm.getWidth();
        int h = bm.getHeight();

        Bitmap newImage = Bitmap.createBitmap(w, h, config);

        Canvas c = new Canvas(newImage);
        c.drawBitmap(bm, 0, 0, null);
        return newImage;
    }

    public static Bitmap decodeFile(String filePath, int WIDTH, int HEIGHT, Context context) {
        Bitmap bm = null;
        InputStream is = null;
        try {
            is = context.getAssets().open(filePath);
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, o);

            int scale = 1;
            while (o.outWidth / scale / 2 >= WIDTH && o.outHeight / scale / 2 >= HEIGHT)
                scale *= 2;

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            is = context.getAssets().open(filePath);
            bm = BitmapFactory.decodeStream(is, null, o2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bm;
    }
}
