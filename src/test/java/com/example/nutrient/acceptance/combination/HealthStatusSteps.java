package com.example.nutrient.acceptance.combination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.UUID;

public class HealthStatusSteps {
    @When("건강 상태 생성 요청")
    public void 건강_상태_생성_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("건강 상태 생성되어있음")
    public static String 건강_상태_생성되어있음(String name) {
        return UUID.randomUUID().toString();
    }

    @Then("건강 상태 생성됨")
    public void 건강_상태_생성됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("건강 상태 조회 요청")
    public void 건강_상태_조회_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("건강 상태 조회됨")
    public void 건강_상태_조회됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("건강 상태 수정 요청")
    public void 건강_상태_수정_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("건강 상태 수정됨")
    public void 건강_상태_수정됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("건강 상태 삭제 요청")
    public void 건강_상태_삭제_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("건강 상태 삭제됨")
    public void 건강_상태_삭제됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
