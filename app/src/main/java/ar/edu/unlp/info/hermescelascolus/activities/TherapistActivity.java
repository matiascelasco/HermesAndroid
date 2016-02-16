package ar.edu.unlp.info.hermescelascolus.activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;

public class TherapistActivity extends TabsWithPictogramsActivity {

    @Override
    protected int getMenuId() {
        return R.menu.menu_therapist;
    }

    @Override
    protected List<Category> getCategories() {
        return Arrays.asList(Category.values());
    }
}
