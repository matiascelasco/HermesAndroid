package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.Context;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class PictogramDao extends GenericDao implements Dao<Pictogram>{

    public PictogramDao(Context context) {
        super(context);
    }

    @Override
    public List<Pictogram> all() {
        return null;
    }

    @Override
    public Pictogram getById(long id) {
        return null;
    }

    @Override
    public int save(Pictogram pictogram) {
        this.open();
        ContentValues cv = new ContentValues();
        return 0;
    }
}
