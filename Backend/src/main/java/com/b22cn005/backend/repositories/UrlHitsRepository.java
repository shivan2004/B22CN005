package com.b22cn005.backend.repositories;

import com.b22cn005.backend.entities.UrlHits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlHitsRepository extends JpaRepository<UrlHits, Long> {
}