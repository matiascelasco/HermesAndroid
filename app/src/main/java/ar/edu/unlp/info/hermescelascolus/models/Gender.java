package ar.edu.unlp.info.hermescelascolus.models;

public enum Gender {

    MALE("M", "Masculino"),
    FEMALE("F", "Femenino");

    private String name;
    private String value;

    Gender(String value, String name){
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Gender getByValue(String value){
        for (Gender g: Gender.values()){
            if (g.getValue().equals(value)){
                return g;
            }
        }
        throw new RuntimeException(String.format("\"%s\" is not the value of any gender", value));
    }

    @Override
    public String toString(){
        return name;
    }


}
