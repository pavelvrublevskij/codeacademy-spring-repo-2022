package eu.codeacademy.eshop.welcome.controller;

import eu.codeacademy.eshop.config.CompanyConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final CompanyConfig companyConfig;

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("companyData", companyConfig);
        return "welcome/hello";
    }
}
