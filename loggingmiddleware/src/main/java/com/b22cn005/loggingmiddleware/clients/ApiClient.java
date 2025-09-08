package com.b22cn005.loggingmiddleware.clients;


import com.b22cn005.loggingmiddleware.dtos.Response;

public interface ApiClient {
    Response getApiResponse(String stack, String level, String _package, String message, String accessToken);

}
