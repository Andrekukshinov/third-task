package com.epam.second.task.jmpdto.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.epam.second.task.jmpdto")
public class EntityConfig {
}
