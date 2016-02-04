package ar.edu.unlp.info.hermescelascolus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class CategoryAdapter extends FragmentStatePagerAdapter {

    private List<Category> categories = new ArrayList<>();
    private Map<Category, List<Pictogram>> pictogramsByCategory = new HashMap<>();

    public CategoryAdapter(FragmentManager fm, List<Pictogram> pictograms) {
        super(fm);
        for (Pictogram pictogram: pictograms){
            Category category = pictogram.getCategory();
            List<Pictogram> list;
            if (!pictogramsByCategory.containsKey(category)){
                list = new ArrayList<>();
                pictogramsByCategory.put(category, list);
                categories.add(category);
            } else {
                list = pictogramsByCategory.get(category);
            }
            list.add(pictogram);
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        Category category = categories.get(position);
        args.putString(CategoryFragment.CATEGORY, category.getName());
        ArrayList<Integer> array = new ArrayList<>();
        for (Pictogram pictogram: pictogramsByCategory.get(category)){
            array.add(pictogram.getId());
        }
        args.putIntegerArrayList(CategoryFragment.PICTOGRAM_IDS, array);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getName();
    }
}
