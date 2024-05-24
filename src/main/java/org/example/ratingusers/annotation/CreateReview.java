package org.example.ratingusers.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.ratingusers.entity.Review;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create a new review",
        description = "Creation of a new review and return",
        tags = {"REVIEW"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The review to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Review.class)
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The review created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Review.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The review already exist",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Review.class)
                        )
                )
        }
)
public @interface CreateReview {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
