package eu.codeacademy.eshop.controller;

import eu.codeacademy.eshop.EshopEndpoint;
import eu.codeacademy.eshop.common.cart.dto.CartDto;
import eu.codeacademy.eshop.common.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.UUID;

@Controller
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

    private static final String CART_ROOT_PATH = "/cart";
    public static final String PUBLIC_CART_ROOT_PATH = EshopEndpoint.PUBLIC_WORKSPACE + CART_ROOT_PATH;

    private final CartService cartService;

    @ModelAttribute("cartSession")
    public CartDto createCart() {
        return new CartDto();
    }

    @GetMapping(PUBLIC_CART_ROOT_PATH)
    public String openCart(@ModelAttribute("cartSession") CartDto cart,
                           Principal principal, Authentication authentication) {
        return "/cart/cart";
    }

    @PostMapping(PUBLIC_CART_ROOT_PATH + "/{productId}")
    public String addToCart(@PathVariable UUID productId, @ModelAttribute("cartSession") CartDto cart) {
        cartService.addToCartByProductId(productId, cart);

        return "redirect:" + EshopEndpoint.PRODUCT_LIST_PATH;
    }

    @PostMapping(CART_ROOT_PATH + "/order")
    public String order(SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        //TODO: save into DB or do another things with cart data

        sessionStatus.setComplete();

        redirectAttributes.addFlashAttribute("successMessage", "cart.order.message.success");

        return "redirect:" + EshopEndpoint.PRODUCT_LIST_PATH;
    }
}
