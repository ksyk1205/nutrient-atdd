package com.example.nutrient.acceptance.auth;

import com.example.nutrient.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.nutrient.acceptance.auth.AuthSteps.로그인_되어_있음;
import static com.example.nutrient.acceptance.auth.MemberSteps.*;

class AuthAcceptanceTest extends AcceptanceTest {
    private static final String EMAIL = "email@email.com";
    private static final String PASSWORD = "password";
    private static final Integer AGE = 20;

    @DisplayName("Bearer Auth")
    @Test
    void myInfoWithBearerAuth() {
        회원_생성_요청(EMAIL, PASSWORD, AGE);

        String accessToken = 로그인_되어_있음(EMAIL, PASSWORD);

        ExtractableResponse<Response> response = 내_회원_정보_조회_요청(accessToken);

        회원_정보_조회됨(response, EMAIL, AGE);
    }
}
