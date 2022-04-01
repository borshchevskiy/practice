package my.home.webapp.service.validator;

public interface Validator <T>{
    ValidationResult isValid(T object);
}
