package ar.edu.unlp.info.hermescelascolus.activities;

import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TherapistActivity extends TabsWithPictogramsActivity {

    private Set<Integer> selectedPictogramIds = new HashSet<>();

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
        int id = pictogram.getId();
        if (selectedPictogramIds.contains(id)){
            view.setBackgroundResource(0);  //removes the background
            selectedPictogramIds.remove(id);
        }
        else {
            view.setBackgroundResource(R.drawable.pictogram_border);
            selectedPictogramIds.add(id);
        }
    }
}
