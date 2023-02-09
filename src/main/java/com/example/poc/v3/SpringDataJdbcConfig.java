package com.example.poc.v3;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.time.Instant;

@Configuration
public class SpringDataJdbcConfig {


    /**
     * There is no "auto-generation" strategy like JPA, so we can create listeners
     */
    @Bean
    ApplicationListener<BeforeSaveEvent> beforeSaveEventListener() {
        return event -> {
            if (event.getEntity() instanceof PersonV3Entity entity && entity.getId() ==null) {
                entity.setId(Instant.now().toEpochMilli());
            }
        };
    }
}
