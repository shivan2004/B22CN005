package com.b22cn005.loggingmiddleware.clients;

import com.b22cn005.loggingmiddleware.dtos.Response;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@AllArgsConstructor
public class ApiClientImpl implements ApiClient {
    private final RestClient restClient;


    @Override
    public Response getApiResponse(String stack, String level, String _package, String message, String accessToken) {
        try {
            String url = UriComponentsBuilder.fromUriString("")
                    .queryParam("stack", stack)
                    .queryParam("level", level)
                    .queryParam("package", _package)
                    .queryParam("message", message)
                    .build()
                    .toUriString();

            Response response = restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(new ParameterizedTypeReference<Response>() {
                    });

            return response;
        }
        catch (Exception e) {
            System.out.println("error response : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
