package eu.codeacademy.eshop.common.cart.dto;

import eu.codeacademy.eshop.common.product.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CartItem {

    private final ProductDto productDto;
    private Integer quantity;

    public void incrementQantity() {
        quantity++;
    }

    public BigDecimal getItemTotalPrice() {
        return productDto.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
