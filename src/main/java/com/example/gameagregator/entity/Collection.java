package com.example.gameagregator.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "collections")
@Data
public class Collection {
    private Long id;
    private String name;

    private User user;

    private List<Game> games;
}
