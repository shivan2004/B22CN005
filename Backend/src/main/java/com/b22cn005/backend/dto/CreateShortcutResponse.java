package com.b22cn005.backend.dto;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateShortcutResponse {

    private String shortUrl;
    private LocalDateTime expiry;
}
