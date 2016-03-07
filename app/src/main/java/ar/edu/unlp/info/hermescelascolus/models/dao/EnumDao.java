package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.Arrays;
import java.util.List;

public class EnumDao<T extends Enum<T>> implements Dao<T> {

    private Class<T> enumType;

    protected EnumDao(Class<T> enumType) {
        this.enumType = enumType;
    }


    @Override
    public List<T> all() {
        return Arrays.asList(enumType.getEnumConstants());
    }

    @Override
    public T getById(long id) {
        return enumType.getEnumConstants()[(int) id];
    }

    @Override
    public void save(T category) {
        throw new RuntimeException("Enum type instances can't be added or updated");
    }

    @Override
    public void delete(T category) {
        throw new RuntimeException("Enum type instances can't be deleted");
    }

}
