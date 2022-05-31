package eu.codeacademy.eshop.user.repository;

import eu.codeacademy.eshop.user.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
