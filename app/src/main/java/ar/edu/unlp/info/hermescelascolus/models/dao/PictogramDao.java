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
public class PictogramDao implements Dao<Pictogram>{

    //from here
    protected SQLiteDatabase db;
    protected DBHelper dbHelper;

    public PictogramDao(Context context) {
        dbHelper = DBHelper.getInstance(context);
    }

    public void open() {
        try {
            db = dbHelper.getWritableDatabase();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        dbHelper.close();
    }

    //to here

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
