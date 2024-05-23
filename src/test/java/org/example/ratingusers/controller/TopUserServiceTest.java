package org.example.ratingusers.controller;

import org.example.ratingusers.controller.impl.Generator;
import org.example.ratingusers.entity.TopUser;
import org.example.ratingusers.entity.User;
import org.example.ratingusers.repository.TopUserRepository;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.TopUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class TopUserServiceTest {

    @Autowired
    private TopUserService topUserService;

    @MockBean
    private TopUserRepository topUserRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testUpdateTopUsers() {
        List<User> users = Generator.getUser();

        when(userRepository.findAll()).thenReturn(users);

        topUserService.updateTopUsers();

        verify(topUserRepository, times(1)).deleteAll();
        verify(topUserRepository, times(3)).save(new TopUser());
    }
}




