package org.example.ratingusers.controller;

import lombok.RequiredArgsConstructor;
import org.example.ratingusers.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContractId(@PathVariable("id") UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User with id " + id + " deleted");
    }
}
