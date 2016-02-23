package ar.edu.unlp.info.hermescelascolus.activities;

import ar.edu.unlp.info.hermescelascolus.models.Gender;

public class GenderWrapper {
    private String string;
    private Gender gender;
    public GenderWrapper(String string, Gender gender) {
        this.string = string;
        this.gender = gender;
    }

    public Gender getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return string;
    }
}
