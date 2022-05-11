package eu.codeacademy.eshop.user.controller;

import eu.codeacademy.eshop.user.dto.UserDto;
import eu.codeacademy.eshop.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserValidator validator;

    @GetMapping
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());

        return "/user/user";
    }

    @PostMapping
    public String register(@Valid UserDto userDto, BindingResult errors) {
        validator.validate(userDto, errors);
        if (errors.hasErrors()) {
            return "/user/user";
        }

        return "redirect:/user";
    }
}
