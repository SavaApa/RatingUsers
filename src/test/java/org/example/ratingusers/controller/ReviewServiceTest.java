package org.example.ratingusers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ratingusers.dto.ReviewCreateDto;
import org.example.ratingusers.entity.enums.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/drop.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
class ReviewServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testReviewContract() throws Exception {
        // Создаем тестовые данные для отзыва
        ReviewCreateDto reviewCreateDto = new ReviewCreateDto(UUID.fromString("e8240961-836b-43cc-948c-4fb4d2cbcb18"),
                UUID.fromString("7fcbff56-9b94-45ed-b7bd-4af5b1d63fbe"), 5, "Great service", Category.INTERNSHIP);

        String json = objectMapper.writeValueAsString(reviewCreateDto);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/review/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }
}
