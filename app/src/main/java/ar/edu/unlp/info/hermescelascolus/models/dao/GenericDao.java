package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;

/**
 * Created by Facu on 17/02/2016.
 */
public class GenericDao {

    //from here
    protected SQLiteDatabase db;
    protected DBHelper dbHelper;

    public GenericDao(Context context){
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
}
