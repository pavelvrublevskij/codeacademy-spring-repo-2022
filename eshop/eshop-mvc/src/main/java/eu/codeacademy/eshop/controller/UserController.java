package eu.codeacademy.eshop.controller;

import eu.codeacademy.eshop.EshopEndpoint;
import eu.codeacademy.eshop.common.user.dto.UserDto;
import eu.codeacademy.eshop.common.user.service.UserRegistrationService;
import eu.codeacademy.eshop.common.validator.spring.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserValidator validator;
    private final UserRegistrationService userRegistrationService;

    @GetMapping(EshopEndpoint.USERS_REGISTER_PATH)
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());

        return "/user/user";
    }

    @PostMapping(EshopEndpoint.USERS_REGISTER_PATH)
    public String register(@Valid UserDto userDto, BindingResult errors) {
        validator.validate(userDto, errors);
        if (errors.hasErrors()) {
            return "/user/user";
        }

        userRegistrationService.register(userDto);

        return "redirect:" + EshopEndpoint.USERS_ROOT_PATH;
    }
}
