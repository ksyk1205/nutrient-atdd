package com.example.nutrient.acceptance.suplement;

import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_삭제_요청;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_삭제됨;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_생성_요청;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_생성됨;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_수정_요청;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_수정됨;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.카테고리_생성되어_있음;

import com.example.nutrient.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("영양제 관리")
public class SupplementAcceptanceTest extends AcceptanceTest {

    private UUID 홍삼제품;
    private UUID 클로렐라;

    @BeforeEach
    public void setUp() {
        super.setUp();
        홍삼제품 = 카테고리_생성되어_있음("홍삼제품");
        클로렐라 = 카테고리_생성되어_있음("클로렐라");
    }

    @Test
    @DisplayName("영양제를 관리한다")
    public void manage() {
        ExtractableResponse<Response> 고려홍삼정_PREMIUM	 = 영양제_생성_요청(
            new SupplementCreateRequest(
                "6년근 고려홍삼정 PREMIUM",
                "201100200015",
                "2011-12-09",
                "제조일로부터 24개월",
                "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
                "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
                "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
                "직사광선을 피해 건조하고 서늘한 곳에서 보관한다.", 홍삼제품));
        영양제_생성됨(고려홍삼정_PREMIUM.statusCode());

        UUID 고려홍삼정_PREMIUM_ID = 고려홍삼정_PREMIUM.response().jsonPath().getUUID("id");
        ExtractableResponse<Response> 김화란_클로렐라 = 영양제_수정_요청(new SupplementUpdateRequest(
            고려홍삼정_PREMIUM_ID,
            "김화란 클로렐라",
            "20040020014500",
            "2010-08-13",
            "제조일로부터 24개월",
            "1일 1회, 1회 1포를 물 또는 우유에 타서 섭취하십시오.",
            "[클로렐라 제품]1. 피부건강에 도움 2. 항산화작용",
            "특정 성분에 알레르기 체질이신 분은 섭취 전 원료(성분)를 확인하시기 바랍니다.",
            "직사광선을 피하고 서늘한 곳에 보관 및 유통",
            클로렐라
        ));
        영양제_수정됨(김화란_클로렐라.statusCode());
        UUID 김화란_클로렐라_ID = 김화란_클로렐라.response().jsonPath().getUUID("id");
        ExtractableResponse<Response> 영양제_삭제_요청 = 영양제_삭제_요청(김화란_클로렐라_ID);
        영양제_삭제됨(영양제_삭제_요청.statusCode());
    }

    @Getter
    @AllArgsConstructor
    static class SupplementCreateRequest {
        private String name;
        private String serialNumber;
        private String permitDate;
        private String expirationDate;
        private String intake;
        private String mainFunctional;
        private String precautions;
        private String storageWay;
        private UUID categoryId;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class SupplementUpdateRequest {
        private UUID id;
        private String name;
        private String serialNumber;
        private String permitDate;
        private String expirationDate;
        private String intake;
        private String mainFunctional;
        private String precautions;
        private String storageWay;
        private UUID categoryId;
    }
}
