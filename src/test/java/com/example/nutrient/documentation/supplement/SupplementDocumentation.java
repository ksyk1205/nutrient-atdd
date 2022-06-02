package com.example.nutrient.documentation.supplement;

import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.CREATE_REQUEST;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.CREATE_RESPONSE;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.UPDATE_REQUEST;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.UPDATE_RESPONSE;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.getResponseFields;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.nutrient.application.SupplementService;
import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementUpdateRequest;
import com.example.nutrient.documentation.Documentation;
import com.example.nutrient.ui.SupplementController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(SupplementController.class)
public class SupplementDocumentation extends Documentation {
    private final static String ENDPOINT = "/api/supplements";

    @MockBean
    private SupplementService supplementService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        given(supplementService.create(any(SupplementCreateRequest.class))).willReturn(CREATE_RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(CREATE_REQUEST)))
            .andExpect(status().isCreated())
            .andDo(print())
            .andDo(document("supplement-create",
                requestFields(
                    fieldWithPath("name").description("품목명"),
                    fieldWithPath("serialNumber").description("품목제조번호"),
                    fieldWithPath("permitDate").description("허가 일자"),
                    fieldWithPath("expirationDate").description("유통기한 일수"),
                    fieldWithPath("intake").description("섭취방법"),
                    fieldWithPath("mainFunctional").description("주된기능성"),
                    fieldWithPath("precautions").description("섭취시 주의사항"),
                    fieldWithPath("storageWay").description("보관방법"),
                    fieldWithPath("categoryId").description("영양제 카테고리 ID")
                ),
                getResponseFields())
            );

    }

    @Test
    void update() throws Exception {
        given(supplementService.update(any(SupplementUpdateRequest.class))).willReturn(UPDATE_RESPONSE);

        mockMvc.perform(post(ENDPOINT + "/{id}", CREATE_RESPONSE.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UPDATE_REQUEST)))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("supplement-update",
                requestFields(
                    fieldWithPath("id").description("영양제 ID"),
                    fieldWithPath("name").description("품목명"),
                    fieldWithPath("serialNumber").description("품목제조번호"),
                    fieldWithPath("permitDate").description("허가 일자"),
                    fieldWithPath("expirationDate").description("유통기한 일수"),
                    fieldWithPath("intake").description("섭취방법"),
                    fieldWithPath("mainFunctional").description("주된기능성"),
                    fieldWithPath("precautions").description("섭취시 주의사항"),
                    fieldWithPath("storageWay").description("보관방법"),
                    fieldWithPath("categoryId").description("영양제 카테고리 ID")
                ),
                getResponseFields())
            );

    }

    @Test
    void remove() throws Exception {
        mockMvc.perform(delete(ENDPOINT + "/{id}", UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("supplement-delete",
                requestFields(
                    fieldWithPath("id").description("영양제 ID")
                ))
            );
    }

}
