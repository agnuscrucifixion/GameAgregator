package com.example.gameagregator.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "games")
@Data
public class Game {
    private Long id;
    private String title;
    private String description;
    private String downloadUrl;

    private List<Collection> collections;

}
