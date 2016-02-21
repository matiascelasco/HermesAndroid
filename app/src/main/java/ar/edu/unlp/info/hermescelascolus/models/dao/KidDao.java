package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Gender;
import ar.edu.unlp.info.hermescelascolus.models.Kid;

public class KidDao extends GenericDao implements Dao<Kid> {

    private static final String SELECT_QUERY =
            "SELECT _id, name, surname, gender, pictogramSize FROM Kid";

    public KidDao(Context context) {
        super(context);
    }

    public void save(Kid k){
        ContentValues cv = new ContentValues();
        cv.put("name", k.getName());
        cv.put("surname", k.getSurname());
        cv.put("gender", k.getGender().getValue());
        cv.put("pictogramSize", 0);

//        db.beginTransaction();

        if(k.getId() == 0) {
            long id = db.insert("Kid", null, cv);
            if (id == -1){
                throw new RuntimeException("DB error");
            }
            k.setId(id);
        } else { //the kid already exists
            update("Kid", cv, "_id = ?", String.valueOf(k.getId()));
        }

//        db.setTransactionSuccessful();
//        db.endTransaction();
    }

    @Override
    public void delete(Kid kid) {
        delete("Kid", "_id = ?", String.valueOf(kid.getId()));
    }

    private Kid loadFromCursor(Cursor cursor){
        Kid kid = new Kid();
        kid.setId(cursor.getInt(0));
        kid.setName(cursor.getString(1));
        kid.setSurname(cursor.getString(2));
        kid.setGender(Gender.getByValue(cursor.getString(3)));
        return kid;
    }

    @Override
    public List<Kid> all() {
        List<Kid> kids = new ArrayList<>();
        Cursor cursor = rawQuery(SELECT_QUERY);
        while (cursor.moveToNext()) {
             kids.add(this.loadFromCursor(cursor));
        }
        cursor.close();
        return kids;
    }

    @Override
    public Kid getById(long id) {
        Cursor cursor = rawQuery(SELECT_QUERY + " WHERE _id = ?", String.valueOf(id));
        if (cursor.moveToNext()) {
            Kid kid = loadFromCursor(cursor);
            cursor.close();
            return kid;
        } else {
            throw new RuntimeException(String.format("Kid with id %d not found", id));
        }
    }

}
