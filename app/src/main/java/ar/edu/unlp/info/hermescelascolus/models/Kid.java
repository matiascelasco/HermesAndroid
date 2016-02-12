package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private List<Category> categories = new ArrayList<>();

    public List<Pictogram> getPictograms() {
        return Collections.unmodifiableList(pictograms);
    }

    public void addPictogram(Pictogram pictogram){
        pictograms.add(pictogram);
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public void addCategory(Category category){
        categories.add(category);
    }

}
