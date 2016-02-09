package ar.edu.unlp.info.hermescelascolus.models.dao;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import android.database.SQLException;
import android.widget.Toast;

/**
 * Created by laura on 09/02/16.
 */
public class CategoryDAO implements Dao<Category> {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public CategoryDAO(Context context) {
        dbHelper = DBHelper.getInstance(context);
    }

    public void open() {
        try {
            db = dbHelper.getWritableDatabase();
        }
        catch(SQLException e){

        }
    }

    public void close() {
        dbHelper.close();
    }

    public void addCategory(Category c){

    }

    public ArrayList<Category> all(){
        return null;
    }

    public Category getById(int id){
        return null;
    }
}
