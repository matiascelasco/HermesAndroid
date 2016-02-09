package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Facu on 04/02/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "celascolus.db";

    //for Singleton purposes
    private static DBHelper sInstance;

    private static final String DATABASE_NAME = "celascolus.db";
    private static final int DATABASE_VERSION = 1;


    private void createCategoriesTable(SQLiteDatabase db) {
        //creation of categories
        db.execSQL("CREATE TABLE Categories ("+
                "ID INTEGER PRIMARY KEY NOT NULL,"+
                "name VARCHAR(20) NOT NULL" + ");");
    }

    public static synchronized DBHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DBHelper(Context context) {
        //the constructor remains private for singleton implementation
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //this method must execute if the database file does not exists
        this.createCategoriesTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this method must execute if the database file exists, but the version is greater
        //than the new version
    }
}
