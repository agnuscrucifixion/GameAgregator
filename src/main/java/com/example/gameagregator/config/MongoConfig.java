package com.example.gameagregator.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.ClusterSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Arrays;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "gameagregator";
    }

    @Bean
    @Override
    public com.mongodb.client.MongoClient mongoClient() {
        ClusterSettings clusterSettings = ClusterSettings.builder()
                .hosts(Arrays.asList(
                        new ServerAddress("localhost", 27017),
                        new ServerAddress("localhost", 27018),
                        new ServerAddress("localhost", 27019)))
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.applySettings(clusterSettings))
                .build();

        return MongoClients.create(settings);
    }
}
