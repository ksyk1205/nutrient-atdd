package com.example.nutrient.documentation.supplement;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.request.PathParametersSnippet;
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
}
