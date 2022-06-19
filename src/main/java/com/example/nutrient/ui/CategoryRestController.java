package com.example.nutrient.ui;

import com.example.nutrient.application.CategoryService;
import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.application.dto.category.CategoryCreateResponse;
import com.example.nutrient.application.dto.category.CategoryUpdateRequest;
import com.example.nutrient.application.dto.category.CategoryUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryRestController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryCreateResponse> create(@RequestBody @Valid CategoryCreateRequest request) {
        CategoryCreateResponse response = categoryService.create(request);
        return ResponseEntity.created(URI.create("/api/categories/" + response.getId()))
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryUpdateResponse> update(
            @PathVariable UUID id,
            @RequestBody @Valid CategoryUpdateRequest request){
        CategoryUpdateResponse response = categoryService.update(id, request);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id
    ){
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

}
