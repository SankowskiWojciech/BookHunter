package com.github.sankowskiwojciech.bookhunter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:h2:file:./BookHunter";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username(USERNAME)
                .password(PASSWORD)
                .url(DATABASE_URL)
                .driverClassName(org.h2.Driver.class.getName())
                .build();
    }
}
