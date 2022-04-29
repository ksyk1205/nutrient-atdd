package com.example.nutrient.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/combinations")
@RestController
public class CombinationRestController {

    @PostMapping
    public ResponseEntity<Void> create() {
        return ResponseEntity.created(URI.create("/api/combinations" + UUID.randomUUID())).body(null);
    }
}
