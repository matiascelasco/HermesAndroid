package ar.edu.unlp.info.hermescelascolus.validation;

public class ValidationError extends Exception {
    public ValidationError(String detailMessage) {
        super(detailMessage);
    }
}
