package eu.codeacademy.eshop.jpa.product.repository;

import eu.codeacademy.eshop.jpa.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductId(UUID id);

    // only for test scope
    Optional<Product> findByName(String name);

    Page<Product> findProductsByNameIsLikeIgnoreCase(String productName, Pageable pageable);
}
