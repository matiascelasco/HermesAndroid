package ar.edu.unlp.info.hermescelascolus.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

/**
 * Created by laura on 14/02/16.
 */
public enum Category2 {
    PISTA (1),
    ESTABLO (2),
    NECESIDADES (3),
    EMOCIONES (4);

    private int identifier;

    private Category2(int value){
        this.identifier = value;
    }


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
