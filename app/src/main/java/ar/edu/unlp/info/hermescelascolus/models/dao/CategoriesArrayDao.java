package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Category;


public class CategoriesArrayDao implements Dao<Category> {

    private static List<String> names = Arrays.asList(
            "Pista",
            "Establo",
            "Necesidades",
            "Emociones"
    );
    private static List<Category> array = new ArrayList<>();

    private static void loadArray(){
        for (int i = 0; i < names.size(); i++){
            Category category = new Category();
            category.setId(i + 1);
            category.setName(names.get(i));
            array.add(category);
        }
    }

    @Override
    public List<Category> all() {
        if (array == null){
            loadArray();
        }
        return new ArrayList<>(array);
    }

    @Override
    public Category getById(int id) {
        if (array == null){
            loadArray();
        }
        return array.get(id - 1);
    }
}

