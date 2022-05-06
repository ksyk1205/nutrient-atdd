package com.example.nutrient.acceptance.suplement;

import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_생성_요청;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_생성됨;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_수정_요청;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.카테고리_생성되어_있음;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.example.nutrient.acceptance.AcceptanceTest;
import com.example.nutrient.application.SupplementService;
import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse.CategoryResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("영양제 관리")
public class SupplementAcceptanceTest extends AcceptanceTest {

    private String 홍삼제품;

    @BeforeEach
    public void setUp() {
        super.setUp();

        홍삼제품 = 카테고리_생성되어_있음("홍삼제품");
    }

    @Test
    @DisplayName("영양제를 관리한다")
    public void manage() {
        ExtractableResponse<Response> 고려홍삼정_PREMIUM	 = 영양제_생성_요청(
            new 영양제_생성_요청(
                "6년근 고려홍삼정 PREMIUM",
                "201100200015",
                LocalDate.of(2011, 12, 9),
                "제조일로부터 24개월",
                "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
                "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
                "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
                "직사광선을 피해 건조하고 서늘한 곳에서 보관한다.", 홍삼제품));
        영양제_생성됨(고려홍삼정_PREMIUM.statusCode());
        //영양제_수정_요청(영양제_수정_요청_생성(센트룸_멀티비타민_미네랄_구미.response().body()));
    }

    @Getter
    @AllArgsConstructor
    static class 영양제_생성_요청 {
        private String name;
        private String serialNumber;
        private LocalDate permitDate;
        private String expirationDate;
        private String intake;
        private String mainFunctional;
        private String precautions;
        private String storageWay;
        private String categoryId;
    }

    @Getter
    static class 영양제_수정_요청 {
        private String id;
        private String name;
        private String content;
        private String intake;
        private String precautions;
        private String categoryId;


        public static 영양제_수정_요청 영양제_수정_요청_생성(ResponseBody body) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                영양제_수정_요청 영양제_수정_요청 = objectMapper.readValue(body.toString(), 영양제_수정_요청.class);
                return 영양제_수정_요청;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
