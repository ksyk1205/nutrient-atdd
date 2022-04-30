package com.example.nutrient.documentation.combination;

import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.application.dto.combination.CombinationResponse;
import com.example.nutrient.application.dto.combination.HealthConditionResponse;
import com.example.nutrient.domain.Gender;
import org.springframework.restdocs.snippet.Snippet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class CombinationDocumentationFixture {
    public static final CombinationCreateRequest CREATE_REQUEST;
    public static final List<UUID> COMBINATION_LINE_ITEM_IDS;
    public static final HealthConditionResponse HEALTH_CONDITION_RESPONSE;
    public static final CombinationResponse RESPONSE;

    static {
        COMBINATION_LINE_ITEM_IDS = Arrays.asList(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID()
        );

        CREATE_REQUEST = new CombinationCreateRequest(
                "무기력증에 추천",
                "<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>",
                COMBINATION_LINE_ITEM_IDS,
                Gender.MALE,
                UUID.randomUUID()
        );

        HEALTH_CONDITION_RESPONSE = new HealthConditionResponse(
                UUID.randomUUID(),
                "무기력증"
        );

        RESPONSE = new CombinationResponse(
                UUID.randomUUID(),
                "무기력증에 추천",
                "<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>",
                Collections.EMPTY_LIST,
                Gender.MALE,
                HEALTH_CONDITION_RESPONSE
        );
    }

    public static Snippet getResponseFields() {
        return responseFields(
                fieldWithPath("id").description("조합 ID"),
                fieldWithPath("title").description("조합 제목"),
                fieldWithPath("content").description("조합 내용"),
                fieldWithPath("supplementResponses").description("조합 품목 목록"),
                fieldWithPath("recommendedGender").description("추천 성별(ALL: 모두, MALE: 남성, FEMALE: 여성)"),
                fieldWithPath("healthConditionResponse").description("건강 상태"),
                fieldWithPath("healthConditionResponse.id").description("건강 상태 ID"),
                fieldWithPath("healthConditionResponse.name").description("건강 상태 이름")
        );
    }
}
