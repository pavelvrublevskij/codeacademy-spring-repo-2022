package eu.codeacademy.eshop.product.repository;

import eu.codeacademy.eshop.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductId(UUID id);
}
