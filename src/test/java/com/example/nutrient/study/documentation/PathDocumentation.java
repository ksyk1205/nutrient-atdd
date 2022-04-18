package com.example.nutrient.study.documentation;

import com.example.nutrient.documentation.Documentation;
import com.example.nutrient.study.PathController;
import com.example.nutrient.study.PathResponse;
import com.example.nutrient.study.PathService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PathController.class)
class PathDocumentation extends Documentation {

    @MockBean
    PathService pathService;

    @Test
    void path() throws Exception {
        PathResponse pathResponse = new PathResponse(10, 10, 10);
        given(pathService.findPath(anyLong(), anyLong())).willReturn(pathResponse);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("source", "1");
        params.add("target", "1");

        this.mockMvc.perform(get("/api/paths").params(params))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("path",
                        requestParameters(
                                parameterWithName("source").description("출발역 ID"),
                                parameterWithName("target").description("도착역 ID")
                        ),
                        responseFields(
                                fieldWithPath("distance").description("전체 거리"),
                                fieldWithPath("duration").description("소요 시간"),
                                fieldWithPath("fare").description("총 요금")
                        ))
                );

    }
}
