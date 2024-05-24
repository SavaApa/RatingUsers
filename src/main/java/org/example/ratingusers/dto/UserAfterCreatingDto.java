package org.example.ratingusers.dto;

import lombok.Data;

@Data
public class UserAfterCreatingDto {
    private String user_id;
    private String status = "USER CREATED";
}
