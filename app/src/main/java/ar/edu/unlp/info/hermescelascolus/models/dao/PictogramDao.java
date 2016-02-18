package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;

/**
 * Created by Facu on 17/02/2016.
 */
public class PictogramDao extends GenericDao implements Dao<Pictogram>{

    public PictogramDao(Context context) {
        super(context);
    }

    @Override
    public List<Pictogram> all() {
        return null;
    }

    @Override
    public Pictogram getById(int id) {
        return null;
    }

    @Override
    public void save(Pictogram pictogram) {
        this.open();
        ContentValues cv = new ContentValues();
        //
    }
}
