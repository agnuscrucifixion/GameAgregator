package com.example.gameagregator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "games")
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String downloadUrl;

    @ManyToMany(mappedBy = "games")
    private List<Collection> collections;

}
