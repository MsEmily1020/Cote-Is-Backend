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
class DifficultyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("findAllDifficulties() : 카테고리 - 난이도 목록 조회")
    void findAllDifficulties() throws Exception {
        mockMvc.perform(
                        get("/api/difficulties")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("difficulties-get",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("[].difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("[].difficultyName").description("카테고리 난이도 이름")
                                )
                        )
                )
        ;
    }

    @Test
    @DisplayName("findDifficulty() : 카테고리 - 특정 난이도 조회")
    void findDifficulty() throws Exception {
        mockMvc.perform(
                        get("/api/difficulties/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo( // rest docs 문서 작성 시작
                        document("difficulty-get", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("카테고리 난이도 번호 pk")
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("difficultyName").description("카테고리 난이도 이름")
                                )
                        )
                )
        ;
    }
}