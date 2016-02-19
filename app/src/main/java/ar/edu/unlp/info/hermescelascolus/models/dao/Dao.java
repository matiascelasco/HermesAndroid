package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.List;

public interface Dao <T>{

    List<T> all();

    T getById(int id);

    int save(T t);
}
