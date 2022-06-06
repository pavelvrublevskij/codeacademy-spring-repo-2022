package eu.codeacademy.eshop.cart.service;

import eu.codeacademy.eshop.cart.dto.CartDto;
import eu.codeacademy.eshop.cart.dto.CartItem;
import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;

    public void addToCartByProductId(UUID productId, CartDto cart) {
        this.getCartItem(productId, cart.getCartItems()).ifPresentOrElse(
                CartItem::incrementQantity,
                () -> addProductToCart(productId, cart)
        );
    }

    private void addProductToCart(UUID productId, CartDto cart) {
        ProductDto productDto = productService.getProductByUUID(productId);
        cart.add(productDto);
    }

    private Optional<CartItem> getCartItem(UUID productId, List<CartItem> cartItems) {
        return cartItems.stream()
                .filter(ci -> ci.getProductDto().getProductId().equals(productId))
                .findAny();
    }
}
