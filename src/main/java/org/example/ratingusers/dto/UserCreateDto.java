package org.example.ratingusers.dto;

import lombok.Value;

@Value
public class UserCreateDto {
    String username;
    Double rating;
}
