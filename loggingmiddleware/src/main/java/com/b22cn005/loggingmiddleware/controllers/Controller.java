package com.b22cn005.loggingmiddleware.controllers;


import com.b22cn005.loggingmiddleware.clients.ApiClient;
import com.b22cn005.loggingmiddleware.dtos.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
@RequiredArgsConstructor
public class Controller {
    private final ApiClient apiClient;

    @GetMapping("/{stack}/{level}/{_package}/{message}/{accessToken}")
    public ResponseEntity<Response> operation(@PathVariable String stack,
                                              @PathVariable String level,
                                              @PathVariable String _package,
                                              @PathVariable String message,
                                              @PathVariable String accessToken) {
        return ResponseEntity.ok(apiClient.getApiResponse(stack, level, _package, message, accessToken));
    }
}
