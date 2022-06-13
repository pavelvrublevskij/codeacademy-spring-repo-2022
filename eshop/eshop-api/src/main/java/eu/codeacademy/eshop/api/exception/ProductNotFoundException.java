package eu.codeacademy.eshop.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

//@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
@Getter
public class ProductNotFoundException extends RuntimeException {

    private final UUID productId;
}
