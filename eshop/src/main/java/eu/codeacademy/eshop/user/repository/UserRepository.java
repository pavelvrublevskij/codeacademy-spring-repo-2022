package eu.codeacademy.eshop.user.repository;

import eu.codeacademy.eshop.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
