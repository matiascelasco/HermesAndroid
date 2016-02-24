package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public enum Category implements Model {
    PISTA("track"),
    ESTABLO("barn"),
    NECESIDADES("needs"),
    EMOCIONES("emotions");

    public List<Pictogram> getPictograms(){
        List<Pictogram> pictograms = new ArrayList<>();
        for (Pictogram p: Daos.PICTOGRAM.all()){
            if (p.getCategory() != null && p.getCategory().equals(this)){
                pictograms.add(p);
            }
        }
        return Collections.unmodifiableList(pictograms);
    }

    public String getDir() {
        return path;
    }

    Category(String dir) {
        this.path = dir;
    }

    private String path;

    public long getId(){
        return (long) ordinal();
    }

}
