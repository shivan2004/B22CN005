package com.b22cn005.backend.repositories;


import com.b22cn005.backend.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    boolean existsByShortUrl(String shortcut);

    Optional<Url> findByShortUrl(String shortUrl);
}
