package com.dms.document.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "model-service")
public class ModelServiceProperties {
    private String apiKey;
    private String url;
}