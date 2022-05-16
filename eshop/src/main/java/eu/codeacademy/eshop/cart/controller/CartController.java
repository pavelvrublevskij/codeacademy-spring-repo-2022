package eu.codeacademy.eshop.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    @GetMapping
    public String openCart(HttpServletRequest request, Model model) {
        String cartSessionObjectValue = (String) request.getSession().getAttribute("cart");
        model.addAttribute("cartValue", cartSessionObjectValue);

        return "/cart/cart";
    }

    @GetMapping("/add")
    public String addToCart(Model model) {
        model.addAttribute("cart", "Labas");

        return "redirect:/cart";
    }
}
