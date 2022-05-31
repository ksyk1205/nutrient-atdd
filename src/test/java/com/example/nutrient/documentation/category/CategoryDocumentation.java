package com.example.nutrient.documentation.category;

import com.example.nutrient.application.CategoryService;
import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.documentation.Documentation;
import com.example.nutrient.ui.CategoryRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static com.example.nutrient.documentation.category.CategoryDocumentationFixture.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryRestController.class)
public class CategoryDocumentation extends Documentation {
    private final static String ENDPOINT = "/api/categories";

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void parentCreate() throws Exception {
        given(categoryService.create(any(CategoryCreateRequest.class))).willReturn(CREATE_PARENT_RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CREATE_PARENT_REQUEST)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("category-create",
                        requestFields(
                                fieldWithPath("name").description("카테고리명")
                                , fieldWithPath("depth").description("카테고리레벨")
                        ),
                        getResponseFields())
                );

    }

    @Test
    void childCreate() throws Exception {
        given(categoryService.create(any(CategoryCreateRequest.class))).willReturn(CREATE_CHILD_RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CREATE_CHILD_REQUEST)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("category-create",
                        requestFields(
                                fieldWithPath("name").description("카테고리명")
                                , fieldWithPath("depth").description("카테고리레벨")
                        ),
                        getResponseFields())
                );

    }
}
