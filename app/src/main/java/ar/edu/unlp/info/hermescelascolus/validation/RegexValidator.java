package ar.edu.unlp.info.hermescelascolus.validation;

public class RegexValidator extends Validator<String> {

    private final String regex;

    public RegexValidator(String msg, String regex){
        super(msg);
        this.regex = regex;
    }

    @Override
    public boolean isValid(String s) {
        return s.matches(regex);
    }
}
