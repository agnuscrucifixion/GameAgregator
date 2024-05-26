package com.example.gameagregator.controller;


import com.example.gameagregator.entity.Collection;
import com.example.gameagregator.service.CollectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/collections")
public class CollectionController {

    private CollectionService collectionService;
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
}
