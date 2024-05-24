package org.example.ratingusers.mapper;

import org.example.ratingusers.dto.UserAfterCreatingDto;
import org.example.ratingusers.dto.UserCreateDto;
import org.example.ratingusers.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "rating", source = "rating")
    User toEntity(UserCreateDto userCreateDto);

    @Mapping(target = "user_id", ignore = true)
    UserAfterCreatingDto toDto(User user);
}
