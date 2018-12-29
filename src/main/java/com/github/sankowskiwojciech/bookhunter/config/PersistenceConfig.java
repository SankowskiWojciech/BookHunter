package com.github.sankowskiwojciech.bookhunter.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/BookHunterDB";

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username(USERNAME)
                .password(PASSWORD)
                .url(DATABASE_URL)
                .driverClassName(org.postgresql.Driver.class.getName())
                .build();
    }
}
