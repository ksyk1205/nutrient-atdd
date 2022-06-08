package com.example.nutrient.acceptance.combination;

import com.example.nutrient.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.nutrient.acceptance.auth.AuthSteps.로그인_되어_있음;
import static com.example.nutrient.acceptance.auth.MemberSteps.*;
import static com.example.nutrient.acceptance.combination.CombinationSteps.*;
import static com.example.nutrient.acceptance.combination.HealthStatusSteps.건강_상태_생성되어있음;

@DisplayName("영양제 조합 관리")
class CombinationAcceptanceTest extends AcceptanceTest {
    private String 멀티비타민;
    private String 마그네슘;
    private String 루테인;
    private String 밀크시슬;
    private String 오메가3;

    private String 멀티비타민_센트룸;
    private String 마그네슘_솔가;
    private String 루테인_안국건강;
    private String 밀크시슬_나우푸드;
    private String 오메가3_종근당;

    private List<String> 영양제_목록;

    private String 무기력;

    String 사용자;

    @BeforeEach
    public void setUp() {
        super.setUp();
        멀티비타민 = 카테고리_생성되어있음("멀티비타민");
        마그네슘 = 카테고리_생성되어있음("마그네슘");
        루테인 = 카테고리_생성되어있음("루테인");
        밀크시슬 = 카테고리_생성되어있음("밀크시슬");
        오메가3 = 카테고리_생성되어있음("오메가3");

        멀티비타민_센트룸 = 영양제_생성되어있음("멀티비타민_센트룸", 멀티비타민);
        마그네슘_솔가 = 영양제_생성되어있음("마그네슘_솔가", 마그네슘);
        루테인_안국건강 = 영양제_생성되어있음("루테인_안국건강", 루테인);
        밀크시슬_나우푸드 = 영양제_생성되어있음("밀크시슬_나우푸드", 밀크시슬);
        오메가3_종근당 = 영양제_생성되어있음("오메가3_종근당", 오메가3);

        영양제_목록 = Arrays.asList(멀티비타민_센트룸, 마그네슘_솔가, 루테인_안국건강, 밀크시슬_나우푸드, 오메가3_종근당);

        무기력 = 건강_상태_생성되어있음("무기력");

        회원_생성되어있음();
        사용자 = 로그인_되어_있음(USER_EMAIL, PASSWORD);
    }

    @DisplayName("영양제 조합을 관리한다")
    @Test
    void manage() {
        ExtractableResponse<Response> createResponse =
                영양제_조합_생성_요청(사용자, "무기력증에 추천", "<p>일상이 무기력할 때 추천하는 영양제 조합입니다.</p>", 영양제_목록, 무기력);

        ExtractableResponse<Response> updateResponse =
                영양제_조합_수정_요청(사용자, createResponse, "무기력증에 추천하는 조합", "<h1>일상이 무기력할 때 추천하는 영양제 조합입니다.</h1>", 영양제_목록, 무기력);
    }
}
