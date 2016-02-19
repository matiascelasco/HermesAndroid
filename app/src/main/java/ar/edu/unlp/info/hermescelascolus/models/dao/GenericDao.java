package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;

public class GenericDao {

    //from here
    protected SQLiteDatabase db;
    private DBHelper dbHelper;

    GenericDao(Context context){
        dbHelper = DBHelper.getInstance(context);
    }

    protected void open() {
        try {
            db = dbHelper.getWritableDatabase();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    protected void close() {
        dbHelper.close();
    }
}
