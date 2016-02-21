package ar.edu.unlp.info.hermescelascolus.models.connection;

import ar.edu.unlp.info.hermescelascolus.models.Gender;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class KidSeeder {

    public static void seed(){

        //add Stark family, the north remembers
        Kid kid = new Kid();
        kid.setName("Jon");
        kid.setSurname("Snow");
        kid.setGender(Gender.MALE);
        Daos.KID.save(kid);

        Kid kid2 = new Kid();
        kid2.setName("Eddard");
        kid2.setSurname("Stark");
        kid2.setGender(Gender.MALE);
        Daos.KID.save(kid2);

        Kid kid3 = new Kid();
        kid3.setName("Sansa");
        kid3.setSurname("Stark");
        kid3.setGender(Gender.FEMALE);
        Daos.KID.save(kid3);

        Kid kid4 = new Kid();
        kid4.setName("Arya");
        kid4.setSurname("Stark");
        kid4.setGender(Gender.FEMALE);
        Daos.KID.save(kid4);

        Kid kid5 = new Kid();
        kid5.setName("Rickon");
        kid5.setSurname("Stark");
        kid5.setGender(Gender.MALE);
        Daos.KID.save(kid5);

        Kid kid6 = new Kid();
        kid6.setName("Brandon");
        kid6.setSurname("Stark");
        kid6.setGender(Gender.MALE);
        Daos.KID.save(kid6);

        Kid kid7 = new Kid();
        kid7.setName("Robb CastamereRains");
        kid7.setSurname("Stark");
        kid7.setGender(Gender.MALE);
        Daos.KID.save(kid7);
    }
}
