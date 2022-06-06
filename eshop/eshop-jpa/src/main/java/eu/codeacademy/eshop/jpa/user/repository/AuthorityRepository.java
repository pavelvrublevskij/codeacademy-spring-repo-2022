package eu.codeacademy.eshop.jpa.user.repository;

import eu.codeacademy.eshop.jpa.user.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
