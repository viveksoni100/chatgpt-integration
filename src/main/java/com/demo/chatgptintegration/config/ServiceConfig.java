package com.demo.chatgptintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author viveksoni
 */

@Configuration
public class ServiceConfig {

    /**
     * we are using RestTemplate to process OpenAI's API
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
