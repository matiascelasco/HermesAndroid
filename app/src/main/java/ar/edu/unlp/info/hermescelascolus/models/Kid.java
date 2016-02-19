package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Kid {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString(){
        return name+" "+surname;
    }

    public Gender getGender(){ return this.gender; }

    public void setGender(Gender g){
        this.gender = g;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private List<Pictogram> pictograms = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Map<Category, Set<Pictogram>> pictogramsByCategory = new EnumMap<>(Category.class);

    public Kid(){
        id=0;
        for (Category c: Category.values()){
            pictogramsByCategory.put(c, new HashSet<Pictogram>());
        }
    }

    public List<Pictogram> getPictograms() {
        return Collections.unmodifiableList(pictograms);
    }

    public void addPictogram(Pictogram pictogram){
        pictograms.add(pictogram);
        pictogramsByCategory.get(pictogram.getCategory()).add(pictogram);
    }

    public void removePictogram(Pictogram pictogram){
        pictograms.remove(pictogram);
        pictogramsByCategory.get(pictogram.getCategory()).remove(pictogram);
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public Set<Pictogram> getPictogramsSetByCategory(Category c){
        return Collections.unmodifiableSet(pictogramsByCategory.get(c));
    }


    public boolean hasCategory(Category c) {
        return categories.contains(c);
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public void clearCategories() {
        categories.clear();
    }
}
