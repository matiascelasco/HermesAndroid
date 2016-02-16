package ar.edu.unlp.info.hermescelascolus.activities;

import android.media.MediaPlayer;
import android.widget.ImageView;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class KidActivity extends TabsWithPictogramsActivity {


    @Override
    protected int getMenuId() {
        return R.menu.menu_kid;
    }

    @Override
    protected List<Category> getCategories() {
        return kid.getCategories();
    }

    @Override
    public void onPictogramClick(ImageView view, Pictogram pictogram) {
        MediaPlayer mp = MediaPlayer.create(this, pictogram.getSoundId());
        mp.start();
    }
}
