package com.example.gameagregator.repository;

import com.example.gameagregator.entity.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CollectionRepository extends MongoRepository<Collection, Long> {
    List<Collection> findByUserId(Long userId);
}
