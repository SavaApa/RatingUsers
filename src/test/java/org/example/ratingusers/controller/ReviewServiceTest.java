package org.example.ratingusers.controller;

import org.example.ratingusers.dto.ReviewAfterCreatingDto;
import org.example.ratingusers.dto.ReviewCreateDto;
import org.example.ratingusers.entity.User;
import org.example.ratingusers.entity.enums.Category;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.impl.ReviewServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewServiceTest {

    @Autowired
    private ReviewServiceImpl reviewService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testReviewContract() {
        // Создаем тестовые данные для отзыва
        ReviewCreateDto reviewCreateDto = new ReviewCreateDto(UUID.randomUUID(), UUID.randomUUID(), 5, "Great service", Category.INTERNSHIP);

        // Создаем мок пользователя
        User toUser = new User();
        toUser.setId(reviewCreateDto.getToUserId());

        // Задаем поведение моков
        when(userRepository.findById(reviewCreateDto.getToUserId())).thenReturn(Optional.of(toUser));

        // Вызываем метод, который мы тестируем
        ReviewAfterCreatingDto result = reviewService.reviewContract(reviewCreateDto);

        // Проверяем результат
        assertNotNull(result);
        assertEquals("Review CREATED", result.getStatus());
    }
}
