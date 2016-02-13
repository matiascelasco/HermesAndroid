package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.BitmapWorkerTask;
import ar.edu.unlp.info.hermescelascolus.CategoryAdapter;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.PictogramsTab;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public abstract class TabsWithPictogramsActivity extends AppCompatActivity {

    public final static String KID_ID = "ar.edu.unlp.info.hermescelascolus.KID_ID";
    protected Kid kid;

    protected abstract int getMenuId();
    protected abstract int getLayoutId();
    protected abstract List<Category> getCategories();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        Intent intent = getIntent();
        int kidId = intent.getIntExtra(InitialActivity.KID_ID, -1);
        kid = Daos.KID.getById(kidId);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new CategoryAdapter(getSupportFragmentManager(), getPictogramsTabs()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        setTitle(kid.getName());

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        BitmapWorkerTask.setResources(getResources());
    }

    private List<Pair<String, List<Pictogram>>> getPictogramsTabs(){
        List<Pair<String, List<Pictogram>>> tabs = new ArrayList<>();
        tabs.add(new Pair<>(kid.getName(), kid.getPictograms()));

        for (Category c: getCategories()){
            tabs.add(new Pair<>(c.getName(), c.getPictograms()));
        }
        return tabs;
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        menu.clear();
        getMenuInflater().inflate(getMenuId(), menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = getIntent();

        switch (item.getItemId()) {
            case R.id.action_settings:
                startSettingsActivity();
                return true;
            case R.id.action_therapist_mode:
                startTherapistActivity();
                return true;
            case R.id.action_kid_mode:
                startKidActivity();
                return true;
            default:
                throw new IllegalStateException("Option does not exist");
        }
    }

    private void startSettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra(KID_ID, kid.getId());
        startActivity(intent);
    }

    private void startTherapistActivity(){
        Intent intent = new Intent(this, TherapistActivity.class);
        intent.putExtra(KID_ID, kid.getId());
        startActivity(intent);
    }

    private void startKidActivity(){
        Intent intent = new Intent(this, KidActivity.class);
        intent.putExtra(KID_ID, kid.getId());
        startActivity(intent);
    }
}
