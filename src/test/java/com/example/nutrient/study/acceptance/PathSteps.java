package com.example.nutrient.study.acceptance;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PathSteps {
    @Given("지하철역이 등록되어있음")
    public static void 지하철역이_등록되어있음() {

    }

    @And("지하철 노선이 등록되어있음")
    public static void 지하철_노선이_등록되어있음() {
    }

    @And("지하철 노선에 지하철역이 등록되어있음")
    public static void 지하철_노선에_지하철역이_등록되어있음() {
    }

    @And("로그인 되어있음")
    public static void 로그인_되어있음() {

    }

    @When("출발역에서 도착역까지의 최단 거리 경로 조회를 요청")
    public static void 출발역에서_도착역까지의_최단_거리_경로_조회를_요청() {
    }

    @Then("최단 거리 경로를 응답")
    public static void 최단_거리_경로를_응답() {
    }

    @And("총 거리와 소요 시간을 함께 응답함")
    public static void 총_거리와_소요_시간을_함께_응답함() {
    }

    @And("지하철 이용 요금도 함께 응답함")
    public static void 지하철_이용_요금도_함께_응답함() {
    }
}
