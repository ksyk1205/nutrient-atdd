package com.example.nutrient.acceptance.combination;

import com.example.nutrient.domain.Gender;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CombinationSteps {
    private static final String ENDPOINT = "/api/combinations";

    @Given("카테고리 생성되어있음")
    public static String 카테고리_생성되어있음(String name) {
        return UUID.randomUUID().toString();
    }

    @Given("영양제 생성되어있음")
    public static String 영양제_생성되어있음(String name, String categoryId) {
        // TODO: Fixture 사용
        return UUID.randomUUID().toString();
    }

    @When("영양제 조합 생성 요청")
    public static ExtractableResponse<Response> 영양제_조합_생성_요청(String accessToken, String title, String content, List<String> supplementIds, String healthStatusId) {
        Map<String, Object> createParams = createCombinationCreateParams(title, content, supplementIds, Gender.ALL, healthStatusId);
        return RestAssured.given().log().all()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .body(createParams)
                .when().post(ENDPOINT)
                .then().log().all().extract();
    }

    private static Map<String, Object> createCombinationCreateParams(
            String title, String content, List<String> supplementIds, Gender recommendedGender, String healthStatusId) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("content", content);
        params.put("supplementIds", supplementIds);
        params.put("recommendedGender", recommendedGender);
        params.put("healthStatusId", healthStatusId);
        return params;
    }

    @Then("영양제 조합 생성됨")
    public static void 영양제_조합_생성됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("영양제 조합 수정 요청")
    public static ExtractableResponse<Response> 영양제_조합_수정_요청(String accessToken, ExtractableResponse<Response> response, String title, String content, List<String> supplementIds, String healthStatusId) {
        Map<String, Object> updateParams = createCombinationUpdateParams(title, content, supplementIds, Gender.ALL, healthStatusId);
        return RestAssured.given().log().all()
                .auth().oauth2(accessToken)
                .queryParam("combinationId", response.jsonPath().getString("id"))
                .contentType(ContentType.JSON)
                .body(updateParams)
                .when().put(ENDPOINT)
                .then().log().all().extract();
    }

    private static Map<String, Object> createCombinationUpdateParams(
            String title, String content, List<String> supplementIds, Gender recommendedGender, String healthStatusId) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("content", content);
        params.put("supplementIds", supplementIds);
        params.put("recommendedGender", recommendedGender);
        params.put("healthStatusId", healthStatusId);
        return params;
    }

    @Then("영양제 조합 수정됨")
    public static void 영양제_조합_수정됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("영양제 조합 삭제 요청")
    public static void 영양제_조합_삭제_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("영양제 조합 삭제됨")
    public static void 영양제_조합_삭제됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
