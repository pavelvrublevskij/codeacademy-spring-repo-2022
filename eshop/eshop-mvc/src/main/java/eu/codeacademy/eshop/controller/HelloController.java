package eu.codeacademy.eshop.controller;

import eu.codeacademy.eshop.common.config.CompanyConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Log4j2
public class HelloController {

    private final CompanyConfig companyConfig;

    @GetMapping
    public String hello(Model model) {
        log.atInfo().log(" ------> Company cities: {}",
                companyConfig.getCompanyCities().stream().map(String::new).collect(Collectors.joining()));

        model.addAttribute("companyData", companyConfig);
        return "welcome/hello";
    }
}
