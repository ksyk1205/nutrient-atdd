package com.example.nutrient.acceptance.category;

import com.example.nutrient.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static com.example.nutrient.acceptance.category.CategorySteps.카테고리_생성_요청;

public class CategoryAcceptanceTest extends AcceptanceTest {

    @DisplayName("카테고리를 관리한다.")
    @Test
    void manage(){
        ExtractableResponse<Response> createResponse =
                카테고리_생성_요청("비타민");
    }
}
