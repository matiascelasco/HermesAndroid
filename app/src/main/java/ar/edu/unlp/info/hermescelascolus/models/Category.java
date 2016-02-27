package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public enum Category implements Model {
    TRACK("Pista", "track"),
    BARN("Establo", "barn"),
    NEEDS("Necesidades", "needs"),
    EMOTIONS("Emociones", "emotions");

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
        return dir;
    }
    public String getNameToBeDisplayed() {
        return nameToBeDisplayed;
    }

    Category(String nameToBeDisplayed, String dir) {
        this.dir = dir;
        this.nameToBeDisplayed = nameToBeDisplayed;
    }

    private String dir;
    private String nameToBeDisplayed;

    public long getId(){
        return (long) ordinal();
    }

}
