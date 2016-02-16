package ar.edu.unlp.info.hermescelascolus.activities;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;

public class TherapistActivity extends TabsWithPictogramsActivity {

    @Override
    protected int getMenuId() {
        return R.menu.menu_therapist;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_therapist;
    }

    @Override
    protected List<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        for (Category c : Category.values()){
          categories.add(c);
        }
        return categories;
    }
}
