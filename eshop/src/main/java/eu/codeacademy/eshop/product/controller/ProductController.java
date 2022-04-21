package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.model.Product;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/open")
    public String openCrateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/products/open")
    public String createProduct(Model model, Product product) {
        productService.addProduct(product);
        return "hello";
    }
}
