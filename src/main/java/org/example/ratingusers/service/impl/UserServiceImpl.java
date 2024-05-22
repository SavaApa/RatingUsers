package org.example.ratingusers.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ratingusers.exception.UserDoesntExistException;
import org.example.ratingusers.exception.errorMessage.ErrorMessage;
import org.example.ratingusers.repository.ReviewRepository;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void deleteUserById(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserDoesntExistException(ErrorMessage.NOT_EXIST);

        }
        reviewRepository.deleteByFromUserId(id);

        userRepository.deleteById(id);
    }
}
