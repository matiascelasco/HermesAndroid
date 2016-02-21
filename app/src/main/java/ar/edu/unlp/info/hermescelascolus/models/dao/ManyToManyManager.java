package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ManyToManyManager<T> {
    private Set<T> originalSet;
    private Set<T> currentSet;

    public ManyToManyManager(){
        originalSet = new HashSet<>();
        currentSet =  new HashSet<>();
    }

    public ManyToManyManager(Collection<T> initialSet){
        originalSet = new HashSet<>(initialSet);
        currentSet =  new HashSet<>(initialSet);
    }

    public void add(T t){
        currentSet.add(t);
    }

    public void remove(T t){
        currentSet.remove(t);
    }

    public Set<T> addedOnes(){
        Set<T> s = new HashSet<>(currentSet);
        s.removeAll(originalSet);
        return s;
    }

    public Set<T> removedOnes(){
        Set<T> s = new HashSet<>(originalSet);
        s.removeAll(currentSet);
        return s;
    }

    public Set<T> getCurrentOnes(){
        return  new HashSet<>(currentSet);
    }

    public void setCurrentOnes(Collection<T> currentSet){
        this.currentSet = new HashSet<>(currentSet);
    }

}
