package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class PictogramsArrayDao implements Dao<Pictogram> {

    private static Integer[] imageIds = {
            R.drawable.no,
            R.drawable.si,
            //needs
            R.drawable.banio,
            R.drawable.sed_ninia,
            R.drawable.sed_ninio,
            R.drawable.cansada,
            R.drawable.cansado,
            //emotions
            R.drawable.dolorida,
            R.drawable.dolorido,
            R.drawable.triste_ninia,
            R.drawable.triste_ninio,
            R.drawable.sorprendida,
            R.drawable.sorprendido,
            R.drawable.asustada,
            R.drawable.asustado,
            R.drawable.contenta,
            R.drawable.contento,
            R.drawable.enojada,
            R.drawable.enojado,
            //barn
            R.drawable.caballo,
            R.drawable.casco,
            R.drawable.cepillo,
            R.drawable.zanahoria,
            R.drawable.limpieza,
            R.drawable.escarba_vasos,
            R.drawable.montura,
            R.drawable.matra,
            R.drawable.pasto,
            R.drawable.riendas,
            R.drawable.rasqueta_dura,
            R.drawable.rasqueta_blanda,
            //track
            R.drawable.caballo,
            R.drawable.caballo,
            R.drawable.chapas,
            R.drawable.burbujas,
            R.drawable.broches,
            R.drawable.aro,
            R.drawable.letras,
            R.drawable.maracas,
            R.drawable.palos,
            R.drawable.cubos,
            R.drawable.pato,
            R.drawable.pelota,
            R.drawable.tarima

    };

    private static Integer[] soundIds ={
            R.raw.no,
            R.raw.si,
            //needs
            R.raw.banio,
            R.raw.sed_ninia,
            R.raw.sed_ninio,
            R.raw.cansada,
            R.raw.cansado,
            //emotions
            R.raw.dolorida,
            R.raw.dolorido,
            R.raw.triste_ninia,
            R.raw.triste_ninio,
            R.raw.sorprendida,
            R.raw.sorprendido,
            R.raw.asustada,
            R.raw.asustado,
            R.raw.contenta,
            R.raw.contento,
            R.raw.enojada,
            R.raw.enojado,
            //barn
            R.raw.caballo,
            R.raw.casco,
            R.raw.cepillo,
            R.raw.zanahoria,
            R.raw.limpieza,
            R.raw.escarba_vasos,
            R.raw.montura,
            R.raw.matra,
            R.raw.pasto,
            R.raw.riendas,
            R.raw.rasqueta_dura,
            R.raw.rasqueta_blanda,
            //track
            R.raw.caballo,
            R.raw.caballo,
            R.raw.chapas,
            R.raw.burbujas,
            R.raw.broches,
            R.raw.aro,
            R.raw.letras,
            R.raw.maracas,
            R.raw.palos,
            R.raw.cubos,
            R.raw.pato,
            R.raw.pelota,
            R.raw.tarima
    };

    
    private static List<Pictogram> array = null;

    private static String getName(int id){
        String name;
        switch (id) {
            case 1:  name = "no";
                break;
            case 2:  name = "si";
                break;
            case 3:  name = "banio";
                break;
            case 4:  name = "sed_ninia";
                break;
            case 5:  name = "sed_ninio";
                break;
            case 6:  name = "cansada";
                break;
            case 7:  name = "cansado";
                break;
            case 8:  name = "dolorida";
                break;
            case 9:  name = "dolorido";
                break;
            case 10: name = "triste_ninia";
                break;
            case 11: name = "triste_ninio";
                break;
            case 12: name = "sorprendida";
                break;
            case 13: name = "sorprendido";
                break;
            case 14:  name = "asustada";
                break;
            case 15:  name = "asustado";
                break;
            case 16: name = "contenta";
                break;
            case 17: name = "contento";
                break;
            case 18: name = "enojada";
                break;
            case 19: name = "enojado";
                break;
            case 20:  name = "caballo";
                break;
            case 21:  name = "casco";
                break;
            case 22: name = "cepillo";
                break;
            case 23: name = "zanahoria";
                break;
            case 24: name = "limpieza";
                break;
            case 25: name = "escarba_vasos";
                break;
            case 26:  name = "montura";
                break;
            case 27:  name = "matra";
                break;
            case 28: name = "pasto";
                break;
            case 29: name = "riendas";
                break;
            case 30: name = "rasqueta_dura";
                break;
            case 31: name = "rasqueta_blanda";
                break;
            case 32: name = "caballo";
                break;
            case 33: name = "caballo";
                break;
            case 34: name = "chapas";
                break;
            case 35: name = "burbujas";
                break;
            case 36:  name = "broches";
                break;
            case 37:  name = "aro";
                break;
            case 38: name = "letras";
                break;
            case 39: name = "maracas";
                break;
            case 40: name = "palos";
                break;
            case 41: name = "cubos";
                break;
            case 42: name = "pato";
                break;
            case 43: name = "pelota";
                break;
            case 44: name = "tarima";
                break;
            default: name = "Invalid name";
                break;
        }
        return name;
    }

    private static void loadArray(){
        array = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setName(getName(i + 1));
            if ((i+1 == 1) || (i+1 == 2)){
                pictogram.setPath("/");
            }
            else
              pictogram.setPath("/barn");
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);

            pictogram.setCategory(Category.NECESIDADES);

            array.add(pictogram);
        }

        for (int i = 7; i < 19; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setName(getName(i + 1));
            pictogram.setPath("/emotions");
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);
            pictogram.setCategory(Category.EMOCIONES);

            array.add(pictogram);
        }

        for (int i = 19; i < 31; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setName(getName(i + 1));
            pictogram.setPath("/needs");
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);
            pictogram.setCategory(Category.ESTABLO);

            array.add(pictogram);
        }

        for (int i = 31; i < 43; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setName(getName(i + 1));
            pictogram.setPath("/track");
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);
            pictogram.setCategory(Category.PISTA);

            array.add(pictogram);
        }

    }

    @Override
    public List<Pictogram> all() {
        if (array == null){
            loadArray();
        }
        return new ArrayList<>(array);
    }

    @Override
    public Pictogram getById(long id) {
        if (array == null){
            loadArray();
        }
        return array.get((int) id - 1);
    }

    public void save(Pictogram p){ }
}
