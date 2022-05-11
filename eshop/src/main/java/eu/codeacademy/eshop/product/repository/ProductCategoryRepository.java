package eu.codeacademy.eshop.product.repository;

import eu.codeacademy.eshop.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
