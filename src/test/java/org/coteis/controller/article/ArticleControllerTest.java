package org.coteis.controller.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class ArticleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addArticle() {
    }

    @Test
    @DisplayName("findAllArticles() : 글 목록 조회")
    void findAllArticles() throws Exception {
        mockMvc.perform(
                        get("/api/articles")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("articles-get",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("[].articleNo").description("글 번호 pk"),
                                        fieldWithPath("[].title").description("글 제목"),
                                        fieldWithPath("[].createdDate").description("생성 일자"),
                                        fieldWithPath("[].testExplain").description("문제 설명"),
                                        fieldWithPath("[].answer").description("코드 정답"),
                                        fieldWithPath("[].inputExample").description("입력 예시"),
                                        fieldWithPath("[].outputExample").description("출력 예시"),
                                        fieldWithPath("[].speed").description("최적화, 속도"),
                                        fieldWithPath("[].codeExplain").description("코드 설명"),
                                        fieldWithPath("[].concept").description("개념 정리"),
                                        fieldWithPath("[].userNo").description("유저 번호 pk"),
                                        fieldWithPath("[].userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("[].userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("[].userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("[].userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("[].userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("[].algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("[].algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("[].algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("[].difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("[].difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("[].difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("[].languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("[].languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("[].languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("[].previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("[].previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("[].previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored()
                                        .optional()
                                )
                        )
                )
        ;
    }

    @Test
    void findArticle() {
    }

    @Test
    void updateArticle() {
    }

    @Test
    void deleteArticle() {
    }
}