package com.epam.second.task.jmpdto.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.epam.second.task.jmpdto")
@EntityScan(basePackages = "com.epam.second.task.jmpdto")
public class PersistenceConfig {
}
