package org.coteis.controller.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.domain.category.Language;
import org.coteis.domain.category.Previoustest;
import org.coteis.domain.user.User;
import org.coteis.dto.article.AddArticleRequest;
import org.coteis.dto.article.UpdateArticleRequest;
import org.coteis.dto.user.AddUserRequest;
import org.coteis.dto.user.UpdateUserRequest;
import org.coteis.repository.article.ArticleRepository;
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
class ArticleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("addArticle() : 글 등록")
    void addArticle() throws Exception {
        AddArticleRequest request = getAddArticleRequest();

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

    private static AddArticleRequest getAddArticleRequest() {
        AddArticleRequest request = new AddArticleRequest(
                "title",
                "testExplain",
                "answser",
                "inputExample",
                "outputExample",
                "speed",
                "codeExplain",
                "concept",
                new User("userName", "userId", "userPw", "userEmail"),
                new Algorithm("algorithmName"),
                new Difficulty("difficultyName"),
                new Language("langaugeName"),
                new Previoustest("previoustestName")
        );
        return request;
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
    @DisplayName("findArticle() : 특정 글 조회")
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
    @DisplayName("updateArticle() : 특정 글의 정보를 업데이트")
    void updateArticle() throws Exception {
        UpdateArticleRequest request = new UpdateArticleRequest("title",
                "testExplain",
                "answser",
                "inputExample",
                "outputExample",
                "speed",
                "codeExplain",
                "concept",
                new Algorithm("algorithmName"),
                new Difficulty("difficultyName"),
                new Language("langaugeName"),
                new Previoustest("previoustestName"));

        mockMvc.perform(
                        put("/api/articles/{id}", 1L)
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
                )
        ;
    }

    @Test
    @DisplayName("deleteArticle() : 특정 글 삭제하기")
    void deleteArticle() throws Exception {
        mockMvc.perform(
                        delete("/api/articles/{id}", 1L)
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