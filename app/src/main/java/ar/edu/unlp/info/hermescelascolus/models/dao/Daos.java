package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.Context;

import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class Daos {
    public static Dao<Kid> KID;

    public static void initialize(Context context){
        KID = new KidDao(context);
    }
    // The order is important!
    // PictogramsArrayDao needs CATEGORY to exists first and
    // KidDao needs PICTOGRAM to exists first too
    public static final Dao<Pictogram> PICTOGRAM = new PictogramsArrayDao();

}
