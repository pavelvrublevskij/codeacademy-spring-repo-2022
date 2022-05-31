package eu.codeacademy.eshop.user.controller;

import eu.codeacademy.eshop.user.dto.UserDto;
import eu.codeacademy.eshop.user.service.UserRegistrationService;
import eu.codeacademy.eshop.validator.spring.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import static eu.codeacademy.eshop.EshopEndpoint.USERS_REGISTER_PATH;
import static eu.codeacademy.eshop.EshopEndpoint.USERS_ROOT_PATH;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserValidator validator;
    private final UserRegistrationService userRegistrationService;

    @GetMapping(USERS_REGISTER_PATH)
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());

        return "/user/user";
    }

    @PostMapping(USERS_REGISTER_PATH)
    public String register(@Valid UserDto userDto, BindingResult errors) {
        validator.validate(userDto, errors);
        if (errors.hasErrors()) {
            return "/user/user";
        }

        userRegistrationService.register(userDto);

        return "redirect:" + USERS_ROOT_PATH;
    }
}
