package ar.edu.unlp.info.hermescelascolus.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class Kid implements Model {

    private long id;
    private String name;
    private String surname;
    private Gender gender;

    public Kid(){
        id = 0;
    }

    public Collection<Pictogram> getPictograms() {
        return Daos.KID_PICTOGRAM.getRelated(this);
    }

    public void addPictogram(Pictogram pictogram){
        Daos.KID_PICTOGRAM.add(this, pictogram);
    }

    public void removePictogram(Pictogram pictogram){
        Daos.KID_PICTOGRAM.remove(this, pictogram);
    }

    public Collection<Category> getCategories() {
        return Daos.KID_CATEGORY.getRelated(this);
    }

    public void setCategories(Collection<Category> categories){
        Daos.KID_CATEGORY.setRelated(this, categories);
    }

    public Set<Pictogram> getPictogramsSetByCategory(Category c){
        Set<Pictogram> set = new HashSet<>();
        for (Pictogram p: Daos.KID_PICTOGRAM.getRelated(this)){
            if (p.getCategory().equals(c)){
                set.add(p);
            }
        }
        return set;
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
