package eu.codeacademy.eshop;

import eu.codeacademy.eshop.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public String productNotFound(ProductNotFoundException e, Model model) {
        model.addAttribute("productId", e.getProductId());
        return "product/error/productNotFound";
    }
}
