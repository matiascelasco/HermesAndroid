package ar.edu.unlp.info.hermescelascolus.validation;

interface IValidator<T> {
    boolean isValid(T t);
    String getMessage();
}
