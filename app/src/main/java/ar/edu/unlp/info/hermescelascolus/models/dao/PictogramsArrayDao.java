package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class PictogramsArrayDao implements Dao<Pictogram> {

    private static Integer[] imageIds = {
            R.drawable.comunicador__0029_vector_smart_object,
            R.drawable.comunicador__0030_vector_smart_object,
            R.drawable.comunicador__0031_vector_smart_object,
            R.drawable.comunicador__0032_vector_smart_object,
            R.drawable.comunicador__0033_vector_smart_object,
            R.drawable.comunicador__0034_vector_smart_object,
            R.drawable.comunicador__0035_vector_smart_object,
            R.drawable.comunicador__0036_vector_smart_object,
            R.drawable.comunicador__0037_vector_smart_object,
            R.drawable.comunicador__0038_vector_smart_object,
            R.drawable.comunicador__0039_vector_smart_object,
            R.drawable.comunicador__0040_vector_smart_object,
            R.drawable.comunicador__0041_vector_smart_object,
            R.drawable.comunicador__0042_vector_smart_object,
            R.drawable.comunicador__0043_vector_smart_object,
    };
    private static List<Pictogram> array = new ArrayList<>();

    private static void loadArray(){
        Random random = new Random();
        List<Category> categories = Daos.CATEGORY.all();
        for (int i = 0; i < imageIds.length; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setImageId(imageIds[i]);
            pictogram.setCategory(categories.get(random.nextInt(categories.size())));

            array.add(pictogram);
        }
    }

    @Override
    public List<Pictogram> all() {
        if (array == null){
            loadArray();
        }
        return new ArrayList<>(array);
    }

    @Override
    public Pictogram getById(int id) {
        if (array == null){
            loadArray();
        }
        return array.get(id - 1);
    }


}
