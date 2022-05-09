package com.example.nutrient.acceptance.auth;

import com.example.auth.authorization.Role;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberSteps {
    public static final String USER_EMAIL = "user@email.com";
    public static final String ADMIN_EMAIL = "admin@email.com";
    public static final String PASSWORD = "password";
    public static final Integer AGE = 20;

    @Given("회원 생성되어있음")
    public static void 회원_생성되어있음() {
        회원_생성_요청(USER_EMAIL, PASSWORD, AGE, List.of(Role.USER));
    }

    @Given("관리자 계정 생성되어있음")
    public static void 관리자_계정_생성되어있음() {
        회원_생성_요청(ADMIN_EMAIL, PASSWORD, AGE, List.of(Role.ADMIN));
    }

    @When("회원 생성 요청")
    public static ExtractableResponse<Response> 회원_생성_요청(String email, String password, Integer age) {
        Map<String, String> params = createParams(email, password, age);

        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .when().post("/api/members")
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 회원_생성_요청(String email, String password, Integer age, List<Role> roles) {
        Map<String, Object> params = createParams(email, password, age, roles);

        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .when().post("/api/members")
                .then().log().all().extract();
    }

    @Then("회원 생성됨")
    public static void 회원_생성됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @When("회원 정보 조회 요청")
    public static ExtractableResponse<Response> 회원_정보_조회_요청(ExtractableResponse<Response> response) {
        String uri = response.header("Location");

        return RestAssured.given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().get(uri)
                .then().log().all()
                .extract();
    }

    @Then("회원 정보 조회됨")
    public static void 회원_정보_조회됨(ExtractableResponse<Response> response, String email, int age) {
        assertThat(response.jsonPath().getString("id")).isNotNull();
        assertThat(response.jsonPath().getString("email")).isEqualTo(email);
        assertThat(response.jsonPath().getInt("age")).isEqualTo(age);
    }

    @When("회원 정보 수정 요청")
    public static ExtractableResponse<Response> 회원_정보_수정_요청(ExtractableResponse<Response> response, String email, String password, Integer age) {
        String uri = response.header("Location");
        Map<String, String> params = createParams(email, password, age);

        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .when().put(uri)
                .then().log().all().extract();
    }

    @Then("회원 정보 수정됨")
    public static void 회원_정보_수정됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @When("회원 정보 삭제 요청")
    public static ExtractableResponse<Response> 회원_삭제_요청(ExtractableResponse<Response> response) {
        String uri = response.header("Location");
        return RestAssured
                .given().log().all()
                .when().delete(uri)
                .then().log().all().extract();
    }

    @Then("회원 정보 삭제됨")
    public static void 회원_삭제됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @When("내 회원 정보 조회 요청")
    public static ExtractableResponse<Response> 내_회원_정보_조회_요청(String accessToken) {
        return RestAssured.given().log().all()
                .auth().oauth2(accessToken)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/members/me")
                .then().log().all()
                .statusCode(HttpStatus.OK.value())
                .extract();
    }

    private static Map<String, String> createParams(String email, String password, Integer age) {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        params.put("age", age + "");
        return params;
    }

    private static Map<String, Object> createParams(String email, String password, Integer age, List<Role> roles) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        params.put("age", age + "");
        params.put("roles", roles);
        return params;
    }
}
