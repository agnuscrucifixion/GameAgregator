package com.example.gameagregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class GameAgregatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameAgregatorApplication.class, args);
    }

}
