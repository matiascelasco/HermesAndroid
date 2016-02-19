package ar.edu.unlp.info.hermescelascolus.validation;

public abstract class Validator<T> implements IValidator<T> {
    private final String msg;

    public Validator(String msg){
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
