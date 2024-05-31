package com.example.gameagregator.controller;

import com.example.gameagregator.entity.Game;
import com.example.gameagregator.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    private GameService gameService;
    @GetMapping("/search")
    public ResponseEntity<List<Game>> searchGames(@RequestParam String title) {
        List<Game> games = gameService.searchGames(title);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/fullMatchSearch/{title}")
    public ResponseEntity<Game> searchFullMatchGame(@PathVariable String title) {
        Game game = gameService.searchFullMatchGame(title);
        return ResponseEntity.ok(game);
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game savedGame = gameService.saveGame(game);
        return ResponseEntity.ok(savedGame);
    }

}
