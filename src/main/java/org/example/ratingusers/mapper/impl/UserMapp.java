package org.example.ratingusers.mapper.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.ratingusers.entity.User;
import org.example.ratingusers.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UserMapp{
    private final UserRepository userRepository;

    public User map(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }
}
