package com.example.gameagregator.repository;

import com.example.gameagregator.entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameRepository extends MongoRepository<Game, Long> {
    List<Game> findByTitleContaining(String title);
    Game findGameByTitle(String title);
}
