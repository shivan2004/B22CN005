package com.b22cn005.loggingmiddleware.clients;

import com.b22cn005.loggingmiddleware.dtos.Response;
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
        body.put("package", _package);
        body.put("message", message);

        System.out.println(body);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://20.244.56.144/evaluation-service/logs",
                HttpMethod.POST,
                request,
                Response.class
        );

        Response response = responseEntity.getBody();
        System.out.println(response);
        return response;

    }
}

