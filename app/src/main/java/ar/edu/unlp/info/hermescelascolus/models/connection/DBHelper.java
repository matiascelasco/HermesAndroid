package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Facu on 04/02/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "celascolus.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
}
    @Override
    public void onCreate(SQLiteDatabase db) {
        //
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //
    }
}
