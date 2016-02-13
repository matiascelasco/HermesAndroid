package ar.edu.unlp.info.hermescelascolus.activities;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
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
    protected List<Category> getCategories() {
        return Daos.CATEGORY.all();
    }
}
