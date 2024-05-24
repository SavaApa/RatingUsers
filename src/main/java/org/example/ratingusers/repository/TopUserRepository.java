package org.example.ratingusers.repository;

import org.example.ratingusers.entity.TopUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TopUserRepository extends JpaRepository<TopUser, UUID> {
    Optional<TopUser> findById(UUID id);
}
