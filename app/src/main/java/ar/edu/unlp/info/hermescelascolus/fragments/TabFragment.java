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
    public final static String LAYOUT_ID = "ar.edu.unlp.info.hermescelascolus.LAYOUT_ID";

    private PictogramsAdapter pictogramsAdapter;

    public void setPictogramsAdapter(PictogramsAdapter pictogramsAdapter) {
        this.pictogramsAdapter = pictogramsAdapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        View rootView = inflater.inflate(
                args.getInt(LAYOUT_ID),
                container,
                false
        );
        GridView grid = (GridView) rootView.findViewById(R.id.grid);

        if (pictogramsAdapter == null){
            // TODO: sometimes this exception is thrown, I don't know why
            // maybe this thing of the setPictogramsAdapter was a bad idea
            throw new IllegalStateException(
                    "setPictogramsAdapter must be called after the constructor"
            );
        }
        grid.setAdapter(pictogramsAdapter);

        return rootView;
    }
}
