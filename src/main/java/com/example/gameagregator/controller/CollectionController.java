package com.example.gameagregator.controller;


import com.example.gameagregator.entity.Collection;
import com.example.gameagregator.service.CollectionService;
import com.example.gameagregator.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/collections")
public class CollectionController {

    private CollectionService collectionService;
    private GameService gameService;
    @PostMapping
    public ResponseEntity<Collection> createCollection(@RequestBody Collection collection) {
        Collection savedCollection = collectionService.saveCollection(collection);
        return ResponseEntity.ok(savedCollection);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Collection>> getCollectionsByUser(@PathVariable Long userId) {
        List<Collection> collections = collectionService.getCollectionsByUserId(userId);
        return ResponseEntity.ok(collections);
    }

    @PostMapping("/user/{userId}/{collection}/add/{gameTitle}")
    public ResponseEntity<String> addGameToCollection(@PathVariable Long userId, @PathVariable String collection, @PathVariable String gameTitle) {
        List<Collection> collections = collectionService.getCollectionsByUserId(userId);
        for (Collection c : collections) {
            if (c.getName().equals(collection)) {
                c.getGames().add(gameService.searchFullMatchGame(gameTitle));
                collectionService.saveCollection(c);
                break;
            }
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/{userId}/{collection}/delete/{gameTitle}")
    public ResponseEntity<String> deleteGameFromCollection(@PathVariable Long userId, @PathVariable String collection, @PathVariable String gameTitle) {
        List<Collection> collections = collectionService.getCollectionsByUserId(userId);
        for (Collection c : collections) {
            if (c.getName().equals(collection)) {
                c.getGames().remove(gameService.searchFullMatchGame(gameTitle));
                collectionService.saveCollection(c);
                break;
            }
        }
        return ResponseEntity.ok().build();
    }
}
