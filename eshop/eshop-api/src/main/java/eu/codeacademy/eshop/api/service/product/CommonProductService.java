package eu.codeacademy.eshop.api.service.product;

import eu.codeacademy.eshop.api.dto.ProductDto;
import eu.codeacademy.eshop.api.exception.ProductNotFoundException;
import eu.codeacademy.eshop.api.mapper.ProductMapper;
import eu.codeacademy.eshop.jpa.product.entity.Product;
import eu.codeacademy.eshop.jpa.product.entity.ProductCategory;
import eu.codeacademy.eshop.jpa.product.repository.ProductCategoryRepository;
import eu.codeacademy.eshop.jpa.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class CommonProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper mapper;

    @Transactional
    public void addProduct(ProductDto productDto) {
        if (productDto == null) {
            return;
        }

        ProductCategory productCategory = ProductCategory.builder()
                .name("NaN")
                .build();

//        productDto.setName("a");

        productRepository.save(Product.builder()
                .name(productDto.getName())
                .countOfStock(productDto.getQuantity())
                .price(productDto.getPrice())
                .productId(UUID.randomUUID())
                .description(productDto.getDescription())
                .productCategories(Set.of(productCategory))
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
        return productRepository.findByProductId(id)
                .map(mapper::mapTo)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public boolean updateProduct(ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findByProductId(productDto.getProductId());

        if (productOptional.isPresent()) {
            Product product = productOptional.get().toBuilder()
                    .name(productDto.getName())
                    .countOfStock(productDto.getQuantity())
                    .price(productDto.getPrice())
                    .description(productDto.getDescription())
                    .build();

            productRepository.save(product);

            return true;
        }

        return false;
    }

    @Transactional
    public void deleteProduct(UUID uuid) {
        Optional<Product> product = productRepository.findByProductId(uuid);
        product.ifPresent(value -> productRepository.deleteById(value.getId()));
    }

    public Page<ProductDto> getProductByNamePageable(String productName, Pageable pageable) {
        return productRepository.findProductsByNameIsLikeIgnoreCase(
                        convertToLikeResult(productName), pageable)
                .map(mapper::mapTo);
    }

    private String convertToLikeResult(String value) {
        return '%' + value + '%';
    }
}
