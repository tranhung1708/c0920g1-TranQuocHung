package com.codegym.cms.repository;

import com.codegym.cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}