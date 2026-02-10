package com.gastromind.api.infrastructure.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "gastromind.security")
public class SecurityPathsProperties {
    private String[] publicUrls;

    public String[] getPublicUrls() {
        return publicUrls;
    }

    public void setPublicUrls(String[] publicUrls) {
        this.publicUrls = publicUrls;
    }
}
