package com.example.nutrient.acceptance.suplement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.nutrient.acceptance.suplement.SupplementAcceptanceTest.SupplementCreateRequest;
import com.example.nutrient.acceptance.suplement.SupplementAcceptanceTest.SupplementUpdateRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SupplementSteps {

    private static final String ENDPOINT = "/api/supplements";

    @Given("로그인 되어 있음")
    public void 로그인_되어_있음() {

    }

    @Given("카테고리 생성되어 있음")
    public static UUID 카테고리_생성되어_있음(String name) {
        return 카테고리_생성_요청();
    }

    private static UUID 카테고리_생성_요청() {
        return UUID.randomUUID();
    }

    @When("영양제 생성 요청")
    public static ExtractableResponse<Response> 영양제_생성_요청(SupplementCreateRequest supplementCreateRequest) {
        Map<String, Object> createParams = createSupplementCreateParams(supplementCreateRequest);
        return RestAssured.given().log().all()
            .body(createParams)
            .contentType(APPLICATION_JSON_VALUE)
            .accept(APPLICATION_JSON_VALUE)
            .when().post(ENDPOINT)
            .then().log().all().extract();
    }
    private static Map<String, Object> createSupplementCreateParams(SupplementCreateRequest supplementCreateRequest) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", supplementCreateRequest.getName());
        params.put("serialNumber", supplementCreateRequest.getSerialNumber());
        params.put("permitDate", supplementCreateRequest.getPermitDate());
        params.put("expirationDate", supplementCreateRequest.getExpirationDate());
        params.put("intake", supplementCreateRequest.getIntake());
        params.put("mainFunctional", supplementCreateRequest.getMainFunctional());
        params.put("precautions", supplementCreateRequest.getPrecautions());
        params.put("storageWay", supplementCreateRequest.getStorageWay());
        params.put("categoryId", supplementCreateRequest.getCategoryId());
        return params;
    }

    @Then("영양제 생성됨")
    public static void 영양제_생성됨(int statusCode) {
        assertThat(statusCode).isEqualTo(CREATED.value());
    }

    @When("영양제 수정 요청")
    public static ExtractableResponse<Response> 영양제_수정_요청(SupplementUpdateRequest supplementUpdateRequest) {
        Map<String, Object> updateParams = createSupplementUpdateParams(supplementUpdateRequest);
        return RestAssured.given().log().all()
            .body(updateParams)
            .contentType(APPLICATION_JSON_VALUE)
            .accept(APPLICATION_JSON_VALUE)
            .when().patch(ENDPOINT)
            .then().log().all().extract();
    }

    private static Map<String, Object> createSupplementUpdateParams(SupplementUpdateRequest supplementUpdateRequest) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", supplementUpdateRequest.getId());
        params.put("name", supplementUpdateRequest.getName());
        params.put("serialNumber", supplementUpdateRequest.getSerialNumber());
        params.put("permitDate", supplementUpdateRequest.getPermitDate());
        params.put("expirationDate", supplementUpdateRequest.getExpirationDate());
        params.put("intake", supplementUpdateRequest.getIntake());
        params.put("mainFunctional", supplementUpdateRequest.getMainFunctional());
        params.put("precautions", supplementUpdateRequest.getPrecautions());
        params.put("storageWay", supplementUpdateRequest.getStorageWay());
        params.put("categoryId", supplementUpdateRequest.getCategory().getId());
        return params;
    }

    @Then("영양제 수정됨")
    public static void 영양제_수정됨(int statusCode) {
        assertThat(statusCode).isEqualTo(OK.value());
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
