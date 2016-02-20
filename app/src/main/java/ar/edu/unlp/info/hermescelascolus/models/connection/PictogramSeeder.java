package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;

import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;
import ar.edu.unlp.info.hermescelascolus.models.dao.PictogramDao;

public class PictogramSeeder {

    public static void seed(Context context){
        //this method load all the pictograms in the database
        PictogramDao picDao = new PictogramDao(context);
        for(Pictogram p:  Daos.PICTOGRAM.all()){
            picDao.save(p);
        }

    }

}
