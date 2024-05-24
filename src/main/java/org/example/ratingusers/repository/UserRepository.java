package org.example.ratingusers.repository;

import org.example.ratingusers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByUsername(String username);
}
