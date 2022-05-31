package eu.codeacademy.eshop.product.model;

import eu.codeacademy.eshop.product.dto.ProductDto;

public class ProductDtoMother {

    private static final String NAME = "ProductName";

    public static ProductDto getPartial() {
        return ProductDto.builder()
                .name(NAME)
                .build();
    }

    public static ProductDto.ProductDtoBuilder getPartialBuilder() {
        return ProductDto.builder()
                .name(NAME);
    }
}
