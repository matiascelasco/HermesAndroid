package ar.edu.unlp.info.hermescelascolus.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.fragments.TabFragment;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.PictogramsAdapter;

public class TabAdapter extends FragmentStatePagerAdapter {

    private List<PictogramsAdapter> pictogramsAdapters;

    public TabAdapter(FragmentManager fm, List<PictogramsAdapter> pictogramsAdapters) {
        super(fm);
        this.pictogramsAdapters = pictogramsAdapters;
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment fragment = new TabFragment();
        fragment.setPictogramsAdapter(pictogramsAdapters.get(position));
//        Pair<String, List<Pictogram>> pair = tabs.get(position);
//        Bundle args = new Bundle();
//        ArrayList<Integer> array = new ArrayList<>();
//        for (Pictogram pictogram: pair.second){
//            array.add(pictogram.getId());
//        }
//        args.putIntegerArrayList(TabFragment.PICTOGRAM_IDS, array);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return pictogramsAdapters.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pictogramsAdapters.get(position).getTitle();
    }
}
