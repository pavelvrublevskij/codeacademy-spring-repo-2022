package eu.codeacademy.eshop.jpa.product.repository;

import eu.codeacademy.eshop.jpa.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
