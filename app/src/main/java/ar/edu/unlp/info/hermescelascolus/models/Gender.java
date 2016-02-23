package ar.edu.unlp.info.hermescelascolus.models;

import android.content.res.Resources;

import ar.edu.unlp.info.hermescelascolus.R;

public enum Gender {

    MALE("M", R.string.male),
    FEMALE("F", R.string.female);

    private int nameStringId;
    private String value;

    public int getNameStringId() {
        return nameStringId;
    }

    Gender(String value, int nameStringId){
        this.value = value;
        this.nameStringId = nameStringId;
    }

    public String getValue() {
        return value;
    }

    public static Gender getByValue(String value){
        for (Gender g: Gender.values()){
            if (g.getValue().equals(value)){
                return g;
            }
        }
        throw new RuntimeException(String.format("\"%s\" is not the value of any gender", value));
    }

    public String toString(){
        return value;
    }


}
