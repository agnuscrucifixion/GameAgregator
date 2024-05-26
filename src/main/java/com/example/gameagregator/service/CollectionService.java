package com.example.gameagregator.service;

import com.example.gameagregator.entity.Collection;
import com.example.gameagregator.repository.CollectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CollectionService {
    private CollectionRepository collectionRepository;

    public Collection saveCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    public List<Collection> getCollectionsByUserId(Long userId) {
        return collectionRepository.findByUserId(userId);
    }

}
