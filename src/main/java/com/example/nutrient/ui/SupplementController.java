package com.example.nutrient.ui;

import com.example.nutrient.application.SupplementService;
import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.application.dto.supplement.SupplementUpdateRequest;
import com.example.nutrient.application.dto.supplement.SupplementUpdateResponse;
import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/supplements")
@RestController
@RequiredArgsConstructor
public class SupplementController {
    private final SupplementService supplementService;

    @PostMapping
    public ResponseEntity<SupplementCreateResponse> create(
        @RequestBody @Valid SupplementCreateRequest request){
        SupplementCreateResponse response = supplementService.create(request);
        return ResponseEntity.created(URI.create("/api/supplements/" + response.getId())).body(response);
    }

    @PatchMapping
    public ResponseEntity<SupplementUpdateResponse> update(
        @RequestBody @Valid SupplementUpdateRequest request){
        SupplementUpdateResponse response = supplementService.update(request);
        return ResponseEntity.ok().body(response);
    }

}
