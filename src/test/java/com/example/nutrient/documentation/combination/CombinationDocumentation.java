package com.example.nutrient.documentation.combination;

import com.example.auth.AuthConfig;
import com.example.nutrient.application.CombinationService;
import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.application.dto.combination.CombinationUpdateRequest;
import com.example.nutrient.documentation.Documentation;
import com.example.nutrient.ui.CombinationRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;

import java.util.UUID;

import static com.example.nutrient.documentation.combination.CombinationDocumentationFixture.*;
import static com.example.nutrient.documentation.combination.CombinationDocumentationSteps.*;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CombinationRestController.class,
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = AuthConfig.class)}
)
class CombinationDocumentation extends Documentation {
    private final static String ENDPOINT = "/api/combinations";

    @MockBean
    private CombinationService combinationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        given(combinationService.create(any(CombinationCreateRequest.class))).willReturn(CREATE_RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CREATE_REQUEST)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("combination-create",
                        getCreateRequestFields(),
                        getCreateResponseFields())
                );

    }

    @Test
    void update() throws Exception {
        given(combinationService.update(any(UUID.class), any(CombinationUpdateRequest.class))).willReturn(UPDATE_RESPONSE);

        mockMvc.perform(put(ENDPOINT + "/{combinationId}", UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(UPDATE_REQUEST)))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("combination-update",
                        getUpdateRequestPathParams(),
                        getUpdateRequestFields(),
                        getUpdateResponseFields())
                );
    }

    @Test
    void remove() throws Exception {
        mockMvc.perform(delete(ENDPOINT + "/{combinationId}", UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(UPDATE_REQUEST)))
                .andExpect(status().isNoContent())
                .andDo(print())
                .andDo(document("combination-delete",
                        getDeleteRequestPathParams())
                );
    }
}
