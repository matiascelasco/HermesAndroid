package ar.edu.unlp.info.hermescelascolus.dao;

import java.util.List;

public interface Dao <T>{

    List<T> all();

    T getById(int id);
}
