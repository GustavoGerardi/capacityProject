package com.gerardi.project.config;

import com.gerardi.project.entities.User;
import com.gerardi.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Gustavo", "gu@gmail.com", "12345");
        User user2 = new User(null, "Danilo", "dan@gmail.com", "54321");

        this.userRepository.saveAll(Arrays.asList(user1));
    }
}
