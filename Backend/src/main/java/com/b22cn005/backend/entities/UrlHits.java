package com.b22cn005.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
@Entity
@Table(name = "url_hits")
public class UrlHits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)   // many hits belong to one URL
    @JoinColumn(name = "url_id", nullable = false)
    @JsonIgnore
    private Url url;

    private LocalDateTime timeStamp;



}