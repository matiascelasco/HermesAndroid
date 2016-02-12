package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.astuetz.PagerSlidingTabStrip;

import ar.edu.unlp.info.hermescelascolus.BitmapWorkerTask;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.CategoryAdapter;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class KidActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_kid, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid);

        Intent intent = getIntent();
        int kidId = intent.getIntExtra(InitialActivity.KID_ID, -1);
        Kid kid = Daos.KID.getById(kidId);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new CategoryAdapter(getSupportFragmentManager(), kid.getPictograms()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        setTitle(kid.getName());

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        BitmapWorkerTask.setResources(getResources());
    }
}
