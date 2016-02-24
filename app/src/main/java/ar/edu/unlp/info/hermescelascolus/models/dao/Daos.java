package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.Context;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.Settings;
import ar.edu.unlp.info.hermescelascolus.models.connection.DBHelper;
import ar.edu.unlp.info.hermescelascolus.models.connection.KidSeeder;

public class Daos {

    public static Dao<Settings> SETTINGS;
    public static Dao<Kid> KID;
    public static Dao<Category> CATEGORY;
    public static Dao<Pictogram> PICTOGRAM;
    public static IManyToManyDao<Kid, Category> KID_CATEGORY;
    public static IManyToManyDao<Kid, Pictogram> KID_PICTOGRAM;

    public static void initialize(Context context){
        if (KID == null){
            SETTINGS = new SettingsDao(context);
            KID = new KidDao(context);
            CATEGORY = new CategoryDao();
            PICTOGRAM = new PictogramDao(context);
            KID_CATEGORY = new ManyToManyDao<>(
                    context,
                    "KidCategory",
                    "kid_id",
                    "category_id",
                    CATEGORY
            );
            KID_PICTOGRAM = new ManyToManyDao<>(
                    context,
                    "KidPictogram",
                    "kid_id",
                    "pictogram_id",
                    PICTOGRAM
            );
        }
    }

}
