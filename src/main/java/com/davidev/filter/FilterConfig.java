package com.davidev.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@ConfigurationProperties(prefix = "app.filters")
public class FilterConfig {
    private final Set<String> allowedFields;

    public FilterConfig(Set<String> allowedFields) {
        this.allowedFields = allowedFields;
    }

    public Set<String> getAllowedFields() {
        return allowedFields;
    }
}
