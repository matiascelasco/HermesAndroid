package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
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

    public List<Pictogram> getPictograms() {
        return Daos.PICTOGRAM.all();
    }

}
