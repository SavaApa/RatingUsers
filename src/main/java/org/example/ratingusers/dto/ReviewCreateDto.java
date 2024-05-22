package org.example.ratingusers.dto;

import lombok.Value;
import org.example.ratingusers.entity.enums.Category;

import java.util.UUID;

@Value
public class ReviewCreateDto {
    UUID fromUserId;
    UUID toUserId;
    Integer rating;
    String comment;
    Category typeCategory;
}
