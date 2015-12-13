package ar.edu.unlp.info.hermescelascolus.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.Kid;

public class KidsArrayDao implements Dao<Kid> {

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
            kid.setId(i);
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
        return array.get(id);
    }
}
