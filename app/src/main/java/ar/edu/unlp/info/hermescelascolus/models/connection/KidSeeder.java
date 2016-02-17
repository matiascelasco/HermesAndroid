package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;

import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;
import ar.edu.unlp.info.hermescelascolus.models.dao.KidDao;

public class KidSeeder {

    public KidSeeder(Context context){
        KidDao kidDAO = new KidDao(context);
        //add Stark family, the north remembers
        Kid kid = new Kid();
        kid.setName("Jon");
        kid.setSurname("Snow");
        kid.setGender("M");
        kidDAO.save(kid);
        //
        Kid kid2 = new Kid();
        kid2.setName("Eddard");
        kid2.setSurname("Stark");
        kid2.setGender("M");
        kidDAO.save(kid2);
        //
        Kid kid3 = new Kid();
        kid3.setName("Sansa");
        kid3.setSurname("Stark");
        kid3.setGender("F");
        kidDAO.save(kid3);
        //
        Kid kid4 = new Kid();
        kid4.setName("Arya");
        kid4.setSurname("Stark");
        kid4.setGender("F");
        kidDAO.save(kid4);
        //
        Kid kid5 = new Kid();
        kid5.setName("Rickon");
        kid5.setSurname("Stark");
        kid5.setGender("M");
        kidDAO.save(kid5);
        //
        Kid kid6 = new Kid();
        kid6.setName("Brandon");
        kid6.setSurname("Stark");
        kid6.setGender("M");
        kidDAO.save(kid6);
        //
        Kid kid7 = new Kid();
        kid7.setName("Robb CastamereRains");
        kid7.setSurname("Stark");
        kid7.setGender("M");
        kidDAO.save(kid7);
    }
}
