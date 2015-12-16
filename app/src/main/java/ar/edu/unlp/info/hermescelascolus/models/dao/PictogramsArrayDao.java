package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class PictogramsArrayDao implements Dao<Pictogram> {

    private static Integer[] imageIds = {
            R.drawable.comunicador__0000_vector_smart_object,
            R.drawable.comunicador__0001_vector_smart_object,
            R.drawable.comunicador__0002_vector_smart_object,
            R.drawable.comunicador__0003_vector_smart_object,
            R.drawable.comunicador__0004_vector_smart_object,
            R.drawable.comunicador__0005_vector_smart_object,
            R.drawable.comunicador__0006_vector_smart_object,
            R.drawable.comunicador__0007_vector_smart_object,
            R.drawable.comunicador__0008_vector_smart_object,
            R.drawable.comunicador__0009_vector_smart_object,
            R.drawable.comunicador__0010_vector_smart_object,
            R.drawable.comunicador__0011_vector_smart_object,
            R.drawable.comunicador__0012_vector_smart_object,
            R.drawable.comunicador__0013_vector_smart_object,
            R.drawable.comunicador__0014_vector_smart_object,
            R.drawable.comunicador__0015_vector_smart_object,
            R.drawable.comunicador__0016_vector_smart_object,
            R.drawable.comunicador__0017_vector_smart_object,
            R.drawable.comunicador__0018_vector_smart_object,
            R.drawable.comunicador__0019_vector_smart_object,
            R.drawable.comunicador__0020_vector_smart_object,
            R.drawable.comunicador__0021_vector_smart_object,
            R.drawable.comunicador__0022_vector_smart_object,
            R.drawable.comunicador__0023_vector_smart_object,
            R.drawable.comunicador__0024_vector_smart_object,
            R.drawable.comunicador__0025_vector_smart_object,
            R.drawable.comunicador__0026_vector_smart_object,
            R.drawable.comunicador__0027_vector_smart_object,
            R.drawable.comunicador__0028_vector_smart_object,
            R.drawable.comunicador__0029_vector_smart_object,
            R.drawable.comunicador__0030_vector_smart_object,
            R.drawable.comunicador__0031_vector_smart_object,
            R.drawable.comunicador__0032_vector_smart_object,
            R.drawable.comunicador__0033_vector_smart_object,
            R.drawable.comunicador__0034_vector_smart_object,
            R.drawable.comunicador__0035_vector_smart_object,
            R.drawable.comunicador__0036_vector_smart_object,
            R.drawable.comunicador__0037_vector_smart_object,
            R.drawable.comunicador__0038_vector_smart_object,
            R.drawable.comunicador__0039_vector_smart_object,
            R.drawable.comunicador__0040_vector_smart_object,
            R.drawable.comunicador__0041_vector_smart_object,
            R.drawable.comunicador__0042_vector_smart_object,
            R.drawable.comunicador__0043_vector_smart_object
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
            //pictogram.setSoundId(soundIds[i]);
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
