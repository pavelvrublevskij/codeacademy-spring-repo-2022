package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String openCrateProductForm(Model model) {
        model.addAttribute("product", ProductDto.builder().build());

        return "product";
    }

    @PostMapping
    public String createProduct(Model model, ProductDto product) {
        productService.addProduct(product);
        model.addAttribute("product", ProductDto.builder().build());
        model.addAttribute("message", "Product added successfully!");
        return "product";
    }

    @GetMapping("/list")
    public String getProducts(Model model) {
        model.addAttribute("productList", productService.getProducts());

        return "products";
    }

    @GetMapping("/{productId}/update")
    public String getUpdateProduct(Model model, @PathVariable("productId") UUID id) {
        model.addAttribute("product", productService.getProductByUUID(id));

        return "product";
    }

    @PostMapping("/{productId}/update")
    public String getUpdateProduct(Model model, ProductDto product) {
        productService.updateProduct(product);
        model.addAttribute("productList", productService.getProducts());

        return "products";
    }

    @GetMapping("/{productId}/delete")
    public String deleteProduct(Model model, @PathVariable("productId") UUID id) {
        productService.deleteProduct(id);
        model.addAttribute("productList", productService.getProducts());

        return "products";
    }
}
