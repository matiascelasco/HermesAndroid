package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class PictogramDao extends GenericDao implements Dao<Pictogram>{

    public PictogramDao(Context context) {
        super(context);
    }

    private Pictogram loadFromCursor(Cursor cursor){
        Pictogram p = new Pictogram();
        p.setId(cursor.getInt(0));
        p.setImageId(cursor.getInt(0));
        p.setSoundId(cursor.getInt(0));
        p.setName(cursor.getString(1));
        p.setPath(cursor.getString(2));
        p.setCategory(Category.values()[cursor.getInt(3)]);

        return p;
    }

    @Override
    public List<Pictogram> all() {
        ArrayList<Pictogram> availablePictograms = new ArrayList<>();
        this.open();
        try {
            Cursor cursor = db.rawQuery("select * from pictograms order by name", null);
            while (cursor.moveToNext()) {
                availablePictograms.add(this.loadFromCursor(cursor));
            }
        }
        catch (SQLiteException e) {
            e.printStackTrace();
        }
        return availablePictograms;
    }

    @Override
    public Pictogram getById(long id) {
        return null;
    }

    @Override
    public void save(Pictogram pictogram) {
        this.open();
        ContentValues cv = new ContentValues();
        cv.put("name", pictogram.getName());
        cv.put("path", pictogram.getPath());
        cv.put("id_category", pictogram.getCategory().ordinal());

        // Inserting Row
        db.beginTransaction();
        long id = db.insert("Pictograms", null, cv);
        pictogram.setId((int) id);

        db.setTransactionSuccessful();
        db.endTransaction();
        this.close();
    }

}
