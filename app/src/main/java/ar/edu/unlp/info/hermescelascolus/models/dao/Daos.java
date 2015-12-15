package ar.edu.unlp.info.hermescelascolus.models.dao;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class Daos {

    public static final Dao<Kid> KID = new KidsArrayDao();
    public static final Dao<Pictogram> PICTOGRAM = new PictogramsArrayDao();
    public static final Dao<Category> CATEGORY = new CategoriesArrayDao();

}
