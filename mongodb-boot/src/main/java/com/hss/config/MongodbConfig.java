package com.hss.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongodbConfig {

    @Value(value = "${spring.data.mongodb.host:''}")
    private String host;
    @Value(value = "${spring.data.mongodb.database:''}")
    private String database;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(host);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }
}