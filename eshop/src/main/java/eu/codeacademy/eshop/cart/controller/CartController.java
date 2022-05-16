package eu.codeacademy.eshop.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
public class CartController {

    @GetMapping
    public String openCart(@ModelAttribute("cartSession") String cart) {
        return "/cart/cart";
    }

    @GetMapping("/add")
    public String addToCart(Model model) {
        model.addAttribute("cartSession", "Labas");

        return "redirect:/cart";
    }
}
