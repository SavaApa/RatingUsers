package org.example.ratingusers.mapper;

import org.example.ratingusers.dto.ReviewAfterCreatingDto;
import org.example.ratingusers.dto.ReviewCreateDto;
import org.example.ratingusers.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = UserMapper.class)
public interface ReviewMapper{

    @Mapping(target = "fromUser", source = "fromUserId")
    @Mapping(target = "toUser", source = "toUserId")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "typeCategory", source = "typeCategory")
    Review toEntity(ReviewCreateDto reviewCreateDto);

    @Mapping(target = "reviewId", source = "id")
    ReviewAfterCreatingDto toDto(Review reviewAfterCreation);
}




