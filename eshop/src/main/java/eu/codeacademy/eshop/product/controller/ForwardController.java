package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForwardController {

    @GetMapping("/forwardExample")
    public String forwardExample(Model model) {
        model.addAttribute("product", ProductDto.builder().build());

        return "redirectExample";
    }

    @PostMapping("/forwardExample")
    public String createProduct(Model model, ProductDto product) {
        return "forward:/secondForwardExample";
    }

    @PostMapping("/secondForwardExample")
    public String secondForwardExample(Model model, ProductDto product) {
        model.addAttribute("product", product);
        return "hello";
    }
}
