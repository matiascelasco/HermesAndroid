package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.List;

public interface Dao <T>{

    List<T> all();
    T getById(long id);
    void save(T t);
    void delete(T t);

}
