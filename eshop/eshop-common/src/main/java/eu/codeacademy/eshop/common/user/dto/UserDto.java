package eu.codeacademy.eshop.common.user.dto;

import eu.codeacademy.eshop.common.validator.FieldsStringCompare;
import eu.codeacademy.eshop.common.validator.PhoneNumber;
import eu.codeacademy.eshop.common.validator.PhoneType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
//@PasswordCompare
@FieldsStringCompare(
        firstField = "password",
        secondField = "repeatedPassword",
        message = "{validate.string.fields}")
public class UserDto {

    private String name;
    private String surname;

    @NotBlank
    @Email
    private String email;

    @Size(min = 6, max = 255)
    private String password;

    @Size(min = 6, max = 255)
    private String repeatedPassword;

    @NotBlank
    private String zipCode;

    @PhoneNumber(type = PhoneType.LOCAL)
    private String phoneNumber;
}
