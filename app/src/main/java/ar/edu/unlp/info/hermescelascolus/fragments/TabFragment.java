package ar.edu.unlp.info.hermescelascolus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.PictogramsAdapter;

public class TabFragment extends Fragment {
    public static final String TITLE = "category";
    public static final String PICTOGRAM_IDS = "pictograms";

    private PictogramsAdapter pictogramsAdapter;

    public void setPictogramsAdapter(PictogramsAdapter pictogramsAdapter) {
        this.pictogramsAdapter = pictogramsAdapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.fragment_collection_object, container, false);
        Bundle args = getArguments();
        GridView grid = (GridView) rootView.findViewById(R.id.grid);

        if (pictogramsAdapter == null){
            throw new IllegalStateException("setPictogramsAdapter must be called after the constructor");
        }
        grid.setAdapter(pictogramsAdapter);

        return rootView;
    }
}
