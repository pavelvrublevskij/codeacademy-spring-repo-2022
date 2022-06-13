package eu.codeacademy.eshop.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ProductsResponse {

    @ApiModelProperty(notes = "Products list", required = true, allowEmptyValue = false)
    private List<ProductDto> products;
}
