package org.example.ratingusers.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "top_user")
public class TopUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "top_user_id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_name")
    private String username;

    @Column(name = "rating")
    private Double rating;
}
