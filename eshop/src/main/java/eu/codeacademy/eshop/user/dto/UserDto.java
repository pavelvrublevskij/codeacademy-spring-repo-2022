package eu.codeacademy.eshop.user.dto;

import eu.codeacademy.eshop.validator.PasswordCompare;
import eu.codeacademy.eshop.validator.PhoneNumber;
import eu.codeacademy.eshop.validator.PhoneType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@PasswordCompare
public class UserDto {

    private String name;
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 255)
    private String password;

    @NotBlank
    @Size(min = 6, max = 255)
    private String repeatedPassword;

    @NotBlank
    private String zipCode;

    @PhoneNumber(type = PhoneType.LOCAL)
    private String phoneNumber;
}
