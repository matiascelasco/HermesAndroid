package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return name+" "+surname;
    }

    public String getGender(){ return this.gender; }

    public void setGender(String g){
        this.gender = g;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    private int id;
    private String name;
    private String surname;
    private String gender;
    private List<Pictogram> pictograms = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public List<Pictogram> getPictograms() {
        return Collections.unmodifiableList(pictograms);
    }

    public void addPictogram(Pictogram pictogram){
        pictograms.add(pictogram);
    }

    public void removePictogram(Pictogram pictogram){
        pictograms.remove(pictogram);
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public void addCategory(Category category){
        categories.add(category);
    }

}
