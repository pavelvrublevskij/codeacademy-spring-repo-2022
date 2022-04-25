package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.model.Product;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String openCrateProductForm(Model model) {
        model.addAttribute("product", Product.builder().build());
        return "product";
    }

    @PostMapping
    public String createProduct(Model model, Product product) {
        productService.addProduct(product);
        return "hello";
    }

    @GetMapping("/list")
    public String getProducts(Model model) {
        model.addAttribute("productList", productService.getProducts());
        return "products";
    }
}
