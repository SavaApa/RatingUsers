package org.example.ratingusers.service;

import org.example.ratingusers.dto.UserAfterCreatingDto;
import org.example.ratingusers.dto.UserCreateDto;


public interface UserService {
    UserAfterCreatingDto createUser(UserCreateDto userCreateDto);
}
