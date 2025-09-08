package com.b22cn005.backend.service;


import com.b22cn005.backend.dto.CreateShortcutResponse;
import com.b22cn005.backend.dto.RedirectResponse;
import com.b22cn005.backend.dto.StatisticsResponse;
import com.b22cn005.backend.entities.Url;
import com.b22cn005.backend.entities.UrlHits;
import com.b22cn005.backend.repositories.UrlHitsRepository;
import com.b22cn005.backend.repositories.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final ModelMapper modelMapper;
    private final UrlRepository urlRepository;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final Random random = new Random();
    private static final String REGEX = "^[a-zA-Z0-9]{4,10}$";
    private final UrlHitsRepository urlHitsRepository;


    private String generateShortcut() {
        String shortcut;
        do {
            shortcut = randomString();
        } while (urlRepository.existsByShortUrl(shortcut));
        System.out.println(shortcut  + " sdfa");
        return shortcut;
    }

    private String randomString() {
        int len = CHARACTERS.length();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(CHARACTERS.charAt((random.nextInt(0, 10000) % len)));
        }
        return sb.toString();
    }

    public CreateShortcutResponse createShortUrl(String originalUrl, String shortUrl, String validity) {
        if(originalUrl == null) {
            throw new IllegalArgumentException("Arguments are not provided");
        }

        if(urlRepository.existsByShortUrl(shortUrl)) {
            throw new IllegalArgumentException("ShortUrl Already Exists");
        }

        if(shortUrl == null) {
            shortUrl = generateShortcut();
        }

        if(!shortUrl.matches(REGEX)) {
            System.out.println(shortUrl);
            throw new IllegalArgumentException("ShortUrl is not in right format");
        }


        long validityInMinutes = 0L;
        if(validity == null || validity.isEmpty()) {
            validityInMinutes = 30;
        }
        else
            validityInMinutes = Long.parseLong(validity);


        Url url = Url.builder()
                .originalUrl(originalUrl)
                .shortUrl(shortUrl)
                .createdAt(LocalDateTime.now())
                .expiry(LocalDateTime.now().plusMinutes(validityInMinutes))
                .urlHits(0L)
                .urlHitsList(new ArrayList<>())
                .build();

        Url savedUrl = urlRepository.save(url);

        return modelMapper.map(savedUrl, CreateShortcutResponse.class);
    }

    @Transactional
    public RedirectResponse redirect(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new RuntimeException(""));



        UrlHits hit = new UrlHits();
        hit.setUrl(url);
        hit.setTimeStamp(LocalDateTime.now());
        url.addHit(hit);


        urlRepository.save(url);

        return modelMapper.map(url, RedirectResponse.class);
    }

    public StatisticsResponse statistics(String shortLink) {
        Url url = urlRepository.findByShortUrl(shortLink)
                .orElseThrow(() -> new RuntimeException("No url exists with provided short urls"));

        return modelMapper.map(url, StatisticsResponse.class);
    }
}
