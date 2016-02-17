package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;

import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;
import ar.edu.unlp.info.hermescelascolus.models.dao.PictogramDao;

/**
 * Created by Facu on 17/02/2016.
 */
public class PictogramSeeder {

    public PictogramSeeder(Context context){
        //this method load all the pictograms in the database
        PictogramDao picDao = new PictogramDao(context);
        for(Pictogram p:  Daos.PICTOGRAM.all()){
            picDao.save(p);
        }

    }

}
