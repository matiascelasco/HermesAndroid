package ar.edu.unlp.info.hermescelascolus.activities;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category2;

public class KidActivity extends TabsWithPictogramsActivity {


    @Override
    protected int getMenuId() {
        return R.menu.menu_kid;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kid;
    }

    @Override
    protected List<Category2> getCategories() {
        return kid.getCategories();
    }
}
