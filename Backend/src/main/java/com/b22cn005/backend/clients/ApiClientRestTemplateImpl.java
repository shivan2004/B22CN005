package com.b22cn005.backend.clients;

import com.b22cn005.backend.dto.Response;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiClientRestTemplateImpl {

    private final RestTemplate restTemplate;

    public ApiClientRestTemplateImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Response getApiResponse(String stack, String level, String _package, String message, String accessToken) {

        Map<String, String> body = new HashMap<>();
        body.put("stack", stack);
        body.put("level", level);
        body.put("_package", _package);
        body.put("message", message);
        body.put("accessToken", accessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8081/log",
                HttpMethod.POST,
                request,
                Response.class
        );

        Response response = responseEntity.getBody();
        System.out.println(response);
        return response;

    }
}

