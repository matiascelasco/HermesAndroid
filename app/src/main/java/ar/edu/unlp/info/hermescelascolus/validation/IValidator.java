package ar.edu.unlp.info.hermescelascolus.validation;

public interface IValidator<T> {
    boolean isValid(T t);
    String getMessage();
}
