package com.b22cn005.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRequest {
    private String stack;
    private String level;
    private String _package;
    private String message;
    private String accessToken;
}