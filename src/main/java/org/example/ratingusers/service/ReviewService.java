package org.example.ratingusers.service;

import org.example.ratingusers.dto.ReviewAfterCreatingDto;
import org.example.ratingusers.dto.ReviewCreateDto;

public interface ReviewService {
    ReviewAfterCreatingDto reviewContract(ReviewCreateDto reviewCreateDto);
}
