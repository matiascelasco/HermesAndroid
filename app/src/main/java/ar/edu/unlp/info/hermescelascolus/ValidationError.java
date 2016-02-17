package ar.edu.unlp.info.hermescelascolus;

/**
 * Created by laura on 17/02/16.
 */
public class ValidationError extends Exception {
    public ValidationError(String detailMessage) {
        super(detailMessage);
    }
}
