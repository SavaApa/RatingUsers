package org.example.ratingusers.controller;

import org.example.ratingusers.entity.User;
import org.example.ratingusers.repository.ReviewRepository;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private ReviewRepository reviewRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testDeleteUserById() {
        // Создаем тестовый пользователь
        UUID userId = UUID.randomUUID();
        User user = new User();
        user.setId(userId);

        // Задаем поведение моков
        when(userRepository.existsById(userId)).thenReturn(true);

        // Вызываем метод, который мы тестируем
        userService.deleteUserById(userId);

        // Проверяем, что метод удаления был вызван с правильным ID пользователя
        verify(userRepository).deleteById(userId);
    }
}
