package com.example.nutrient.documentation.supplement;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.restdocs.snippet.Snippet;

public class SupplementDocumentationFixture {

    public static final SupplementCreateResponse RESPONSE;
    public static final SupplementCreateRequest CREATE_REQUEST;

    public static final UUID CATEGORY_ID;

    static {
        CATEGORY_ID = UUID.randomUUID();

        RESPONSE = new SupplementCreateResponse(
            UUID.randomUUID(),
            "6년근 고려홍삼정 PREMIUM",
            "201100200015",
            LocalDate.of(2011, 12,9),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            "직사광선을 피해 건조하고 서늘한 곳에서 보관한다.",
            new SupplementCreateResponse.CategoryResponse(CATEGORY_ID, "홍삼 제품")
        );
        CREATE_REQUEST = new SupplementCreateRequest(
            "6년근 고려홍삼정 PREMIUM",
            "201100200015",
            LocalDate.of(2011, 12,9),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            "직사광선을 피해 건조하고 서늘한 곳에서 보관한다.", CATEGORY_ID
        );
    }

    public static Snippet getResponseFields() {
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
}
