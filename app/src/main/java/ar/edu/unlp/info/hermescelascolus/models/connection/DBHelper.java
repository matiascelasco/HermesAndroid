package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Facu on 04/02/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    //for Singleton purposes
    private static DBHelper sInstance;

    private static final String DATABASE_NAME = "celascolus.db";
    private static final int DATABASE_VERSION = 1;


    private void createKidsTable(SQLiteDatabase db) {
        //creation of kids table
        /*db.execSQL("DROP TABLE IF EXISTS Categories;");*/
        db.execSQL("CREATE TABLE Kid ("+
                   "_id INTEGER PRIMARY KEY NOT NULL,"+
                   "name VARCHAR(50) NOT NULL, " +
                   "surname VARCHAR(20) NOT NULL, " +
                   "gender VARCHAR(1) NOT NULL, " +
                   "pictogramSize INTEGER NOT NULL);");
    }

    private void createGeneralSettingsTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE GeneralSettings ("+
                   "_id INTEGER PRIMARY KEY NOT NULL,"+
                   "ip_address VARCHAR(12) NOT NULL, " +
                   "port INTEGER NOT NULL"+");");

        //insert default data
        db.execSQL("INSERT INTO GeneralSettings(ip_address, port)"+
                   " VALUES('192.168.100.1','8080');");

    }

    private void createPictogramsTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE Pictograms ("+
                   "_id INTEGER PRIMARY KEY NOT NULL,"+
                   "name VARCHAR(20) NOT NULL, " +
                   "path VARCHAR(20) NOT NULL, "+
                   "id_category INTEGER NOT NULL"+
                   ");");
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
        this.createKidsTable(db);
        this.createGeneralSettingsTable(db);
        this.createPictogramsTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this method must execute if the database file exists, but the version is greater
        //than the new version
    }
}
