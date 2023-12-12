package org.coteis.controller.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.coteis.controller.user.UserController;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.domain.category.Language;
import org.coteis.domain.category.Previoustest;
import org.coteis.domain.user.User;
import org.coteis.dto.article.AddArticleRequest;
import org.coteis.dto.article.UpdateArticleRequest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArticleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserController userController;

    @Test
    @Order(1)
    @DisplayName("1. addArticle() : article post")
    void addArticle() throws Exception {
        AddArticleRequest request = new AddArticleRequest(
                "title",
                "testExplain",
                "answer",
                "inputExample",
                "outputExample",
                "speed",
                "codeExplain",
                "concept",
                User.builder().userName("userName").userId("userId").userPw("userPw").userEmail("userEmail").build(),
                Algorithm.builder().algorithmName("al").build(),
                Difficulty.builder().difficultyName("di").build(),
                Language.builder().languageName("la").build(),
                Previoustest.builder().previoustestName("pre").build()
        );

        mockMvc.perform(
                        post("/api/articles")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo( // rest docs 문서 작성 시작
                        document("article-post", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("title").description("글 제목"),
                                        fieldWithPath("testExplain").description("문제 설명"),
                                        fieldWithPath("answer").description("코드 정답"),
                                        fieldWithPath("inputExample").description("입력 예시"),
                                        fieldWithPath("outputExample").description("출력 예시"),
                                        fieldWithPath("speed").description("최적화, 속도"),
                                        fieldWithPath("codeExplain").description("코드 설명"),
                                        fieldWithPath("concept").description("개념 정리"),
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored()
                                ),

                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("articleNo").description("글 번호 pk"),
                                        fieldWithPath("title").description("글 제목"),
                                        fieldWithPath("createdDate").description("생성 일자"),
                                        fieldWithPath("modifiedDate").description("수정 일자"),
                                        fieldWithPath("testExplain").description("문제 설명"),
                                        fieldWithPath("answer").description("코드 정답"),
                                        fieldWithPath("inputExample").description("입력 예시"),
                                        fieldWithPath("outputExample").description("출력 예시"),
                                        fieldWithPath("speed").description("최적화, 속도"),
                                        fieldWithPath("codeExplain").description("코드 설명"),
                                        fieldWithPath("concept").description("개념 정리"),
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored())
                        )
                )
        ;
    }

    @Test
    @Order(2)
    @DisplayName("2. findAllArticles() : articles get")
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
                                        fieldWithPath("[].modifiedDate").description("수정 일자"),
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
    @Order(3)
    @DisplayName("3. findArticle() : article get")
    void findArticle() throws Exception {
        mockMvc.perform(
                        get("/api/articles/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo( // rest docs 문서 작성 시작
                        document("article-get", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("글 번호 pk")
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("articleNo").description("글 번호 pk"),
                                        fieldWithPath("title").description("글 제목"),
                                        fieldWithPath("createdDate").description("생성 일자"),
                                        fieldWithPath("modifiedDate").description("수정 일자"),
                                        fieldWithPath("testExplain").description("문제 설명"),
                                        fieldWithPath("answer").description("코드 정답"),
                                        fieldWithPath("inputExample").description("입력 예시"),
                                        fieldWithPath("outputExample").description("출력 예시"),
                                        fieldWithPath("speed").description("최적화, 속도"),
                                        fieldWithPath("codeExplain").description("코드 설명"),
                                        fieldWithPath("concept").description("개념 정리"),
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored())
                        )
                )
        ;
    }

    @Test
    @Order(4)
    @DisplayName("4. updateArticle() : article put")
    void updateArticle() throws Exception {
        UpdateArticleRequest request = new UpdateArticleRequest(
                "title",
                "testExplain",
                "answer",
                "inputExample",
                "outputExample",
                "speed",
                "codeExplain",
                "concept",
                Algorithm.builder().algorithmName("al").build(),
                Difficulty.builder().difficultyName("di").build(),
                Language.builder().languageName("la").build(),
                Previoustest.builder().previoustestName("pre").build()
        );

        mockMvc.perform(
                        put("/api/articles/{id}", 6L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andDo( // rest docs 문서 작성 시작
                        document("article-put", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("글 번호 pk")
                                ),

                                requestFields(
                                        fieldWithPath("title").description("글 제목"),
                                        fieldWithPath("testExplain").description("문제 설명"),
                                        fieldWithPath("answer").description("코드 정답"),
                                        fieldWithPath("inputExample").description("입력 예시"),
                                        fieldWithPath("outputExample").description("출력 예시"),
                                        fieldWithPath("speed").description("최적화, 속도"),
                                        fieldWithPath("codeExplain").description("코드 설명"),
                                        fieldWithPath("concept").description("개념 정리"),
                                        fieldWithPath("algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored()
                                ),

                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("articleNo").description("글 번호 pk"),
                                        fieldWithPath("title").description("글 제목"),
                                        fieldWithPath("createdDate").description("생성 일자"),
                                        fieldWithPath("modifiedDate").description("수정 일자"),
                                        fieldWithPath("testExplain").description("문제 설명"),
                                        fieldWithPath("answer").description("코드 정답"),
                                        fieldWithPath("inputExample").description("입력 예시"),
                                        fieldWithPath("outputExample").description("출력 예시"),
                                        fieldWithPath("speed").description("최적화, 속도"),
                                        fieldWithPath("codeExplain").description("코드 설명"),
                                        fieldWithPath("concept").description("개념 정리"),
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored()
                                )
                        )
                );
    }

    @Test
    @Order(5)
    @DisplayName("5. deleteArticle() : article delete")
    void deleteArticle() throws Exception {
        mockMvc.perform(
                        delete("/api/articles/{id}", 6L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("article-delete",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("글 번호 pk")
                                )

                        )
                )
        ;
    }
}