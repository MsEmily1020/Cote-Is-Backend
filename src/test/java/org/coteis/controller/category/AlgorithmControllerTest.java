package org.coteis.controller.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class AlgorithmControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("findALlAlgorithms() : 카테고리 - 알고리즘 목록 조회")
    void findAllAlgorithms() throws Exception {
        mockMvc.perform(
                        get("/api/algorithms")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("algorithms-get",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("[].algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("[].algorithmName").description("카테고리 알고리즘 이름")
                                )
                        )
                )
        ;
    }

    @Test
    @DisplayName("findAlgorithm() : 카테고리 - 특정 알고리즘 조회")
    void findAlgorithm() throws Exception {
        mockMvc.perform(
                        get("/api/algorithms/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo( // rest docs 문서 작성 시작
                        document("algorithm-get", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("카테고리 알고리즘 번호 pk")
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("algorithmName").description("카테고리 알고리즘 이름")
                                )
                        )
                )
        ;
    }
}