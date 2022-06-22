package eu.codeacademy.eshop.security.jwt.controller;

import eu.codeacademy.eshop.commons.swagger.annotation.OpenApi;
import eu.codeacademy.eshop.security.jwt.dto.LoginResponse;
import eu.codeacademy.eshop.security.jwt.dto.UserRoleDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@OpenApi
public class LoginController {

    @PostMapping
    public LoginResponse login(@AuthenticationPrincipal UserRoleDto userRoleDto) {
        return new LoginResponse(userRoleDto);
    }
}
