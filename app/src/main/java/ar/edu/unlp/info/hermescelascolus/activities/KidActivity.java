package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;

import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.CategoryAdapter;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class KidActivity extends AppCompatActivity {

    ViewPager viewPager;

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

    }
}
