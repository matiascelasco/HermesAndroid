package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class PictogramDao extends GenericDao implements Dao<Pictogram>{

    private static final String SELECT =
            "SELECT _id, category_id, name, image_id, sound_id FROM Pictogram";

    public PictogramDao(Context context) {
        super(context);
    }

    private Pictogram loadFromCursor(Cursor cursor){
        Pictogram p = new Pictogram();
        p.setId(cursor.getInt(0));
        p.setCategory(Daos.CATEGORY.getById(cursor.getInt(1)));
        p.setName(cursor.getString(2));
        p.setImageId(cursor.getInt(3));
        p.setSoundId(cursor.getInt(4));
        return p;
    }

    @Override
    public List<Pictogram> all() {
        ArrayList<Pictogram> pictograms = new ArrayList<>();
//        this.open();
        Cursor cursor = db.rawQuery(SELECT, null);
        while (cursor.moveToNext()) {
            pictograms.add(this.loadFromCursor(cursor));
        }
        cursor.close();
        return pictograms;
    }

    @Override
    public Pictogram getById(long id) {
//        this.open();
        Cursor cursor = rawQuery(SELECT + " WHERE _id = ?", String.valueOf(id));
        if (cursor.moveToNext()) {
            Pictogram p = this.loadFromCursor(cursor);
            cursor.close();
            return p;
        } else {
            throw new RuntimeException(String.format("Pictogram with id %d not found", id));
        }
    }

    @Override
    public void save(Pictogram pictogram) {
//        this.open();
        ContentValues cv = new ContentValues();
        cv.put("name", pictogram.getName());
        Category category = pictogram.getCategory();
        if (category == null){
            cv.put("category_id", "null");
        }
        else {
            cv.put("category_id", category.getId());
        }
        cv.put("image_id", pictogram.getImageId());
        cv.put("sound_id", pictogram.getSoundId());

        // Inserting Row
        db.beginTransaction();
        long id = db.insert("Pictogram", null, cv);
        if (id == -1){
            throw new RuntimeException("DB error");
        }
        pictogram.setId(id);

        db.setTransactionSuccessful();
        db.endTransaction();
//        this.close();
    }

    @Override
    public void delete(Pictogram pictogram) {
        delete("Kid", "_id = ?", String.valueOf(pictogram.getId()));
    }

}
