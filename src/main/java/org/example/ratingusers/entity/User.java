package org.example.ratingusers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "rating")
    private Double rating;

    @JsonIgnore
    @OneToMany(mappedBy = "toUser", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public void addReview(Review review) {
        reviews.add(review);
        review.setToUser(this);
    }

    public void updateRating() {
        double totalRating = reviews.stream().mapToInt(Review::getRating).sum();
        this.rating = totalRating / reviews.size();
    }
}
