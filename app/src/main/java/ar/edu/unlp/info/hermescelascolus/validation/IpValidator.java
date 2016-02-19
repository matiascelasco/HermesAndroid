package ar.edu.unlp.info.hermescelascolus.validation;

public class IpValidator extends RegexValidator {
    public IpValidator(String msg) {
        super(msg, "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    }
}
