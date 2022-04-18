package com.example.nutrient.study.acceptance;

import com.example.nutrient.acceptance.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.nutrient.study.acceptance.PathSteps.*;

class PathAcceptanceTest extends AcceptanceTest {

    @DisplayName("두 역의 최단 거리 경로를 조회한다")
    @Test
    void findPathByDistance() {
        지하철역이_등록되어있음();
        지하철_노선이_등록되어있음();
        지하철_노선에_지하철역이_등록되어있음();
        로그인_되어있음();
        출발역에서_도착역까지의_최단_거리_경로_조회를_요청();
        최단_거리_경로를_응답();
        총_거리와_소요_시간을_함께_응답함();
        지하철_이용_요금도_함께_응답함();
    }
}
