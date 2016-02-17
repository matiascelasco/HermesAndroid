package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.BitmapWorkerTask;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.PictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.adapters.TabAdapter;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public abstract class TabsWithPictogramsActivity extends AppCompatActivity {

    public final static String KID_ID = "ar.edu.unlp.info.hermescelascolus.KID_ID";
    protected Kid kid;

    protected abstract int getMenuId();
    protected abstract List<PictogramsAdapter> getPictogramsAdapters();


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_with_pictograms);

        Intent intent = getIntent();
        int kidId = intent.getIntExtra(InitialActivity.KID_ID, -1);
        kid = Daos.KID.getById(kidId);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), getPictogramsAdapters()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        setTitle(kid.getName());

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        BitmapWorkerTask.setResources(getResources());
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        menu.clear();
        getMenuInflater().inflate(getMenuId(), menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(this, SettingsActivity.class);
                break;
            case R.id.action_therapist_mode:
                intent = new Intent(this, TherapistActivity.class);
                break;
            case R.id.action_kid_mode:
                intent = new Intent(this, KidActivity.class);
                break;
            default:
                throw new IllegalStateException("Option does not exist");
        }
        intent.putExtra(KID_ID, kid.getId());
        startActivity(intent);
        return true;
    }

    public void pictogramSelected(Pictogram pictogram){
        kid.addPictogram(pictogram);
    }

    public void pictogramUnselected(Pictogram pictogram){
        kid.removePictogram(pictogram);
    }
}
