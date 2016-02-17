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

    private static void loadArray(){
        array = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);
            pictogram.setCategory(Category.NECESIDADES);

            array.add(pictogram);
        }

        for (int i = 7; i < 19; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);
            pictogram.setCategory(Category.EMOCIONES);

            array.add(pictogram);
        }

        for (int i = 19; i < 31; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);
            pictogram.setCategory(Category.ESTABLO);

            array.add(pictogram);
        }

        for (int i = 31; i < 43; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
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
    public Pictogram getById(int id) {
        if (array == null){
            loadArray();
        }
        return array.get(id - 1);
    }

    public void save(Pictogram p){}
}
