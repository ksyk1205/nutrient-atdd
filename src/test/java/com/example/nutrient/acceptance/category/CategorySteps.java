package com.example.nutrient.acceptance.category;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class CategorySteps {
    private static final String ENDPOINT = "/api/categories";

    @When("카테고리 생성 요청")
    public static ExtractableResponse<Response> 카테고리_생성_요청(String name) {
        Map<String, Object> createParams = getCategoryCreateParams(name);

        return RestAssured.given().log().all()
                .body(createParams)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().post(ENDPOINT)
                .then().log().all().extract();
    }

    private static Map<String, Object> getCategoryCreateParams(String name) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name);
            return params;
    }

    @Then("카테고리 생성됨")
    public static void 카테고리_생성됨(int statusCode) {
        assertThat(statusCode).isEqualTo(CREATED.value());
    }

    @When("카테고리 자식 생성 요청")
    public static ExtractableResponse<Response> 카테고리_자식_생성_요청(String name, Integer depth) {
        Map<String, Object> createParams = getCategoryCreateParams(name,depth);

        return RestAssured.given().log().all()
                .body(createParams)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().post(ENDPOINT)
                .then().log().all().extract();

    }
    private static Map<String, Object> getCategoryCreateParams(String name, Integer depth) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("depth", depth);
        return params;
    }

    @Then("카테고리 자식 생성됨")
    public static void 카테고리_자식_생성됨(int statusCode) {
        assertThat(statusCode).isEqualTo(CREATED.value());
    }

    @When("카테고리 수정 요청")
    public static ExtractableResponse<Response> 카테고리_수정_요청(UUID id, String name, int depth) {
        Map<String, Object> updateParams = getCategoryUpdateParams(name, depth);

        return RestAssured.given().log().all()
                .body(updateParams)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().put(ENDPOINT+"/{id}",id)
                .then().log().all().extract();
    }

    private static Map<String, Object> getCategoryUpdateParams(String name, int depth) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("depth", depth);
        return params;
    }

    @Then("카테고리 수정됨")
    public static void 카테고리_수정됨(int statusCode) {
        assertThat(statusCode).isEqualTo(OK.value());
    }
    @When("카테고리 삭제 요청")
    public void 카테고리_삭제_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("카테고리 삭제됨")
    public void 카테고리_삭제됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
