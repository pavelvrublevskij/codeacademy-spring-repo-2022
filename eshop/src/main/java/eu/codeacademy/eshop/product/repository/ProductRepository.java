package eu.codeacademy.eshop.product.repository;

import eu.codeacademy.eshop.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductId(UUID id);

    Page<Product> findProductsByNameIsLikeIgnoreCase(String productName, Pageable pageable);
}
