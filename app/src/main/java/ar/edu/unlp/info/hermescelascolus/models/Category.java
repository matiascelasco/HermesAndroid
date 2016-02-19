package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public enum Category {
    PISTA,
    ESTABLO,
    NECESIDADES,
    EMOCIONES;

    public List<Pictogram> getPictograms(){
        //TODO: change this implementation when db is ready
        List<Pictogram> pictograms = new ArrayList<>();
        for (Pictogram p: Daos.PICTOGRAM.all()){
            if (p.getCategory().equals(this)){
                pictograms.add(p);
            }
        }
        return Collections.unmodifiableList(pictograms);
    }

}
