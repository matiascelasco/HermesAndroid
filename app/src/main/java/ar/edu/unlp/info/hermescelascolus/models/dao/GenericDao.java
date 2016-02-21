package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;

public class GenericDao {

    //from here
    protected Context context;
    protected SQLiteDatabase db;
    private DBHelper dbHelper;

    GenericDao(Context context){
        this.context = context;
        dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
    }

    protected void close() {
        dbHelper.close();
    }

    protected void delete(String tableName, String whereClause, String... whereArgs){
        db.delete(tableName, whereClause, whereArgs);
    }

    protected void update(String tableName, ContentValues contentValues, String whereClause, String... whereArgs){
        db.update(tableName, contentValues, whereClause, whereArgs);
    }

    protected Cursor rawQuery(String query, String... args){
        return db.rawQuery(query, args);
    }

}
