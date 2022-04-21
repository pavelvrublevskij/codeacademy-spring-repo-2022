package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/products/open")
    public String openCrateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/products/open")
    public String createProduct(Model model, Product product) {
        return "hello";
    }
}
