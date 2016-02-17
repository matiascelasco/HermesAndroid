package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;

/**
 * Created by laura on 16/02/16.
 */
public class KidDao implements Dao<Kid> {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public KidDao(Context context) {
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

    public void addKid(Kid k){
        this.open();
        ContentValues cv = new ContentValues();
        cv.put("name",k.getName());
        cv.put("surname", k.getSurname());
        cv.put("gender",k.getGender());

       /*db.execSQL("INSERT INTO Kid(name, surname, gender, pictogramSize) " +
                    "VALUES(" + k.getName() + " , "+k.getSurname()+" ,"+ k.getGender()+" , 0 );");*/

        // Inserting Row
        db.insert("Kid", null, cv);
        this.close();
        }

    @Override
    public List<Kid> all() {
        return null;
    }

    @Override
    public Kid getById(int id) {
        return null;
    }
}
