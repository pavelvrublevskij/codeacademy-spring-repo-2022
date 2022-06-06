package eu.codeacademy.eshop.product.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductDto {

    private UUID productId;

    @NotBlank(message = "{validate.name.blank}")
    @Size(
            min = 3,
            max = 40,
            message = "{validate.name.size}"
    )
    private String name;

    @PositiveOrZero
    @Max(value = 1000)
    @NotNull
    private Integer quantity;

    @Positive
    @NotNull
    private BigDecimal price;

    @NotBlank
    private String description;
}
