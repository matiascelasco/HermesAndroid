package ar.edu.unlp.info.hermescelascolus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.PictogramsTab;

public class CategoryAdapter extends FragmentStatePagerAdapter {

    private List<Pair<String, List<Pictogram>>> tabs;

    public CategoryAdapter(FragmentManager fm, List<Pair<String, List<Pictogram>>> tabs) {
        super(fm);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        Pair<String, List<Pictogram>> pair = tabs.get(position);
        args.putString(CategoryFragment.TITLE, pair.first);
        ArrayList<Integer> array = new ArrayList<>();
        for (Pictogram pictogram: pair.second){
            array.add(pictogram.getId());
        }
        args.putIntegerArrayList(CategoryFragment.PICTOGRAM_IDS, array);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).first;
    }
}
