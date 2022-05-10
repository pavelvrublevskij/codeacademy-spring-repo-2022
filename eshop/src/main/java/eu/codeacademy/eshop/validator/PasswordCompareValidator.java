package eu.codeacademy.eshop.validator;

import eu.codeacademy.eshop.user.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordCompareValidator implements ConstraintValidator<PasswordCompare, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        return userDto.getPassword().equals(userDto.getRepeatedPassword());
    }
}
