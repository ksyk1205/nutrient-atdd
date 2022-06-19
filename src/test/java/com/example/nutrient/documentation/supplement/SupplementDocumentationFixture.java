package com.example.nutrient.documentation.supplement;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.example.nutrient.application.dto.supplement.LowestPriceResponse;
import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.application.dto.supplement.SupplementSearchResponse;
import com.example.nutrient.application.dto.supplement.SupplementUpdateRequest;
import com.example.nutrient.application.dto.supplement.SupplementUpdateResponse;
import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.CategoryContent;
import com.example.nutrient.domain.CategoryTitle;
import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.SupplementContent;
import com.example.nutrient.domain.SupplementTitle;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.restdocs.snippet.Snippet;

public class SupplementDocumentationFixture {

    public static final SupplementCreateResponse CREATE_RESPONSE;
    public static final SupplementCreateRequest CREATE_REQUEST;


    public static final SupplementUpdateResponse UPDATE_RESPONSE;
    public static final SupplementUpdateRequest UPDATE_REQUEST;

    public static final SupplementSearchResponse SEARCH_RESPONSE;
    public static final UUID CATEGORY_ID;
    public static final UUID UPDATE_CATEGORY_ID;

    static {
        CATEGORY_ID = UUID.randomUUID();

        CREATE_RESPONSE = new SupplementCreateResponse(
            UUID.randomUUID(),
            "6년근 고려홍삼정 PREMIUM",
            "201100200015",
            LocalDate.of(2011, 12, 9),
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
            LocalDate.of(2011, 12, 9),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            "직사광선을 피해 건조하고 서늘한 곳에서 보관한다.", CATEGORY_ID
        );

        UPDATE_CATEGORY_ID = UUID.randomUUID();

        UPDATE_RESPONSE = new SupplementUpdateResponse(
            CREATE_RESPONSE.getId(),
            "김화란 클로렐라",
            "20040020014500",
            LocalDate.of(2010, 8, 13),
            "제조일로부터 24개월",
            "1일 1회, 1회 1포를 물 또는 우유에 타서 섭취하십시오.",
            "[클로렐라 제품]1. 피부건강에 도움 2. 항산화작용",
            "특정 성분에 알레르기 체질이신 분은 섭취 전 원료(성분)를 확인하시기 바랍니다.",
            "직사광선을 피하고 서늘한 곳에 보관 및 유통",
            new SupplementUpdateResponse.CategoryResponse(UPDATE_CATEGORY_ID, "클로렐라")
        );
        UPDATE_REQUEST = new SupplementUpdateRequest(
            "김화란 클로렐라",
            "20040020014500",
            LocalDate.of(2010, 8, 13),
            "제조일로부터 24개월",
            "1일 1회, 1회 1포를 물 또는 우유에 타서 섭취하십시오.",
            "[클로렐라 제품]1. 피부건강에 도움 2. 항산화작용",
            "특정 성분에 알레르기 체질이신 분은 섭취 전 원료(성분)를 확인하시기 바랍니다.",
            "직사광선을 피하고 서늘한 곳에 보관 및 유통", UPDATE_CATEGORY_ID
        );
        ;
        SEARCH_RESPONSE = SupplementSearchResponse.of(
            Supplement.builder()
                .id(UUID.randomUUID())
                .title(new SupplementTitle("김화란 클로렐라"))
                .content(new SupplementContent("20040020014500",
                    LocalDate.of(2010, 8, 13),
                    "제조일로부터 24개월",
                    "1일 1회, 1회 1포를 물 또는 우유에 타서 섭취하십시오.",
                    "[클로렐라 제품]1. 피부건강에 도움 2. 항산화작용",
                    "특정 성분에 알레르기 체질이신 분은 섭취 전 원료(성분)를 확인하시기 바랍니다.",
                    "직사광선을 피하고 서늘한 곳에 보관 및 유통"))
                .category(
                    Category.builder().id(CATEGORY_ID).title(new CategoryTitle("비타민D"))
                        .content(new CategoryContent(1)).build()
                ).build(),
            Arrays.asList(new LowestPriceResponse("김화란 클로렐라 테스트1", "http://localhost", 50000L),
                new LowestPriceResponse("김화란 클로렐라 테스트2", "http://localhost", 45000L)))
        ;
    }


}
