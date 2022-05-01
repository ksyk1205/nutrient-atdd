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
    private final static String ENDPOINT = "/api/category";

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        given(categoryService.create(any(CategoryCreateRequest.class))).willReturn(RESPONSE);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CREATE_REQUEST)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("category-create",
                        requestFields(
                                fieldWithPath("name").description("카테고리명"),
                                fieldWithPath("parentId").description("상위 카테고리 ID")
                        ),
                        getResponseFields())
                );

    }
}
