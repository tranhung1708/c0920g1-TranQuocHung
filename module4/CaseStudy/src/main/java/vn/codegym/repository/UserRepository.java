package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
