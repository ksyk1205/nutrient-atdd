package com.example.nutrient.documentation.combination;

import com.example.nutrient.application.CombinationService;
import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.documentation.Documentation;
import com.example.nutrient.ui.CombinationRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static com.example.nutrient.documentation.combination.CombinationDocumentationFixture.*;
import static com.example.nutrient.documentation.combination.CombinationDocumentationFixture.CREATE_REQUEST;
import static com.example.nutrient.documentation.combination.CombinationDocumentationFixture.RESPONSE;
import static com.example.nutrient.documentation.combination.CombinationDocumentationSteps.getResponseFields;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CombinationRestController.class)
class CombinationDocumentation extends Documentation {
    private final static String ENDPOINT = "/api/combinations";

    @MockBean
    private CombinationService combinationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        given(combinationService.create(any(CombinationCreateRequest.class))).willReturn(RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CREATE_REQUEST)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("combination-create",
                        requestFields(
                                fieldWithPath("title").description("조합 제목"),
                                fieldWithPath("content").description("조합 내용"),
                                fieldWithPath("combinationLineItemIds").description("조합 품목 ID 목록"),
                                fieldWithPath("recommendedGender").description("추천 성별(ALL: 모두, MALE: 남성, FEMALE: 여성)"),
                                fieldWithPath("healthConditionId").description("건강 상태 ID")
                        ),
                        getResponseFields())
                );

    }
}
