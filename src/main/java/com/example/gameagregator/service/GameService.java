package com.example.gameagregator.service;

import com.example.gameagregator.entity.Game;
import com.example.gameagregator.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepository gameRepository;
    private final DownloadService downloadService;

    public List<Game> searchGames(String title) {
        return gameRepository.findByTitleContaining(title);
    }
    public Game searchFullMatchGame(String title) {
        return gameRepository.findGameByTitle(title);
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGameFromDevice(String gameName) {
        downloadService.deleteFile(gameName);
    }
}