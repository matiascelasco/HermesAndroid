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

    public Map<String, List<Pictogram>> getPictogramsSetForKidModeTabs(){
        return getPictogramsSetForTabs(getCategories());
    }

    public Map<String, List<Pictogram>> getPictogramsSetForTherapistModeTabs(){
        return getPictogramsSetForTabs(Daos.CATEGORY.all());
    }

    private Map<String, List<Pictogram>> getPictogramsSetForTabs(List<Category> categories){
        Map<String, List<Pictogram>> map = new HashMap<String, List<Pictogram>>();
        map.put(getName(), getPictograms());
        for (Category c: categories){
            map.put(c.getName(), c.getPictograms());
        }
        return map;
    }

}
