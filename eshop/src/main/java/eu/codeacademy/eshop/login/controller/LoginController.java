package eu.codeacademy.eshop.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("login-eshop")
    public String openLoginPage() {
        return "login/login";
    }
}
