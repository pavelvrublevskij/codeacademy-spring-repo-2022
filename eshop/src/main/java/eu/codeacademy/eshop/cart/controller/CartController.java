package eu.codeacademy.eshop.cart.controller;

import eu.codeacademy.eshop.cart.dto.CartDto;
import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

    private final ProductService productService;

    @ModelAttribute("cartSession")
    public CartDto createCart() {
        return new CartDto();
    }

    @GetMapping
    public String openCart(@ModelAttribute("cartSession") CartDto cart) {
        return "/cart/cart";
    }

    @PostMapping("/{productId}")
    public String addToCart(@PathVariable UUID productId, @ModelAttribute("cartSession") CartDto cart) {
        ProductDto productDto = productService.getProductByUUID(productId);
        cart.add(productDto);

        return "redirect:/products/list";
    }
}
