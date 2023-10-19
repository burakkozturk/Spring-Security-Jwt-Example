package spring.security.jwtexample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.jwtexample.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}

