package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ar.edu.unlp.info.hermescelascolus.R;

public class DBHelper extends SQLiteOpenHelper {
    //for Singleton purposes
    private static Context context;
    private static DBHelper sInstance;

    private static final String DATABASE_NAME = "celascolus.db";
    private static final int DATABASE_VERSION = 1;

    public static synchronized DBHelper getInstance(Context c) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            context = c;
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
        InputStream in = context.getResources().openRawResource(R.raw.schema);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuilder builder = new StringBuilder();
        try {
            while (reader.ready()) {
                String line = reader.readLine().trim();
                builder.append(line);
                if (line.length() > 0 && line.charAt(line.length() - 1) == ';'){
                    db.execSQL(builder.toString());
                    builder = new StringBuilder();
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this method must execute if the database file exists, but the version is greater
        //than the new version
    }
}
