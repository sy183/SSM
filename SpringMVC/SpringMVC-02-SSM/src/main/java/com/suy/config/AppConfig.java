package com.suy.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(DaoConfig.class)
@ComponentScan("com.suy")
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public Gson gson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
