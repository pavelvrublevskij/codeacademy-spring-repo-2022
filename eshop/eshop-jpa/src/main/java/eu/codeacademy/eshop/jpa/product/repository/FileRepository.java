package eu.codeacademy.eshop.jpa.product.repository;

import eu.codeacademy.eshop.jpa.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
