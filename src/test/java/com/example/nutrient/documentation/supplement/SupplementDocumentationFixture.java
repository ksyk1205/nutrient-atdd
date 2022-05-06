package com.example.nutrient.documentation.supplement;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import java.util.UUID;
import org.springframework.restdocs.snippet.Snippet;

public class SupplementDocumentationFixture {

    public static final SupplementCreateResponse RESPONSE;
    public static final SupplementCreateRequest CREATE_REQUEST;

    public static final String CATEGORY_ID;

    static {
        CATEGORY_ID = UUID.randomUUID().toString();

        RESPONSE = new SupplementCreateResponse(
            UUID.randomUUID().toString(),
            "센트룸_멀티비타민_미네랄_구미", "9가지 비타민과 미네랄을 한번에 섭취가능합니다.",
            "1)1일 2구미 2)씹어서섭취 3)건조하고 서늘한 곳 보관 4)만 9세이상 섭취 권장",
            "1)12세 이상의 섭취를 권장합니다. 2)일일섭취량을 초과하여 섭취하지 마십시오",
            new SupplementCreateResponse.CategoryResponse(CATEGORY_ID, "멀티 비타민")
        );
        CREATE_REQUEST = new SupplementCreateRequest(
            "센트룸_멀티비타민_미네랄_구미", "9가지 비타민과 미네랄을 한번에 섭취가능합니다.",
            "1)1일 2구미 2)씹어서섭취 3)건조하고 서늘한 곳 보관 4)만 9세이상 섭취 권장",
            "1)12세 이상의 섭취를 권장합니다. 2)일일섭취량을 초과하여 섭취하지 마십시오",
            CATEGORY_ID
        );
    }

    public static Snippet getResponseFields() {
        return responseFields(
            fieldWithPath("id").description("영양제 ID"),
            fieldWithPath("name").description("영양제 이름"),
            fieldWithPath("content").description("영양제 설명"),
            fieldWithPath("intake").description("영양제 섭취방법"),
            fieldWithPath("precautions").description("영양제 주의사항"),
            fieldWithPath("category.id").description("영양제 카테고리 ID"),
            fieldWithPath("category.name").description("영양제 카테고리 이름")
        );
    }
}
