package com.example.nutrient.acceptance.suplement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;

public class SupplementSteps {

    private static final String ENDPOINT = "/api/supplement";

    @Given("로그인 되어 있음")
    public void 로그인_되어_있음() {

    }

    @Given("카테고리 생성되어 있음")
    public static String 카테고리_생성되어_있음(String name) {
        return 카테고리_생성_요청();
    }

    private static String 카테고리_생성_요청() {
        return UUID.randomUUID().toString();
    }

    @When("영양제 생성 요청")
    public static ExtractableResponse<Response> 영양제_생성_요청(String name, String content, String categoryId) {
        Map<String, Object> createParams = createSupplementCreateParams(name, content, categoryId);
        return RestAssured.given().log().all()
            .body(createParams)
            .contentType(APPLICATION_JSON_VALUE)
            .accept(APPLICATION_JSON_VALUE)
            .when().post(ENDPOINT)
            .then().log().all().extract();
    }

    private static Map<String, Object> createSupplementCreateParams(String name, String content, String categoryId) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("content", content);
        params.put("categoryId", categoryId);
        return params;
    }

    @Then("영양제 생성됨")
    public static void 영양제_생성됨(int statusCode) {
        assertThat(statusCode).isEqualTo(CREATED);
    }

    @When("영양제 수정 요청")
    public void 영양제_수정_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("영양제 수정됨")
    public void 영양제_수정됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("영양제 삭제 요청")
    public void 영양제_삭제_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("영양제 삭제됨")
    public void 영양제_삭제됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
