package com.example.gameagregator.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    private Long id;
    private String username;
    private String password;
}
