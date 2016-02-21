package ar.edu.unlp.info.hermescelascolus.models.connection;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;
import ar.edu.unlp.info.hermescelascolus.models.dao.PictogramDao;

public class PictogramSeeder {

    private static final int NAME = 0;
    private static final int IMAGE_ID = 1;
    private static final int SOUND_ID = 2;

    private static Object table[][] = {
        {"no",              R.drawable.no,              R.raw.no},
        {"si",              R.drawable.si,              R.raw.si},
        {"banio",           R.drawable.banio,           R.raw.banio},
        {"sed_ninia",       R.drawable.sed_ninia,       R.raw.sed_ninia},
        {"sed_ninio",       R.drawable.sed_ninio,       R.raw.sed_ninio},
        {"cansada",         R.drawable.cansada,         R.raw.cansada},
        {"cansado",         R.drawable.cansado,         R.raw.cansado},
        {"dolorida",        R.drawable.dolorida,        R.raw.dolorida},
        {"dolorido",        R.drawable.dolorido,        R.raw.dolorido},
        {"triste_ninia",    R.drawable.triste_ninia,    R.raw.triste_ninia},
        {"triste_ninio",    R.drawable.triste_ninio,    R.raw.triste_ninio},
        {"sorprendida",     R.drawable.sorprendida,     R.raw.sorprendida},
        {"sorprendido",     R.drawable.sorprendido,     R.raw.sorprendido},
        {"asustada",        R.drawable.asustada,        R.raw.asustada},
        {"asustado",        R.drawable.asustado,        R.raw.asustado},
        {"contenta",        R.drawable.contenta,        R.raw.contenta},
        {"contento",        R.drawable.contento,        R.raw.contento},
        {"enojada",         R.drawable.enojada,         R.raw.enojada},
        {"enojado",         R.drawable.enojado,         R.raw.enojado},
        {"caballo",         R.drawable.caballo,         R.raw.caballo},
        {"casco",           R.drawable.casco,           R.raw.casco},
        {"cepillo",         R.drawable.cepillo,         R.raw.cepillo},
        {"zanahoria",       R.drawable.zanahoria,       R.raw.zanahoria},
        {"limpieza",        R.drawable.limpieza,        R.raw.limpieza},
        {"escarba_vasos",   R.drawable.escarba_vasos,   R.raw.escarba_vasos},
        {"montura",         R.drawable.montura,         R.raw.montura},
        {"matra",           R.drawable.matra,           R.raw.matra},
        {"pasto",           R.drawable.pasto,           R.raw.pasto},
        {"riendas",         R.drawable.riendas,         R.raw.riendas},
        {"rasqueta_dura",   R.drawable.rasqueta_dura,   R.raw.rasqueta_dura},
        {"rasqueta_blanda", R.drawable.rasqueta_blanda, R.raw.rasqueta_blanda},
        {"caballo",         R.drawable.caballo,         R.raw.caballo},
        {"caballo",         R.drawable.caballo,         R.raw.caballo},
        {"chapas",          R.drawable.chapas,          R.raw.chapas},
        {"burbujas",        R.drawable.burbujas,        R.raw.burbujas},
        {"broches",         R.drawable.broches,         R.raw.broches},
        {"aro",             R.drawable.aro,             R.raw.aro},
        {"letras",          R.drawable.letras,          R.raw.letras},
        {"maracas",         R.drawable.maracas,         R.raw.maracas},
        {"palos",           R.drawable.palos,           R.raw.palos},
        {"cubos",           R.drawable.cubos,           R.raw.cubos},
        {"pato",            R.drawable.pato,            R.raw.pato},
        {"pelota",          R.drawable.pelota,          R.raw.pelota},
        {"tarima",          R.drawable.tarima,          R.raw.tarima}
    };


    private static List<Pictogram> array;

    private static Category getCategory(int i){
        if (0 <= i && i <= 6){
            return Category.NECESIDADES;
        }
        if (7 <= i && i <= 18){
            return Category.EMOCIONES;
        }
        if (19 <= i && i <= 30){
            return Category.ESTABLO;
        }
        if (31 <= i && i <= 42){
            return Category.PISTA;
        }
        throw new RuntimeException(
                "Category not found for pictogram with order index " + String.valueOf(i)
        );
    }

    public static void seed(){
        for (int i = 0; i < 43; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setName((String) table[i][NAME]);
            pictogram.setImageId((int) table[i][IMAGE_ID]);
            pictogram.setSoundId((int) table[i][SOUND_ID]);
            pictogram.setCategory(getCategory(i));
            System.out.println(i);
            Daos.PICTOGRAM.save(pictogram);
        }
    }

}
