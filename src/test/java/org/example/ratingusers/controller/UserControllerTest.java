package org.example.ratingusers.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ratingusers.dto.UserCreateDto;
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

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/drop.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void userPositiveTest() throws Exception {
        UserCreateDto userCreateDto = new UserCreateDto("Adrian", 4.9);

        String json = objectMapper.writeValueAsString(userCreateDto);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }
}
