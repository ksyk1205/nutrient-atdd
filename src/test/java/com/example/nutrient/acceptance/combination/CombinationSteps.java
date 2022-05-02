package com.example.nutrient.acceptance.combination;

import com.example.nutrient.domain.Gender;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

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
        return UUID.randomUUID().toString();
    }

    @Given("건강 상태 생성되어있음")
    public static String 건강_상태_생성되어있음(String name) {
        return UUID.randomUUID().toString();
    }

    @When("영양제 조합 생성 요청")
    public static ExtractableResponse<Response> 영양제_조합_생성_요청(String title, String content, List<String> combinationLineItemIds, String healthConditionId) {
        Map<String, Object> createParams = createCombinationCreateParams(title, content, combinationLineItemIds, Gender.ALL, healthConditionId);

        return RestAssured.given().log().all()
                .body(createParams)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().post(ENDPOINT)
                .then().log().all().extract();
    }

    private static Map<String, Object> createCombinationCreateParams(
            String title, String content, List<String> combinationLineItemIds, Gender recommendedGender, String healthConditionId) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("content", content);
        params.put("combinationLineItemIds", combinationLineItemIds);
        params.put("recommendedGender", recommendedGender);
        params.put("healthConditionId", healthConditionId);
        return params;
    }

    @Then("영양제 조합 생성됨")
    public static void 영양제_조합_생성됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("영양제 조합 수정 요청")
    public static void 영양제_조합_수정_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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
