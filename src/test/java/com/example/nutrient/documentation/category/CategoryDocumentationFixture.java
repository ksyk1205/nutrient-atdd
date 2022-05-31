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
    public static final CategoryCreateRequest CREATE_PARENT_REQUEST;

    public static final CategoryCreateRequest CREATE_CHILD_REQUEST;

    public static final CategoryCreateResponse CREATE_PARENT_RESPONSE;

    public static final CategoryCreateResponse CREATE_CHILD_RESPONSE;

    static {

        CREATE_PARENT_REQUEST  = new CategoryCreateRequest(
                "비타민"
        );

        CREATE_PARENT_RESPONSE = new CategoryCreateResponse(
                UUID.randomUUID(),
                "비타민"
                ,0
        );


        CREATE_CHILD_REQUEST  = new CategoryCreateRequest(
                "비타민D"
                ,1
        );

        CREATE_CHILD_RESPONSE = new CategoryCreateResponse(
                UUID.randomUUID(),
                "비타민D"
                ,1
        );
    }

    public static Snippet getResponseFields() {
        return responseFields(
                fieldWithPath("id").description("카테고리 ID"),
                fieldWithPath("name").description("카테고리명"),
                fieldWithPath("depth").description("카테고리 레벨")
        );
    }
}
