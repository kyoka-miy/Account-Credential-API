package com.example.recruit.config;

import com.example.recruit.User;
import com.example.recruit.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User Kyoka = new User(
                    "kyokamiy38",
                    "kyoka",
                    "configconfig",
                    "password"
            );
            User Tako = new User(
                    "takoyaki25",
                    "tako",
                    "configconfigtesttest",
                    "password2"
            );
            repository.saveAll(List.of(Kyoka, Tako));
        };
    }
}
