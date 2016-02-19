package ar.edu.unlp.info.hermescelascolus.activities;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.PictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.RemovablePictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.adapters.pictograms.SelectablePictogramsAdapter;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Mode;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class TherapistActivity extends TabsWithPictogramsActivity {

    private Map<Category, SelectablePictogramsAdapter> adapterByCategory = new EnumMap<>(Category.class);

    @Override
    protected int getMenuId() {
        return R.menu.menu_therapist;
    }

    @Override
    protected List<PictogramsAdapter> getPictogramsAdapters() {
        List<PictogramsAdapter> adapters = new ArrayList<>();

        // The first tab has the kid pictograms, which can be removed with a long click.
        // That's why the RemovablePictogramsAdapter subclass is used
        adapters.add(new RemovablePictogramsAdapter(this, kid.getName(), kid.getPictograms()));

        // The following tabs contains the pictograms from each category
        // The pictograms can be selected with a click and that's why the
        // SelectablePictogramsAdapter subclass is used
        for (Category c : Category.values()) {
            // A set with the initially selected pictograms for that tab
            // is required as an extra parameter
            Set<Pictogram> selected = kid.getPictogramsSetByCategory(c);
            SelectablePictogramsAdapter adapter =
                    new SelectablePictogramsAdapter(this, c.name(), c.getPictograms(), selected);
            adapters.add(adapter);
            adapterByCategory.put(c, adapter);
        }

        return adapters;
    }

    @Override
    protected Mode getCurrentMode() {
        return Mode.THERAPIST;
    }

    @Override
    public void pictogramSelected(Pictogram pictogram){
        super.pictogramSelected(pictogram);
        adapterByCategory.get(pictogram.getCategory()).notifyDataSetChanged();
    }


    @Override
    public void pictogramUnselected(Pictogram pictogram){
        super.pictogramUnselected(pictogram);
        adapterByCategory.get(pictogram.getCategory()).notifyDataSetChanged();
    }

}
