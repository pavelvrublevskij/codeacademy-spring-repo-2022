package eu.codeacademy.eshop.user.dto;

import eu.codeacademy.eshop.validator.PhoneNumber;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String zipCode;

    @PhoneNumber
    private String phoneNumber;
}
