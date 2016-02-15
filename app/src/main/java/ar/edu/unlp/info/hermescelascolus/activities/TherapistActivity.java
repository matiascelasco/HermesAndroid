package ar.edu.unlp.info.hermescelascolus.activities;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Category2;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

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
    protected List<Category2> getCategories() {
        ArrayList<Category2> categories = new ArrayList<Category2>();
        for (Category2 c : Category2.values()){
          categories.add(c);
        }
        return categories;
    }
}
