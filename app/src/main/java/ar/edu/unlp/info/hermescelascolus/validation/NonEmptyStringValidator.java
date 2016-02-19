package ar.edu.unlp.info.hermescelascolus.validation;

public class NonEmptyStringValidator extends Validator<String> {

    public NonEmptyStringValidator(String msg) {
        super(msg);
    }

    @Override
    public boolean isValid(String s) {
        return !s.equals("");
    }
}
