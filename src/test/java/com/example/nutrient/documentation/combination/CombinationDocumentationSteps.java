package com.example.nutrient.documentation.combination;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.request.PathParametersSnippet;
import org.springframework.restdocs.snippet.Snippet;

import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;

public class CombinationDocumentationSteps {
    public static RequestFieldsSnippet getCreateRequestFields() {
        return requestFields(
                fieldWithPath("title").description("조합 제목"),
                fieldWithPath("content").description("조합 내용"),
                fieldWithPath("supplementIds").description("영양제 ID 목록"),
                fieldWithPath("recommendedGender").description("추천 성별(ALL: 모두, MALE: 남성, FEMALE: 여성)"),
                fieldWithPath("healthStatusId").description("건강 상태 ID")
        );
    }

    public static Snippet getCreateResponseFields() {
        return responseFields(
                fieldWithPath("id").description("조합 ID"),
                fieldWithPath("title").description("조합 제목"),
                fieldWithPath("content").description("조합 내용"),
                fieldWithPath("combinationLineItems").description("조합 품목 목록"),
                fieldWithPath("recommendedGender").description("추천 성별(ALL: 모두, MALE: 남성, FEMALE: 여성)"),
                fieldWithPath("healthStatusResponse").description("건강 상태"),
                fieldWithPath("healthStatusResponse.id").description("건강 상태 ID"),
                fieldWithPath("healthStatusResponse.name").description("건강 상태 이름")
        );
    }

    public static PathParametersSnippet getUpdateRequestPathParams() {
        return pathParameters(
                parameterWithName("combinationId").description("조합 ID")
        );
    }

    public static RequestFieldsSnippet getUpdateRequestFields() {
        return requestFields(
                fieldWithPath("title").description("조합 제목"),
                fieldWithPath("content").description("조합 내용"),
                fieldWithPath("supplementIds").description("영양제 ID 목록"),
                fieldWithPath("recommendedGender").description("추천 성별(ALL: 모두, MALE: 남성, FEMALE: 여성)"),
                fieldWithPath("healthStatusId").description("건강 상태 ID")
        );
    }

    public static Snippet getUpdateResponseFields() {
        return responseFields(
                fieldWithPath("id").description("조합 ID"),
                fieldWithPath("title").description("조합 제목"),
                fieldWithPath("content").description("조합 내용"),
                fieldWithPath("combinationLineItems").description("조합 품목 목록"),
                fieldWithPath("recommendedGender").description("추천 성별(ALL: 모두, MALE: 남성, FEMALE: 여성)"),
                fieldWithPath("healthStatusResponse").description("건강 상태"),
                fieldWithPath("healthStatusResponse.id").description("건강 상태 ID"),
                fieldWithPath("healthStatusResponse.name").description("건강 상태 이름")
        );
    }

    public static PathParametersSnippet getDeleteRequestPathParams() {
        return pathParameters(
                parameterWithName("combinationId").description("조합 ID")
        );
    }
}
