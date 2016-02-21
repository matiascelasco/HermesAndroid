package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.Collection;

public interface IManyToManyDao<A, B> {

    Collection<B> getRelated(A a);
    void setRelated(A a, Collection<B> bs);
    void add(A a, B b);
    void remove(A a, B b);

}
