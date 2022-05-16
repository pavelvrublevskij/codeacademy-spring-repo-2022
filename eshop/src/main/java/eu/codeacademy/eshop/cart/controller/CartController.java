package eu.codeacademy.eshop.cart.controller;

import eu.codeacademy.eshop.product.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
public class CartController {

    @ModelAttribute("cartSession")
    public List<ProductDto> createCart() {
//        return Collections.emptyList();
        return List.of(ProductDto.builder()
                        .name("Testas")
                .build());
    }

    @GetMapping
    public String openCart(@ModelAttribute("cartSession") List<ProductDto> cart) {
        return "/cart/cart";
    }

/*    @GetMapping("/add")
    public String addToCart(Model model) {
        model.addAttribute("cartSession", "Labas");

        return "redirect:/cart";
    }*/
}
