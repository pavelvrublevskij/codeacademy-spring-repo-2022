package eu.codeacademy.eshop.product.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductDto {

    private UUID productId;

    @NotBlank(message = "{name.blank}")
    @Size(
            min = 3,
            max = 40,
            message = "Name turi buti daugiau nei {min} ir maziau nei {max}"
    )
    private String name;

    private Integer quantity;
    private BigDecimal price;
    private String description;
}
