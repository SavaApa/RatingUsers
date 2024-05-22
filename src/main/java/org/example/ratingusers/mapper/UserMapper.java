package org.example.ratingusers.mapper;

import org.example.ratingusers.entity.User;
import org.example.ratingusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {
    private final UserRepository userRepository;

    @Autowired
    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User map(UUID userId) {
        return userRepository.findUserById(userId);
    }
}
