package ar.edu.unlp.info.hermescelascolus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import ar.edu.unlp.info.hermescelascolus.BitmapBuilder;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.PictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.TalkingPictogramClickListenerBuilder;
import ar.edu.unlp.info.hermescelascolus.models.Mode;
import ar.edu.unlp.info.hermescelascolus.models.Notification;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TabFragment extends Fragment {
    public final static String MODE_ORDINAL = "ar.edu.unlp.info.hermescelascolus.MODE_ORDINAL";

    private PictogramsAdapter pictogramsAdapter;

    public void setPictogramsAdapter(PictogramsAdapter pictogramsAdapter) {
        this.pictogramsAdapter = pictogramsAdapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        Mode mode = Mode.values()[args.getInt(MODE_ORDINAL)];
        View rootView = inflater.inflate(
                mode.getFragmentLayoutId(),
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

        if (mode.equals(Mode.KID)){
            LinearLayout layout =
                    (LinearLayout) rootView.findViewById(R.id.yes_no_pictograms_container);
            Pictogram[] yesNoPictograms = {Pictogram.getYes(), Pictogram.getNo()};
            System.out.println(yesNoPictograms);
            for (Pictogram pictogram: yesNoPictograms){
                ImageView image = new ImageView(getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                lp.setMargins(2, 2, 2, 2);
                image.setLayoutParams(lp);
                image.setScaleType(ImageView.ScaleType.FIT_CENTER);
                image.setAdjustViewBounds(true);
                image.setImageBitmap(BitmapBuilder.build(getContext(), pictogram.getImagePath()));
                image.setOnClickListener(
                        TalkingPictogramClickListenerBuilder.buildListener(
                                getActivity().getApplicationContext(),
                                pictogram
                        )
                );

                layout.addView(image);
            }
        }


        return rootView;
    }
}
