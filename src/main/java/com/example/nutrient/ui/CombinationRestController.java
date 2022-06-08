package com.example.nutrient.ui;

import com.example.auth.authorization.AuthenticationPrincipal;
import com.example.member.domain.LoginMember;
import com.example.nutrient.application.CombinationService;
import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.application.dto.combination.CombinationCreateResponse;
import com.example.nutrient.application.dto.combination.CombinationUpdateRequest;
import com.example.nutrient.application.dto.combination.CombinationUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/combinations")
@RestController
@RequiredArgsConstructor
public class CombinationRestController {
    private final CombinationService combinationService;

    @PostMapping
    public ResponseEntity<CombinationCreateResponse> create(
            @RequestBody CombinationCreateRequest request,
            @AuthenticationPrincipal LoginMember loginMember) {
        CombinationCreateResponse response = combinationService.create(request);
        return ResponseEntity.created(URI.create("/api/combinations/" + response.getId()))
                .body(response);
    }

    @PutMapping("/{combinationId}")
    public ResponseEntity<CombinationUpdateResponse> update(
            @PathVariable UUID combinationId,
            @RequestBody CombinationUpdateRequest request,
            @AuthenticationPrincipal LoginMember loginMember) {
        return ResponseEntity.ok(combinationService.update(combinationId, request));
    }
}
