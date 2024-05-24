package org.example.ratingusers.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.ratingusers.dto.ReviewAfterCreatingDto;
import org.example.ratingusers.dto.ReviewCreateDto;
import org.example.ratingusers.entity.Review;
import org.example.ratingusers.entity.User;
import org.example.ratingusers.mapper.ReviewMapper;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public ReviewAfterCreatingDto reviewContract(ReviewCreateDto reviewCreateDto) {
        User toUser = userRepository.findById(reviewCreateDto.getToUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + reviewCreateDto.getToUserId()));

        Review entity = reviewMapper.toEntity(reviewCreateDto);
        toUser.addReview(entity);
        reviewRepository.save(entity);

        updateRating(toUser);

        return reviewMapper.toDto(entity);
    }

    private void updateRating(User user) {
        user.updateRating();
        userRepository.save(user);
    }
}
