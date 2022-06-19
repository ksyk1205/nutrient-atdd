package com.example.nutrient.documentation.supplement;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;

import org.hibernate.query.QueryParameter;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.request.PathParametersSnippet;
import org.springframework.restdocs.request.RequestParametersSnippet;
import org.springframework.restdocs.snippet.Snippet;

public class SupplementDocumentationSteps {

    public static RequestFieldsSnippet getCreateRequestFields() {
        return requestFields(
            fieldWithPath("name").description("품목명"),
            fieldWithPath("serialNumber").description("품목제조번호"),
            fieldWithPath("permitDate").description("허가 일자"),
            fieldWithPath("expirationDate").description("유통기한 일수"),
            fieldWithPath("intake").description("섭취방법"),
            fieldWithPath("mainFunctional").description("주된기능성"),
            fieldWithPath("precautions").description("섭취시 주의사항"),
            fieldWithPath("storageWay").description("보관방법"),
            fieldWithPath("categoryId").description("영양제 카테고리 ID")
        );
    }

    public static Snippet getCreateResponseFields() {
        return responseFields(
            fieldWithPath("id").description("영양제 ID"),
            fieldWithPath("name").description("품목명"),
            fieldWithPath("serialNumber").description("품목제조번호"),
            fieldWithPath("permitDate").description("허가 일자"),
            fieldWithPath("expirationDate").description("유통기한 일수"),
            fieldWithPath("intake").description("섭취방법"),
            fieldWithPath("mainFunctional").description("주된기능성"),
            fieldWithPath("precautions").description("섭취시 주의사항"),
            fieldWithPath("storageWay").description("보관방법"),
            fieldWithPath("category.id").description("영양제 카테고리 ID"),
            fieldWithPath("category.name").description("영양제 카테고리 이름")
        );
    }
    public static PathParametersSnippet getUpdateRequestPathParams() {
        return pathParameters(
            parameterWithName("id").description("영양제 ID")
        );
    }

    public static RequestFieldsSnippet getUpdateRequestFields() {
       return requestFields(
            fieldWithPath("name").description("품목명"),
            fieldWithPath("serialNumber").description("품목제조번호"),
            fieldWithPath("permitDate").description("허가 일자"),
            fieldWithPath("expirationDate").description("유통기한 일수"),
            fieldWithPath("intake").description("섭취방법"),
            fieldWithPath("mainFunctional").description("주된기능성"),
            fieldWithPath("precautions").description("섭취시 주의사항"),
            fieldWithPath("storageWay").description("보관방법"),
            fieldWithPath("categoryId").description("영양제 카테고리 ID")
        );
    }
    public static Snippet getUpdateResponseFields(){
        return responseFields(
            fieldWithPath("id").description("영양제 ID"),
            fieldWithPath("name").description("품목명"),
            fieldWithPath("serialNumber").description("품목제조번호"),
            fieldWithPath("permitDate").description("허가 일자"),
            fieldWithPath("expirationDate").description("유통기한 일수"),
            fieldWithPath("intake").description("섭취방법"),
            fieldWithPath("mainFunctional").description("주된기능성"),
            fieldWithPath("precautions").description("섭취시 주의사항"),
            fieldWithPath("storageWay").description("보관방법"),
            fieldWithPath("category.id").description("영양제 카테고리 ID"),
            fieldWithPath("category.name").description("영양제 카테고리 이름")
        );
    }

    public static PathParametersSnippet getDeleteRequestPathParams() {
        return pathParameters(
            parameterWithName("id").description("영양제 ID")
        );
    }

    public static PathParametersSnippet getSearchRequestPathParams() {
        return pathParameters(
            parameterWithName("id").description("영양제 ID")
        );
    }

    public static Snippet getSearchResponseFields() {
        return responseFields(
            fieldWithPath("id").description("영양제 ID"),
            fieldWithPath("name").description("품목명"),
            fieldWithPath("serialNumber").description("품목제조번호"),
            fieldWithPath("permitDate").description("허가 일자"),
            fieldWithPath("expirationDate").description("유통기한 일수"),
            fieldWithPath("intake").description("섭취방법"),
            fieldWithPath("mainFunctional").description("주된기능성"),
            fieldWithPath("precautions").description("섭취시 주의사항"),
            fieldWithPath("storageWay").description("보관방법"),
            fieldWithPath("lowestPrices[].title").description("최저가 타이틀"),
            fieldWithPath("lowestPrices[].link").description("최저가 링크"),
            fieldWithPath("lowestPrices[].lprice").description("최저가 가격"),
            fieldWithPath("category.id").description("영양제 카테고리 ID"),
            fieldWithPath("category.name").description("영양제 카테고리 이름")
        );
    }


    public static RequestParametersSnippet getSearchByPageRequestParams() {
        return requestParameters(
            parameterWithName("page").optional().description("페이지 번호"),
            parameterWithName("size").optional().description("페이지 크기")
        );
    }

    public static Snippet getSearchByPageResponseFields() {
        return responseFields(
            fieldWithPath("content[].id").description("영양제 ID"),
            fieldWithPath("content[].name").description("품목명"),
            fieldWithPath("content[].serialNumber").description("품목제조번호"),
            fieldWithPath("content[].permitDate").description("허가 일자"),
            fieldWithPath("content[].expirationDate").description("유통기한 일수"),
            fieldWithPath("content[].intake").description("섭취방법"),
            fieldWithPath("content[].mainFunctional").description("주된기능성"),
            fieldWithPath("content[].precautions").description("섭취시 주의사항"),
            fieldWithPath("content[].storageWay").description("보관방법"),
            fieldWithPath("content[].category.id").description("영양제 카테고리 ID"),
            fieldWithPath("content[].category.name").description("영양제 카테고리 이름"),
            subsectionWithPath("pageable").ignored(),
            fieldWithPath("last").ignored(),
            fieldWithPath("totalElements").ignored(),
            fieldWithPath("totalPages").ignored(),
            fieldWithPath("size").ignored(),
            fieldWithPath("number").ignored(),
            fieldWithPath("first").ignored(),
            subsectionWithPath("sort").ignored(),
            fieldWithPath("numberOfElements").ignored(),
            fieldWithPath("empty").ignored()
        );
    }
}
