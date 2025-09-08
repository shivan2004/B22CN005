package com.b22cn005.loggingmiddleware.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Response {
    private String logId;
    private String message;
}
