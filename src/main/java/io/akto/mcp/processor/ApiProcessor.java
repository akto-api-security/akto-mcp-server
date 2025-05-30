package io.akto.mcp.processor;

import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ApiProcessor {

    private final RestTemplate restTemplate;

    private static final String API_KEY = System.getenv("AKTO_API_KEY");
    private static final String AKTO_PROD_URL = "https://app.akto.io";

    public <T, R> T processRequest(String url, R request, Class<T> responseType, HttpMethod method) {
        log.info("Making request to: {}", url);
        log.debug("Request body: {}", request);

        HttpHeaders headers = createDefaultHeaders();
        headers.set("x-api-key", API_KEY);

        HttpEntity<R> entity = new HttpEntity<>(request, headers);

        ResponseEntity<T> response = restTemplate.exchange(
            AKTO_PROD_URL + "/" + url,
            method,
            entity,
            responseType
        );

        log.info("Received response status: {}", response.getStatusCode());
        return response.getBody();
    }

    // Convenience method for POST requests
    public <T, R> T processPostRequest(String url, R request, Class<T> responseType) {
        return processRequest(url, request, responseType, HttpMethod.POST);
    }

    private HttpHeaders createDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
