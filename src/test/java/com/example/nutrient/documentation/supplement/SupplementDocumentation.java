package com.example.nutrient.documentation.supplement;

import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.CREATE_REQUEST;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.CREATE_RESPONSE;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.SEARCH_RESPONSE;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.UPDATE_REQUEST;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationFixture.UPDATE_RESPONSE;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getCreateRequestFields;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getCreateResponseFields;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getDeleteRequestPathParams;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getSearchRequestPathParams;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getSearchResponseFields;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getUpdateRequestFields;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getUpdateRequestPathParams;
import static com.example.nutrient.documentation.supplement.SupplementDocumentationSteps.getUpdateResponseFields;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.auth.AuthConfig;
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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;

@WebMvcTest(controllers = {SupplementController.class},
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = AuthConfig.class)}
)
public class SupplementDocumentation extends Documentation {

    private final static String ENDPOINT = "/api/supplements";

    @MockBean
    private SupplementService supplementService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        given(supplementService.create(any(SupplementCreateRequest.class))).willReturn(
            CREATE_RESPONSE);
        mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(CREATE_REQUEST)))
            .andExpect(status().isCreated())
            .andDo(print())
            .andDo(document("supplement-create",
                getCreateRequestFields(),
                getCreateResponseFields())
            );
    }

    @Test
    void update() throws Exception {
        given(supplementService.update(any(UUID.class),
            any(SupplementUpdateRequest.class))).willReturn(UPDATE_RESPONSE);

        mockMvc.perform(put(ENDPOINT + "/{id}", CREATE_RESPONSE.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UPDATE_REQUEST)))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("supplement-update",
                getUpdateRequestPathParams(),
                getUpdateRequestFields(),
                getUpdateResponseFields())
            );
    }


    @Test
    void remove() throws Exception {
        mockMvc.perform(delete(ENDPOINT + "/{id}", UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("supplement-delete",
                getDeleteRequestPathParams())
            );
    }

    @Test
    void search() throws Exception {
        given(supplementService.search(any(UUID.class))).willReturn(SEARCH_RESPONSE);
        mockMvc.perform(get(ENDPOINT + "/{id}", UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("supplement-search",
                getSearchRequestPathParams(),
                getSearchResponseFields())
            );
    }

}
