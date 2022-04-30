package com.example.nutrient.ui;

import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.application.CombinationService;
import com.example.nutrient.application.dto.combination.CombinationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequestMapping("/api/combinations")
@RestController
@RequiredArgsConstructor
public class CombinationRestController {
    private final CombinationService combinationService;

    @PostMapping
    public ResponseEntity<CombinationResponse> create(@RequestBody CombinationCreateRequest request) {
        CombinationResponse response = combinationService.create(request);
        return ResponseEntity.created(URI.create("/api/combinations/" + response.getId()))
                .body(response);
    }
}
