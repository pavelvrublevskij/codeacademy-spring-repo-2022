package eu.codeacademy.eshop.product.utils;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class CustomErrorViewResolver extends DefaultErrorAttributes implements ErrorViewResolver {

    private Map<String, Object> springAttributesMap;

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        springAttributesMap = super.getErrorAttributes(webRequest, options);
        return springAttributesMap;
    }

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if (status.equals(HttpStatus.NOT_FOUND)) {
            return new ModelAndView("error/404");
        }

        springAttributesMap.put("myCustomText", "Is my any Text or Object");
        return new ModelAndView("customErrorPage", springAttributesMap);
    }
}
