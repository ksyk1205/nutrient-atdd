package com.example.nutrient.documentation.supplement;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.example.nutrient.application.dto.supplement.CategoryResponse;
import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import java.util.Collections;
import java.util.UUID;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.snippet.Snippet;

public class SupplementDocumentationFixture {

    public static final SupplementCreateResponse RESPONSE;
    public static final SupplementCreateRequest CREATE_REQUEST;

    public static final String CATEGORY_ID;

    static {
        CATEGORY_ID = UUID.randomUUID().toString();

        RESPONSE = new SupplementCreateResponse(
            UUID.randomUUID().toString(),
            "비타민C",
            "피부, 힘줄, 인대 및 혈관을 만드는 중요한 단백질을 형성하는 데 사용됩니다.",
            new CategoryResponse(CATEGORY_ID, "멀티 비타민")
        );
        CREATE_REQUEST = new SupplementCreateRequest(
            "비타민C",
            "피부, 힘줄, 인대 및 혈관을 만드는 중요한 단백질을 형성하는 데 사용됩니다.",
            CATEGORY_ID
        );
    }

    public static Snippet getResponseFields() {
        return responseFields(
            fieldWithPath("id").description("영양제 ID"),
            fieldWithPath("name").description("영양제 이름"),
            fieldWithPath("content").description("영양제 설명"),
            fieldWithPath("category.id").description("영양제 카테고리 ID"),
            fieldWithPath("category.name").description("영양제 카테고리 이름")
        );
    }
}
