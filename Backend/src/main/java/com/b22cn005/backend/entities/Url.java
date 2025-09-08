package com.b22cn005.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "url_table")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime createdAt;
    private LocalDateTime expiry;
    private Long urlHits;

    @OneToMany(mappedBy = "url", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UrlHits> urlHitsList;
    public void addHit(UrlHits hit) {
        hit.setUrl(this);
        this.urlHitsList.add(hit);
    }
}

