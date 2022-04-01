package my.home.webapp.service.validator;

import my.home.webapp.dto.CreateUserDto;
import my.home.webapp.entity.Gender;
import my.home.webapp.util.LocalDateFormatter;

public class CreateUserValidator implements Validator <CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    private CreateUserValidator(){}


    @Override
    public ValidationResult isValid(CreateUserDto object) {

        ValidationResult validationResult = new ValidationResult();

        if (!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("Invalid.birthday", "Birthday is invalid" ));
        }

        if (Gender.find(object.getGender()).isEmpty()){
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}
