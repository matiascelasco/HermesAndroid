package ar.edu.unlp.info.hermescelascolus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StupidFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.fragment_collection_object, container, false);
        Bundle args = getArguments();
        GridView grid = (GridView) rootView.findViewById(R.id.grid);
        grid.setAdapter(new ImageAdapter(this.getContext(), args.getInt(ARG_OBJECT)));

        return rootView;
    }
}
