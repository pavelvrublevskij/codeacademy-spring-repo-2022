package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.mapper.ProductMapper;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public void addProduct(ProductDto product) {
//        productRepository.save(product);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    public ProductDto getProductByUUID(UUID id) {
//        return productRepository.getProductByUUID(id);
        return null;
    }

    public void updateProduct(ProductDto product) {
//        productRepository.update(product);
    }

    public void deleteProduct(UUID uuid) {
//        productRepository.delete(uuid);
    }
}
