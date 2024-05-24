package org.example.ratingusers.controller;

import lombok.RequiredArgsConstructor;
import org.example.ratingusers.annotation.CreateReview;
import org.example.ratingusers.dto.ReviewAfterCreatingDto;
import org.example.ratingusers.dto.ReviewCreateDto;
import org.example.ratingusers.service.ReviewService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @CreateReview(path = "/create")
    public ReviewAfterCreatingDto createDto(@RequestBody ReviewCreateDto reviewCreateDto) {
        return reviewService.reviewContract(reviewCreateDto);
    }

}
