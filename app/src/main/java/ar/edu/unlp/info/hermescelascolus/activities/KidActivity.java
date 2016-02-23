package ar.edu.unlp.info.hermescelascolus.activities;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.PictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.TalkingPictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Mode;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class KidActivity extends PictogramsActivity {


    @Override
    protected int getMenuId() {
        return R.menu.menu_kid;
    }

    @Override
    protected List<PictogramsAdapter> getPictogramsAdapters() {
        List<PictogramsAdapter> adapters = new ArrayList<>();

        // In all tabs, each pictogram produces a sound (talks) when clicked.
        // That's why the TalkingPictogramsAdapter subclass is used

        // The first tab has the kid pictograms
        List<Pictogram> pictograms = new ArrayList<>();
        for (Pictogram p: kid.getPictograms()) {
            pictograms.add(p);
        }

        adapters.add(new TalkingPictogramsAdapter(this, kid.getName(), pictograms, getApplicationContext()));

        // The following tabs contains the pictograms from that category enabled for that kid
        for (Category c : kid.getCategories()) {
            adapters.add(new TalkingPictogramsAdapter(this, c.name(), c.getPictograms(), getApplicationContext()));
        }

        return adapters;
    }

    @Override
    protected Mode getCurrentMode() {
        return Mode.KID;
    }

    @Override
    public void onRestart(){
        super.onRestart();
        updatePictograms(kid.getId());
    }

}
