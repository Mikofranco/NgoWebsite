package com.mikofranco.JwtSpringSecurity.data.repo;

import com.mikofranco.JwtSpringSecurity.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
