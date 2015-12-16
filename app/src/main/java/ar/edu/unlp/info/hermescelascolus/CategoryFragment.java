package ar.edu.unlp.info.hermescelascolus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class CategoryFragment extends Fragment {
    public static final String CATEGORY = "category";
    public static final String PICTOGRAM_IDS = "pictograms";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.fragment_collection_object, container, false);
        Bundle args = getArguments();
        GridView grid = (GridView) rootView.findViewById(R.id.grid);
        grid.setAdapter(
                new PictogramAdapter(
                        this.getContext(),
                        args.getIntegerArrayList(PICTOGRAM_IDS),
                        args.getString(CATEGORY)
                )
        );

        return rootView;
    }
}
