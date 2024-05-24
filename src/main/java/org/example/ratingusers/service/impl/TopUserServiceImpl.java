package org.example.ratingusers.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ratingusers.entity.TopUser;
import org.example.ratingusers.entity.User;
import org.example.ratingusers.repository.TopUserRepository;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.TopUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopUserServiceImpl implements TopUserService {

    private final TopUserRepository topUserRepository;
    private final UserRepository userRepository;

    @Override
    public void updateTopUsers() {
        List<User> allUsers = userRepository.findAll();
        allUsers.sort((u1, u2) -> Double.compare(u2.getRating(), u1.getRating()));

        List<User> topUsers = allUsers.stream()
                .limit(10)
                .toList();

        topUserRepository.deleteAll();

        for (User user : topUsers) {
            TopUser topUser = new TopUser();
            topUser.setUser(user);
            topUser.setUsername(user.getUsername());
            topUser.setRating(user.getRating());
            topUserRepository.save(topUser);
        }
    }
}

