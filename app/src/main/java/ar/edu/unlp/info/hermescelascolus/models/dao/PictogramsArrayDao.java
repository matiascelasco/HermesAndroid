package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class PictogramsArrayDao implements Dao<Pictogram> {

    private static Integer[] imageIds = {
            R.drawable.banio,
            R.drawable.dolorida,
            R.drawable.dolorido,
            R.drawable.cansada,
            R.drawable.cansado,
            R.drawable.triste_ninia,
            R.drawable.triste_ninio,
            R.drawable.sorprendida,
            R.drawable.sorprendido,
            R.drawable.sed_ninia,
            R.drawable.sed_ninio,
            R.drawable.asustada,
            R.drawable.asustado,
            R.drawable.contenta,
            R.drawable.contento,
            R.drawable.enojada,
            R.drawable.enojado,
            R.drawable.casco,
            R.drawable.cepillo,
            R.drawable.chapas,
            R.drawable.limpieza,
            R.drawable.letras,
            R.drawable.escarba_vasos,
            R.drawable.cubos,
            R.drawable.no,
            R.drawable.montura,
            R.drawable.matra,
            R.drawable.maracas,
            R.drawable.palos,
            R.drawable.pasto,
            R.drawable.pato,
            R.drawable.pelota,
            R.drawable.si,
            R.drawable.riendas,
            R.drawable.rasqueta_dura,
            R.drawable.rasqueta_blanda,
            R.drawable.caballo,
            R.drawable.caballo,
            R.drawable.caballo,
            R.drawable.burbujas,
            R.drawable.broches,
            R.drawable.aro,
            R.drawable.zanahoria,
            R.drawable.tarima
    };

    private static Integer[] soundIds ={
            R.raw.banio,
            R.raw.me_duele,
            R.raw.me_duele,
            R.raw.cansada,
            R.raw.cansado,
            R.raw.triste,
            R.raw.triste,
            R.raw.sorprendida,
            R.raw.sorprendido,
            R.raw.sed,
            R.raw.sed,
            R.raw.asustada,
            R.raw.asustado,
            R.raw.contenta,
            R.raw.contento,
            R.raw.enojada,
            R.raw.enojado,
            R.raw.casco,
            R.raw.cepillo,
            R.raw.chapas,
            R.raw.limpieza,
            R.raw.letras,
            R.raw.escarba_vasos,
            R.raw.cubos,
            R.raw.no,
            R.raw.montura,
            R.raw.matra,
            R.raw.maracas,
            R.raw.palos,
            R.raw.pasto,
            R.raw.pato,
            R.raw.pelota,
            R.raw.si,
            R.raw.riendas,
            R.raw.rasqueta_dura,
            R.raw.rasqueta_blanda,
            R.raw.caballo,
            R.raw.caballo,
            R.raw.caballo,
            R.raw.burbujas,
            R.raw.broches,
            R.raw.aro,
            R.raw.zanahoria,
            R.raw.tarima
    };

    
    private static List<Pictogram> array = null;

    private static void loadArray(){
        array = new ArrayList<>();
        Random random = new Random();
        List<Category> categories = Daos.CATEGORY.all();
        for (int i = 0; i < imageIds.length; i++){
            Pictogram pictogram = new Pictogram();
            pictogram.setId(i + 1);
            pictogram.setImageId(imageIds[i]);
            pictogram.setSoundId(soundIds[i]);
            pictogram.setCategory(categories.get(random.nextInt(categories.size())));

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


}
