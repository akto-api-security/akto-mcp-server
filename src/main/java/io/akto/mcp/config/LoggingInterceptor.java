package io.akto.mcp.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Interceptor for logging HTTP requests and responses
 */
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
    
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        logRequest(request, body);

        ClientHttpResponse response = execution.execute(request, body);

        logResponse(response);
        
        return response;
    }
    
    private void logRequest(HttpRequest request, byte[] body) {
        logger.debug("============================= REQUEST BEGIN =============================");
        logger.debug("URI: {}", request.getURI());
        logger.debug("Method: {}", request.getMethod());
        logger.debug("Headers: {}", request.getHeaders());
        logger.debug("Request body: {}", new String(body, StandardCharsets.UTF_8));
        logger.debug("============================= REQUEST END ===============================");
    }
    
    private void logResponse(ClientHttpResponse response) throws IOException {
        logger.debug("============================= RESPONSE BEGIN =============================");
        logger.debug("Status code: {}", response.getStatusCode());
        logger.debug("Headers: {}", response.getHeaders());
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody(), StandardCharsets.UTF_8))) {
            String responseBody = reader.lines().collect(Collectors.joining("\n"));
            logger.debug("Response body: {}", responseBody);
        }
        
        logger.debug("============================= RESPONSE END ===============================");
    }
}
