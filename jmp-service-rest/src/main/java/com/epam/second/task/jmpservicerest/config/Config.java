package com.epam.second.task.jmpservicerest.config;

import com.epam.second.task.jmpdto.mapper.SubscriptionMapper;
import com.epam.second.task.jmpdto.mapper.SubscriptionMapperImpl;
import com.epam.second.task.jmpdto.mapper.UserMapper;
import com.epam.second.task.jmpdto.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public SubscriptionMapper subscriptionMapper() {
        return new SubscriptionMapperImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }
}
