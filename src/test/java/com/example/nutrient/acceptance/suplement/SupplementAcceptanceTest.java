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
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("영양제 관리")
public class SupplementAcceptanceTest extends AcceptanceTest {

    private String 멀티비타민;

    @BeforeEach
    public void setUp() {
        super.setUp();
        멀티비타민 = 카테고리_생성되어_있음("멀티비타민");
    }

    @Test
    @DisplayName("영양제를 관리한다")
    public void manage() {
        ExtractableResponse<Response> 센트룸_멀티비타민_미네랄_구미 = 영양제_생성_요청(
            new 영양제_생성_요청("센트룸_멀티비타민_미네랄_구미", "9가지 비타민과 미네랄을 한번에 섭취가능합니다.",
                "1)1일 2구미 2)씹어서섭취 3)건조하고 서늘한 곳 보관 4)만 9세이상 섭취 권장",
                "1)12세 이상의 섭취를 권장합니다. 2)일일섭취량을 초과하여 섭취하지 마십시오", 멀티비타민));
        영양제_생성됨(센트룸_멀티비타민_미네랄_구미.statusCode());
        //영양제_수정_요청(영양제_수정_요청_생성(센트룸_멀티비타민_미네랄_구미.response().body()));
    }

    @Getter
    @AllArgsConstructor
    static class 영양제_생성_요청 {
        private String name;
        private String content;
        private String intake;
        private String precautions;
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
