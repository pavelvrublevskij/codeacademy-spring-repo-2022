package eu.codeacademy.eshop.advice;

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
}
