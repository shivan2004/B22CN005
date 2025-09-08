package com.b22cn005.backend.controllers;


import com.b22cn005.backend.dto.CreateShortcutResponse;
import com.b22cn005.backend.dto.RedirectResponse;
import com.b22cn005.backend.dto.StatisticsResponse;
import com.b22cn005.backend.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class MainController {
    private final UrlService urlService;

    @PostMapping("/shorturls")
    public ResponseEntity<CreateShortcutResponse> createShortUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("url");
        String validity = request.get("validity");
        String shortcode = request.get("shortcode");

        System.out.println(originalUrl);
        System.out.println(validity);
        System.out.println(shortcode);
        CreateShortcutResponse response = urlService.createShortUrl(originalUrl, shortcode, validity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



    @GetMapping("/{shortLink}")
    public ResponseEntity<RedirectResponse> redirect(@PathVariable String shortLink) {
        return ResponseEntity.ok(urlService.redirect(shortLink));
    }

    @GetMapping("/shorturls/{shortLink}")
    public ResponseEntity<StatisticsResponse> statistics(@PathVariable String shortLink) {
        return ResponseEntity.ok(urlService.statistics(shortLink));
    }

}
