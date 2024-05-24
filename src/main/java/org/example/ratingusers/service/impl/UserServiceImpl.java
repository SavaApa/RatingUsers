package org.example.ratingusers.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ratingusers.dto.UserAfterCreatingDto;
import org.example.ratingusers.dto.UserCreateDto;
import org.example.ratingusers.entity.User;
import org.example.ratingusers.mapper.UserMapper;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserAfterCreatingDto createUser(UserCreateDto userCreateDto) {
        User user = userRepository.findUserByUsername(userCreateDto.getUsername());
        if (user != null) {
            throw new RuntimeException("User with username already exists");
        }

        User entity = userMapper.toEntity(userCreateDto);
        User userAfterCreation = userRepository.save(entity);
        return userMapper.toDto(userAfterCreation);
    }
}
