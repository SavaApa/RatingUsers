package org.example.ratingusers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.ratingusers.entity.enums.Category;

import java.util.UUID;

@Entity
@Data
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "review_id")
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "type_category")
    @Enumerated(EnumType.STRING)
    private Category typeCategory;
}

