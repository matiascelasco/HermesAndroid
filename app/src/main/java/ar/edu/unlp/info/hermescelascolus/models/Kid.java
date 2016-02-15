package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class Kid {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return name;
    }

    private int id;
    private String name;
    private List<Pictogram> pictograms = new ArrayList<>();
    private List<Category2> categories = new ArrayList<>();

    public List<Pictogram> getPictograms() {
        return Collections.unmodifiableList(pictograms);
    }

    public void addPictogram(Pictogram pictogram){
        pictograms.add(pictogram);
    }

    public List<Category2> getCategories() {
        for(Category2 c : Category2.values()){
            categories.add(c);
        }
        return Collections.unmodifiableList(categories);
    }

    public void addCategory(Category2 category){
        categories.add(category);
    }

}
