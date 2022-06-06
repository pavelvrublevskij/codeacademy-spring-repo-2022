package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductService productService;

    @ResponseBody
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE) // by default produces JSON MIME type
    public List<ProductDto> getJsonProducts() {
        return productService.getProducts();
    }

    @ResponseBody
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE) // by default produces JSON MIME type
    public List<ProductDto> getXmlProducts() {
        return productService.getProducts();
    }
}
