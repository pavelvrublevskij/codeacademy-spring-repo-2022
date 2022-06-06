package eu.codeacademy.eshop.advice;

import eu.codeacademy.eshop.EshopEndpoint;
import eu.codeacademy.eshop.controller.CartController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class GlobalModelAttributeAdvice {

    @ModelAttribute("modelDate")
    public Date now() {
        return new Date();
    }

    @ModelAttribute("currency")
    public char currency() {
        return '€';
    }

    @ModelAttribute("cartPath")
    public String cartPath() {
        return CartController.PUBLIC_CART_ROOT_PATH;
    }

    @ModelAttribute("productUpdatePath")
    public String productUpdatePath() {
        return EshopEndpoint.PRODUCT_UPDATE_PATH;
    }
}
