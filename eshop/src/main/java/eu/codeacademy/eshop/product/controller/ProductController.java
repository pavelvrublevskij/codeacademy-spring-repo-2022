package eu.codeacademy.eshop.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products/open")
    public String openCrateProductForm() {
        return "product";
    }
}
