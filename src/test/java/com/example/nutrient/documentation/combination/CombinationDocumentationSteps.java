package com.example.nutrient.documentation.combination;

import org.springframework.restdocs.snippet.Snippet;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class CombinationDocumentationSteps {
    public static Snippet getResponseFields() {
        return responseFields(
                fieldWithPath("id").description("조합 ID"),
                fieldWithPath("title").description("조합 제목"),
                fieldWithPath("content").description("조합 내용"),
                fieldWithPath("supplementResponses").description("조합 품목 목록"),
                fieldWithPath("recommendedGender").description("추천 성별(ALL: 모두, MALE: 남성, FEMALE: 여성)"),
                fieldWithPath("healthTagResponse").description("건강 상태"),
                fieldWithPath("healthTagResponse.id").description("건강 상태 ID"),
                fieldWithPath("healthTagResponse.name").description("건강 상태 이름")
        );
    }
}
