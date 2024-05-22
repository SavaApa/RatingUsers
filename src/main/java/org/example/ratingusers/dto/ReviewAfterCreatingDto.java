package org.example.ratingusers.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewAfterCreatingDto {
    UUID reviewId;
    private String status = "Review CREATED";
}
