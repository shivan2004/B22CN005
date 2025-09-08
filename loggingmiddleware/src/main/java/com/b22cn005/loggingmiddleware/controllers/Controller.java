package com.b22cn005.loggingmiddleware.controllers;


import com.b22cn005.loggingmiddleware.clients.ApiClientRestTemplateImpl;
import com.b22cn005.loggingmiddleware.dtos.ApiRequest;
import com.b22cn005.loggingmiddleware.dtos.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class Controller {
    private final ApiClientRestTemplateImpl apiClientRestTemplateImpl;


    @PostMapping
    public ResponseEntity<Response> operation(@RequestBody  ApiRequest request) {
        return ResponseEntity.ok(
                apiClientRestTemplateImpl.getApiResponse(
                        request.getStack(),
                        request.getLevel(),
                        request.get_package(),
                        request.getMessage(),
                        request.getAccessToken()
                )
        );
    }
}
