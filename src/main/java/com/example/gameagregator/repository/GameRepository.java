package com.example.gameagregator.repository;

import com.example.gameagregator.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByTitleContaining(String title);
}
