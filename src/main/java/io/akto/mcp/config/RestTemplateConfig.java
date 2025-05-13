package io.akto.mcp.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${spring.resttemplate.connection.timeout:5000}")
    private int connectionTimeout;

    @Value("${spring.resttemplate.read.timeout:10000}")
    private int readTimeout;

    @Bean
    public RestTemplate restTemplate() {
        // Configure timeouts
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);

        // Use BufferingClientHttpRequestFactory to allow multiple reads of the response body
        RestTemplate restTemplate = new RestTemplate(
            new BufferingClientHttpRequestFactory(factory)
        );

        // Add logging interceptor
        restTemplate.setInterceptors(Collections.singletonList(new LoggingInterceptor()));

        return restTemplate;
    }
}
