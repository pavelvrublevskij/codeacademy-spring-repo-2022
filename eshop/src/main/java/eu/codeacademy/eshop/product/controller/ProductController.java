package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.model.Product;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

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

    @GetMapping("/update")
//    public String getUpdateProduct(Model model, @RequestParam UUID id)  ///also possible
    public String getUpdateProduct(Model model, @RequestParam("id") UUID productId) {
        model.addAttribute("product", productService.getProductByUUID(productId));
        return "product";
    }
}
