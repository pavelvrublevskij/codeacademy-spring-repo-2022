package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.entity.Product;
import eu.codeacademy.eshop.product.exception.ProductNotFoundException;
import eu.codeacademy.eshop.product.mapper.ProductMapper;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    public Page<ProductDto> getProductPaginated(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(mapper::mapTo);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    public ProductDto getProductByUUID(UUID id) {
        Optional<Product> product = productRepository.findByProductId(id);
        if (product.isPresent()) {
            return mapper.mapTo(product.get());
        }

        throw new ProductNotFoundException();
    }

    @Transactional
    public void updateProduct(ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findByProductId(productDto.getProductId());

        if (productOptional.isPresent()) {
            Product product = productOptional.get().toBuilder()
                    .name(productDto.getName())
                    .countOfStock(productDto.getQuantity())
                    .price(productDto.getPrice())
                    .description(productDto.getDescription())
                    .build();

            productRepository.save(product);
        }
    }

    @Transactional
    public void deleteProduct(UUID uuid) {
        Optional<Product> product = productRepository.findByProductId(uuid);
        product.ifPresent(value -> productRepository.deleteById(value.getId()));
    }
}
