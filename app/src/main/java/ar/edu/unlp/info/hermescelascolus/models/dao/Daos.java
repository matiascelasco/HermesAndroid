package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.Context;

import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;
import ar.edu.unlp.info.hermescelascolus.models.connection.KidSeeder;
import ar.edu.unlp.info.hermescelascolus.models.connection.PictogramSeeder;

public class Daos {
    public static Dao<Kid> KID;
    //public static Dao<Pictogram> PICTOGRAM;

    public static void initialize(Context context){
        if (KID == null){
            KID = new KidDao(context);
            //testing
            context.deleteDatabase(DBHelper.DATABASE_NAME);
            KidSeeder.seed(context);
            PictogramSeeder.seed(context);
           // PICTOGRAM = new PictogramDao(context);
        }
    }
    // The order is important!
    // PictogramsArrayDao needs CATEGORY to exists first and
    // KidDao needs PICTOGRAM to exists first too
    public static final Dao<Pictogram> PICTOGRAM = new PictogramsArrayDao();

}
