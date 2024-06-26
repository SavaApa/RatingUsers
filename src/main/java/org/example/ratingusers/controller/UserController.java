package org.example.ratingusers.controller;

import lombok.RequiredArgsConstructor;
import org.example.ratingusers.annotation.CreateUser;
import org.example.ratingusers.dto.UserAfterCreatingDto;
import org.example.ratingusers.dto.UserCreateDto;
import org.example.ratingusers.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @CreateUser(path = "/create")
    public UserAfterCreatingDto createDto(@RequestBody UserCreateDto userCreateDto){
        return userService.createUser(userCreateDto);
    }
}
