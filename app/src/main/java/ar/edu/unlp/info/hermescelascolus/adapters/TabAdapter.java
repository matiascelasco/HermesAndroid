package ar.edu.unlp.info.hermescelascolus.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.fragments.TabFragment;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.PictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.models.Mode;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TabAdapter extends FragmentStatePagerAdapter {

    private List<PictogramsAdapter> pictogramsAdapters;
    private Mode mode;
    private Pictogram.Size size;

    public TabAdapter(FragmentManager fm, List<PictogramsAdapter> pictogramsAdapters, Mode mode, Pictogram.Size size) {
        super(fm);
        this.pictogramsAdapters = pictogramsAdapters;
        this.mode = mode;
        this.size = size;
    }

    @Override
    public synchronized Fragment getItem(int position) {
        TabFragment fragment = new TabFragment();
        fragment.setPictogramsAdapter(pictogramsAdapters.get(position));
        Bundle args = new Bundle();
        args.putInt(TabFragment.MODE_ORDINAL, mode.ordinal());
        args.putInt(TabFragment.COLUMN_WIDTH, size.getColumnWidth());
        args.putInt(TabFragment.WEIGHT, size.getWeight());
        args.putBoolean(TabFragment.SHOW_YES_NO, mode.equals(Mode.KID) || position == 0);
        fragment.setArguments(args);
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
