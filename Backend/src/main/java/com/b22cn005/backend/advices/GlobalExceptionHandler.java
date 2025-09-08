package com.b22cn005.backend.advices;

import com.b22cn005.backend.clients.ApiClientRestTemplateImpl;
import com.b22cn005.backend.dto.Response;
import com.b22cn005.backend.exceptions.OriginalUrlBlankException;
import com.b22cn005.backend.exceptions.ShortLinkAlreadyExistsException;
import com.b22cn005.backend.exceptions.ShortLinkIsNotSupportedException;
import com.b22cn005.backend.exceptions.ShortLinkNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ApiClientRestTemplateImpl apiClientRestTemplateImpl;
    @Value("${access.token}")
    private String accessToken;

    public GlobalExceptionHandler(ApiClientRestTemplateImpl apiClientRestTemplateImpl) {
        this.apiClientRestTemplateImpl = apiClientRestTemplateImpl;
    }

    @ExceptionHandler
    public ResponseEntity<Response> OriginalUrlBlankExceptionHandler(OriginalUrlBlankException exception) {
        return new ResponseEntity<>(apiClientRestTemplateImpl.getApiResponse("backend", "error", "service", exception.getMessage(), accessToken), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Response> ShortLinkAlreadyExistsException(ShortLinkAlreadyExistsException ex) {
        return new ResponseEntity<>(apiClientRestTemplateImpl.getApiResponse("backend", "error", "service", ex.getMessage(), accessToken), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<Response> ShortLinkIsNotSupportedExceptionHandler(ShortLinkIsNotSupportedException ex) {
        Response apiResponse = apiClientRestTemplateImpl.getApiResponse(
                "backend",
                "error",
                "service",
                ex.getMessage(),
                accessToken
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_IMPLEMENTED);
    }


    @ExceptionHandler
    public ResponseEntity<Response> ShortLinkNotFoundExceptionHandler(ShortLinkNotFoundException ex) {
        Response apiResponse = apiClientRestTemplateImpl.getApiResponse(
                "backend",
                "error",
                "service",
                ex.getMessage(),
                accessToken
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }


}
