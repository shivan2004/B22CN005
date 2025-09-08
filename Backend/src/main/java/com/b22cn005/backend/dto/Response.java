package com.b22cn005.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Response {
    @JsonProperty("logID")
    private String logID;
    private String message;
}
