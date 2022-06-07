package eu.codeacademy.eshop.api.dto;

import eu.codeacademy.eshop.common.product.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ProductsResponse {

    private List<ProductDto> products;
}
