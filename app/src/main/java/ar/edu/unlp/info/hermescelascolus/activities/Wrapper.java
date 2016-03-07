package ar.edu.unlp.info.hermescelascolus.activities;

public class Wrapper<T> {
    private String string;
    private T value;
    public Wrapper(String string, T value) {
        this.string = string;
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    @Override
    public String toString() {
        return string;
    }
}

