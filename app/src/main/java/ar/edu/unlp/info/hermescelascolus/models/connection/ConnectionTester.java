package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.dao.CategoryDAO;

/**
 * Created by Facu on 09/02/2016.
 */
public class ConnectionTester {

    public ConnectionTester(Context context){
        CategoryDAO catDAO = new CategoryDAO(context);
        Category c = new Category();
        c.setId(1);;
        c.setName("establo1234");
        catDAO.addCategory(c);
    }
}
