package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.Pictogram;

public class KidsArrayDao implements Dao<Kid> {

    private static <T> List<T> randomSample(List<T> list){
        Random random = new Random();
        List<T> sample = new ArrayList<>();
        for (T elem: list) {
            if (random.nextInt(2) == 1){
                sample.add(elem);
            }
        }
        return sample;
    }

    private static List<String> names = Arrays.asList(
            "Jimi Hendrix",
            "Jimmy Page",
            "Jenny Gump",
            "Jimmy Carter",
            "Jimmy Olsen",
            "Jimmy James",
            "Jimmy Carrey (?)",
            "Jimmy Churry"
    );
    private static List<Kid> array = new ArrayList<>();
    static {
        for (int i = 0; i < names.size(); i++){
            Kid kid = new Kid();

            for (Pictogram p: randomSample(Daos.PICTOGRAM.all())) {
                kid.addPictogram(p);
            }

            /* for (Category2 c: randomSample(Category2.values().length)) {
                kid.addCategory(c);
            }*/
            kid.addCategory(Category.ESTABLO);

            kid.setId(i + 1);
            kid.setName(names.get(i));
            array.add(kid);
        }
    }

    @Override
    public List<Kid> all() {
        return new ArrayList<>(array);
    }

    @Override
    public Kid getById(int id) {
        return array.get(id - 1);
    }
}
