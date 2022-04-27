package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.entity.Product;
import eu.codeacademy.eshop.product.mapper.ProductMapper;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public void addProduct(ProductDto productDto) {
        productRepository.save(Product.builder()
                .productId(UUID.randomUUID())
                .name(productDto.getName())
                .countOfStock(productDto.getQuantity())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .build());
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    public ProductDto getProductByUUID(UUID id) {
        return mapper.mapTo(productRepository.findByProductId(id));
    }

    @Transactional
    public void updateProduct(ProductDto productDto) {
        Product product = productRepository.findByProductId(productDto.getProductId()).toBuilder()
                .name(productDto.getName())
                .countOfStock(productDto.getQuantity())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(UUID uuid) {
        productRepository.deleteById(productRepository.findByProductId(uuid).getId());
    }
}
