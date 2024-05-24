package org.example.ratingusers.scheduler;

import lombok.AllArgsConstructor;
import org.example.ratingusers.entity.User;
import org.example.ratingusers.repository.UserRepository;
import org.example.ratingusers.service.TopUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class SchedulerConfig {

    private final TopUserService topUserService;

    private final UserRepository userRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateTopUsers() {
        topUserService.updateTopUsers();

        List<User> allUsers = userRepository.findAll();
        List<User> topUsers = allUsers.stream()
                .sorted((u1, u2) -> Double.compare(u2.getRating(), u1.getRating()))
                .limit(10)
                .toList();

        allUsers.removeAll(topUsers);
        userRepository.deleteAll(allUsers);
    }
}

