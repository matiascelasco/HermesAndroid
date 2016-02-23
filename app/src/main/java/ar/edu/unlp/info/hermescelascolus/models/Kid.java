package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class Kid implements Model {

    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private List<Pictogram> pictograms = null;
    private Map<Category, Set<Pictogram>> pictogramsByCategory = null;

    public Kid(){
        id = 0;
    }

    public List<Pictogram> getPictograms() {
        if (pictograms == null){
            pictograms = new ArrayList<>(Daos.KID_PICTOGRAM.getRelated(this));
        }
        return Collections.unmodifiableList(pictograms);
    }

    public void addPictogram(Pictogram pictogram){
        if (pictogram.getCategory() == null){
            throw new RuntimeException("YES-NO pictograms can't be assigned to a kid");
        }
        Daos.KID_PICTOGRAM.add(this, pictogram);
        pictograms.add(pictogram);
        pictogramsByCategory.get(pictogram.getCategory()).add(pictogram);
    }

    public void removePictogram(Pictogram pictogram){
        Daos.KID_PICTOGRAM.remove(this, pictogram);
        pictograms.remove(pictogram);
        pictogramsByCategory.get(pictogram.getCategory()).remove(pictogram);
    }

    public Collection<Category> getCategories() {
        return Daos.KID_CATEGORY.getRelated(this);
    }

    public void setCategories(Collection<Category> categories){
        Daos.KID_CATEGORY.setRelated(this, categories);
    }

    public Set<Pictogram> getPictogramsSetByCategory(Category category){
        if (pictogramsByCategory == null){
            pictogramsByCategory = new EnumMap<>(Category.class);
            for (Category c: Daos.CATEGORY.all()) {
                pictogramsByCategory.put(c, new HashSet<Pictogram>());
            }
            for (Pictogram p: pictograms) {
                if (p.getCategory() != null){
                    pictogramsByCategory.get(p.getCategory()).add(p);
                }
            }
        }
        return pictogramsByCategory.get(category);
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender(){
        return this.gender;
    }

    public void setGender(Gender g){
        this.gender = g;
    }

    public String toString(){
        return getFullName();
    }


}
