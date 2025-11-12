package com.example.Product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.hsqldb.util.DatabaseManagerSwing;

@Configuration
public class HsqlGuiConfig {

    @Bean
    public Object startHsqlGui() {
        // Launch HSQLDB GUI for your in-memory database
        DatabaseManagerSwing.main(new String[]{
                "--url", "jdbc:hsqldb:mem:productDB",
                "--user", "SA",
                "--password", ""
        });
        return new Object();
    }
}
