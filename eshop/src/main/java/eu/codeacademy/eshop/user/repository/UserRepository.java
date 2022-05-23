package eu.codeacademy.eshop.user.repository;

import eu.codeacademy.eshop.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
}
