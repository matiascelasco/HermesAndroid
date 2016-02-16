package ar.edu.unlp.info.hermescelascolus.activities;

import android.media.MediaPlayer;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TherapistActivity extends TabsWithPictogramsActivity {

    @Override
    protected int getMenuId() {
        return R.menu.menu_therapist;
    }

    @Override
    protected List<Category> getCategories() {
        return Arrays.asList(Category.values());
    }

    @Override
    public void onPictogramClick(ImageView view, Pictogram pictogram) {
        view.setBackgroundResource(R.drawable.pictogram_border);
    }
}
