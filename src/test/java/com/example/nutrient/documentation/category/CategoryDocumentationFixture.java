package com.example.nutrient.documentation.category;

import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.application.dto.category.CategoryCreateResponse;
import org.springframework.restdocs.snippet.Snippet;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class CategoryDocumentationFixture {
    public static final CategoryCreateRequest CREATE_REQUEST;

    public static final CategoryCreateResponse RESPONSE;

    static {

        CREATE_REQUEST = new CategoryCreateRequest(
                "멀티비타민"
                ,null
        );


        RESPONSE = new CategoryCreateResponse(
                UUID.randomUUID().toString(),
                "멀티비타민"
                ,0
                ,null
        );
    }

    public static Snippet getResponseFields() {
        return responseFields(
                fieldWithPath("id").description("카테고리 ID"),
                fieldWithPath("name").description("카테고리명"),
                fieldWithPath("depth").description("카테고리 레벨"),
                fieldWithPath("parentCategory.id").description("상위 카테고리 ID")
        );
    }
}
