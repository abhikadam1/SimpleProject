package com.example.SimpleProject.repository;

import com.example.SimpleProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA automatically implements this method.
    Optional<User> findByEmail(String email);
}