package com.example.nutrient.ui;

import com.example.nutrient.application.CategoryService;
import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.application.dto.category.CategoryCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

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

}
