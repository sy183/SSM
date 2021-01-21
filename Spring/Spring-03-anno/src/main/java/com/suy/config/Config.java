package com.suy.config;

import com.suy.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.suy")
public class Config {

    @Bean
    public User getUser() {
        return new User();
    }
}
