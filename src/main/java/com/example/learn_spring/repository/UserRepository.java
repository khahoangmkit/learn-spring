package com.example.learn_spring.repository;

import com.example.learn_spring.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     boolean existsByUsername(String username);

     Optional<User> findByUsername(String username);
}
