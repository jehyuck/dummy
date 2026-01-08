package com.example.loadtest;

import com.example.loadtest.domain.Problem;
import com.example.loadtest.domain.ProblemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDataConfig {

    @Bean
    CommandLineRunner init(ProblemRepository repository) {
        return args -> {
            for (int i = 1; i <= 100; i++) {
                repository.save(new Problem("problem-" + i));
            }
        };
    }
}
