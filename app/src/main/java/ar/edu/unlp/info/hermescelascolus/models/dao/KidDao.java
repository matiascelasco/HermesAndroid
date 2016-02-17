package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;

/**
 * Created by laura on 16/02/16.
 */
public class KidDao implements Dao<Kid> {
    //from here
    protected SQLiteDatabase db;
    protected DBHelper dbHelper;

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

    public KidDao(Context context) {
        dbHelper = DBHelper.getInstance(context);
    }

    private static <T> List<T> randomSample(List<T> list){
        Random random = new Random();
        List<T> sample = new ArrayList<>();
        for (T elem: list) {
            if (random.nextInt(2) == 1){
                sample.add(elem);
            }
        }
        return sample;
    }

    public void save(Kid k){
        this.open();
        ContentValues cv = new ContentValues();
        cv.put("name",k.getName());
        cv.put("surname", k.getSurname());
        cv.put("gender",k.getGender());
        cv.put("pictogramSize",0);

        // Inserting Row
        try{
            db.beginTransaction();
            if(k.getId() == 0) {
                db.insert("Kid", null, cv);
            }
            else{ //the kid already exists
                db.update("Kid", cv, "_id=" + k.getId(), null);
            }
            db.setTransactionSuccessful();
        }catch (SQLiteException e){
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        this.close();
        }

    @Override
    public List<Kid> all() {
        ArrayList<Kid> kids = new ArrayList<>();
        this.open();
        try {
            Cursor cursor = db.rawQuery("SELECT _id, name, surname, gender, pictogramSize FROM Kid", null);

            while (cursor.moveToNext()) {
                 Kid k = new Kid();
                 k.setId(Integer.parseInt(cursor.getString(0)));
                 k.setName(cursor.getString(1));
                 k.setSurname(cursor.getString(2));
                 k.setGender(cursor.getString(3));
                 //category random
                 for (Category c : randomSample(Arrays.asList(Category.values()))) {
                     k.addCategory(c);
                 }
                 for (Pictogram p: randomSample(Daos.PICTOGRAM.all())) {
                     k.addPictogram(p);
                 }
                 // Adding kid to list
                 kids.add(k);
            }
        }
        catch (SQLiteException e) {
            e.printStackTrace();
        }
        return kids;
        //return Daos.KID.all();
    }

    @Override
    public Kid getById(int id) {
        Kid k = new Kid();
        this.open();
        try {
            Cursor cursor = db.rawQuery("SELECT _id, name, surname, gender, pictogramSize FROM Kid where _id =?",new String [] {String.valueOf(id)});
            if (cursor.moveToNext()) {
                k.setId(Integer.parseInt(cursor.getString(0)));
                k.setName(cursor.getString(1));
                k.setSurname(cursor.getString(2));
                k.setGender(cursor.getString(3));
                //category random
                for (Category c : randomSample(Arrays.asList(Category.values()))) {
                    k.addCategory(c);
                }
                for (Pictogram p: randomSample(Daos.PICTOGRAM.all())) {
                    k.addPictogram(p);
                }
            }
        }
        catch (SQLiteException e) {
            e.printStackTrace();
        }
        return k;
    }
}
