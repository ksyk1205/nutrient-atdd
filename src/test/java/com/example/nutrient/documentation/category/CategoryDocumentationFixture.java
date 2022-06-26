package com.example.nutrient.documentation.category;

import com.example.nutrient.application.dto.category.*;
import org.springframework.restdocs.snippet.Snippet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

public class CategoryDocumentationFixture {
    public static final CategoryCreateRequest CREATE_PARENT_REQUEST;

    public static final CategoryCreateRequest CREATE_CHILD_REQUEST;

    public static final CategoryCreateResponse CREATE_PARENT_RESPONSE;

    public static final CategoryCreateResponse CREATE_CHILD_RESPONSE;

    public static final CategoryUpdateRequest UPDATE_REQUEST;

    public static final CategoryUpdateResponse UPDATE_RESPONSE;

    public static final List<CategorySearchResponse> SEARCH_RESPONSE;

    static {

        CREATE_PARENT_REQUEST  = new CategoryCreateRequest(
                "비타민"
        );

        CREATE_PARENT_RESPONSE = new CategoryCreateResponse(
                UUID.randomUUID(),
                "비타민",
                0
        );


        CREATE_CHILD_REQUEST  = new CategoryCreateRequest(
                "비타민D"
                ,1
        );

        CREATE_CHILD_RESPONSE = new CategoryCreateResponse(
                UUID.randomUUID(),
                "비타민D",
                1
        );

        UPDATE_REQUEST = new CategoryUpdateRequest(
                "비타민A",
                0
        );

        UPDATE_RESPONSE = new CategoryUpdateResponse(
                UUID.randomUUID(),
                "비타민A",
                1
        );

        SEARCH_RESPONSE = Arrays.asList(new CategorySearchResponse(
                UUID.randomUUID(),
                "비타민A",
                1
                )
            );
    }

    public static Snippet getCreateRequestFields(){
        return requestFields(
                fieldWithPath("name").description("카테고리명"),
                fieldWithPath("depth").description("카테고리레벨")
        );
    }
    public static Snippet getCreateResponseFields() {
        return responseFields(
                fieldWithPath("id").description("카테고리 ID"),
                fieldWithPath("name").description("카테고리명"),
                fieldWithPath("depth").description("카테고리 레벨")
        );
    }

    public static Snippet getUpdatePathParams(){
        return pathParameters(
                parameterWithName("id").description("카테고리 ID")
        );
    }

    public static Snippet getUpdateRequestFields(){
        return requestFields(
                fieldWithPath("name").description("카테고리명"),
                fieldWithPath("depth").description("카테고리레벨")
        );
    }
    public static Snippet getUpdateResponseFields(){
        return responseFields(
                fieldWithPath("id").description("카테고리 ID"),
                fieldWithPath("name").description("카테고리명"),
                fieldWithPath("depth").description("카테고리 레벨")
        );
    }
    public static Snippet getSearchResponseFields(){
        return responseFields(
                beneathPath("[]"),
                fieldWithPath("id").description("카테고리 ID"),
                fieldWithPath("name").description("카테고리명"),
                fieldWithPath("depth").description("카테고리 레벨")
        );
    }

    public static Snippet getDeletePathParams(){
        return pathParameters(
                parameterWithName("id").description("카테고리 ID")
        );
    }
}
