package com.example.nutrient.acceptance.suplement;

import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_생성_요청;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.영양제_생성됨;
import static com.example.nutrient.acceptance.suplement.SupplementSteps.카테고리_생성되어_있음;

import com.example.nutrient.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void manage(){
        ExtractableResponse<Response> 비타민C = 영양제_생성_요청("비타민C", "피부, 힘줄, 인대 및 혈관을 만드는 중요한 단백질을 형성하는 데 사용됩니다.", 멀티비타민);
        영양제_생성됨(비타민C.statusCode());
    }

}
