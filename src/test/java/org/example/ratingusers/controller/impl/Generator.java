package org.example.ratingusers.controller.impl;

import org.example.ratingusers.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<User> getUser(){
        User user = new User();
        user.setUsername("Dima");
        user.setRating(3.4);

        User user1 = new User();
        user.setUsername("Dima");
        user.setRating(3.4);

        User user2 = new User();
        user.setUsername("Dima");
        user.setRating(3.4);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }
}
