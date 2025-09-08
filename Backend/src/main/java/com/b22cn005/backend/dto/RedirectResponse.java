package com.b22cn005.backend.dto;


import com.b22cn005.backend.entities.Url;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RedirectResponse {

    private Url url;
}
