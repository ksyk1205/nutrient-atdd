package com.example.nutrient.documentation.category;

import com.example.auth.AuthConfig;
import com.example.nutrient.application.CategoryService;
import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.application.dto.category.CategoryUpdateRequest;
import com.example.nutrient.documentation.Documentation;
import com.example.nutrient.ui.CategoryRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;

import java.util.UUID;

import static com.example.nutrient.documentation.category.CategoryDocumentationFixture.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryRestController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = AuthConfig.class)}
)
public class CategoryDocumentation extends Documentation {
    private final static String ENDPOINT = "/api/categories";

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("부모 카테고리를 생성한다.")
    void parentCreate() throws Exception {
        given(categoryService.create(any(CategoryCreateRequest.class))).willReturn(CREATE_PARENT_RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CREATE_PARENT_REQUEST)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("category-parent-create",
                                getCreateRequestFields(),
                                getCreateResponseFields()
                        )
                );

    }

    @Test
    @DisplayName("자식 카테고리를 생성한다.")
    void childCreate() throws Exception {
        given(categoryService.create(any(CategoryCreateRequest.class))).willReturn(CREATE_CHILD_RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CREATE_CHILD_REQUEST)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("category-child-create",
                                getCreateRequestFields(),
                                getCreateResponseFields()
                        )
                );

    }

    @Test
    @DisplayName("카테고리를 수정한다.")
    void update() throws Exception {
        given(categoryService.update(any(UUID.class), any(CategoryUpdateRequest.class))).willReturn(UPDATE_RESPONSE);

        mockMvc.perform(put(ENDPOINT + "/{id}", UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(UPDATE_REQUEST)))

                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("category-update",
                                getUpdatePathParams(),
                                getUpdateRequestFields(),
                                getUpdateResponseFields()
                        )
                );
    }

    @Test
    @DisplayName("카테고리 리스트를 조회한다.")
    void search() throws Exception {
        given(categoryService.search()).willReturn(SEARCH_RESPONSE);

        mockMvc.perform(get(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("category-search",
                                getSearchResponseFields()
                        )
                );

    }

    @Test
    @DisplayName("카테고리를 삭제한다.")
    void remove() throws Exception {
        mockMvc.perform(delete(ENDPOINT + "/{id}", UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isNoContent())
                .andDo(print())
                .andDo(document("category-delete",
                                getDeletePathParams()
                        )
                );

    }

}
