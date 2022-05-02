package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirectExample")
    public String redirectExample(Model model) {
        model.addAttribute("product", ProductDto.builder().build());

        return "redirectExample";
    }

    @PostMapping("/redirectExample")
    public String createProduct(Model model, ProductDto product) {
        return "redirect:/secondRedirectExample";
    }

    @GetMapping("/secondRedirectExample")
    public String secondRedirectExample(Model model, ProductDto product) {
        model.addAttribute("product", product);
        return "redirectExample";
    }
}
