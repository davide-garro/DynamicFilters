package com.davidev;

import com.davidev.filter.FilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FilterConfig.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}