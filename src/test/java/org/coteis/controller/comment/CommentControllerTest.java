package org.coteis.controller.comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.coteis.domain.article.Article;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.domain.category.Language;
import org.coteis.domain.category.Previoustest;
import org.coteis.domain.user.User;
import org.coteis.dto.comment.AddCommentRequest;
import org.coteis.dto.user.AddUserRequest;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("addComment() : 댓글 생성")
    void addComment() throws Exception {
        AddCommentRequest request = new AddCommentRequest(
                "comment",
                new User("userName", "userId1", "userPw", "uE"),
                new Article("title", "testExplain", "answer", "inputExample", "outputExample", "speed", "codeExplain", "concept", new User("userName", "userId", "userPw", "userEmail"), new Algorithm("algorithmName"), new Difficulty("difficultyName"), new Language("langaugeName"), new Previoustest("previoustestName"))
        );

        mockMvc.perform(
                        post("/api/comments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo( // rest docs 문서 작성 시작
                        document("comment-post", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("content").description("댓글 내용"),
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("articleNo.articleNo").description("글 번호 pk"),
                                        fieldWithPath("articleNo.title").description("글 제목"),
                                        fieldWithPath("articleNo.createdDate").description("생성 일자"),
                                        fieldWithPath("articleNo.modifiedDate").description("수정 일자"),
                                        fieldWithPath("articleNo.testExplain").description("문제 설명"),
                                        fieldWithPath("articleNo.answer").description("코드 정답"),
                                        fieldWithPath("articleNo.inputExample").description("입력 예시"),
                                        fieldWithPath("articleNo.outputExample").description("출력 예시"),
                                        fieldWithPath("articleNo.speed").description("최적화, 속도"),
                                        fieldWithPath("articleNo.codeExplain").description("코드 설명"),
                                        fieldWithPath("articleNo.concept").description("개념 정리"),
                                        fieldWithPath("articleNo.userNo").description("유저 번호 pk"),
                                        fieldWithPath("articleNo.userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("articleNo.userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("articleNo.userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("articleNo.userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("articleNo.userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("articleNo.algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("articleNo.algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("articleNo.algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("articleNo.difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("articleNo.difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("articleNo.difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("articleNo.languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("articleNo.languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("articleNo.languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("articleNo.previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("articleNo.previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("articleNo.previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored()
                                ),

                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("commentId").description("댓글 번호 pk"),
                                        fieldWithPath("content").description("댓글 내용"),
                                        fieldWithPath("createdDate").description("생성 일자"),
                                        fieldWithPath("modifiedDate").description("수정 일자"),
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("articleNo.articleNo").description("글 번호 pk"),
                                        fieldWithPath("articleNo.title").description("글 제목"),
                                        fieldWithPath("articleNo.createdDate").description("생성 일자"),
                                        fieldWithPath("articleNo.modifiedDate").description("수정 일자"),
                                        fieldWithPath("articleNo.testExplain").description("문제 설명"),
                                        fieldWithPath("articleNo.answer").description("코드 정답"),
                                        fieldWithPath("articleNo.inputExample").description("입력 예시"),
                                        fieldWithPath("articleNo.outputExample").description("출력 예시"),
                                        fieldWithPath("articleNo.speed").description("최적화, 속도"),
                                        fieldWithPath("articleNo.codeExplain").description("코드 설명"),
                                        fieldWithPath("articleNo.concept").description("개념 정리"),
                                        fieldWithPath("articleNo.userNo").description("유저 번호 pk"),
                                        fieldWithPath("articleNo.userNo.userNo").description("유저 번호 pk").ignored(),
                                        fieldWithPath("articleNo.userNo.userName").description("유저 이름").ignored(),
                                        fieldWithPath("articleNo.userNo.userId").description("유저 아이디").ignored(),
                                        fieldWithPath("articleNo.userNo.userPw").description("유저 패스워드").ignored(),
                                        fieldWithPath("articleNo.userNo.userEmail").description("유저 이메일").ignored(),
                                        fieldWithPath("articleNo.algorithmNo").description("카테고리 알고리즘 번호 pk"),
                                        fieldWithPath("articleNo.algorithmNo.algorithmNo").description("카테고리 알고리즘 번호 pk").ignored(),
                                        fieldWithPath("articleNo.algorithmNo.algorithmName").description("카테고리 알고리즘 이름").ignored(),
                                        fieldWithPath("articleNo.difficultyNo").description("카테고리 난이도 번호 pk"),
                                        fieldWithPath("articleNo.difficultyNo.difficultyNo").description("카테고리 난이도 번호 pk").ignored(),
                                        fieldWithPath("articleNo.difficultyNo.difficultyName").description("카테고리 난이도 이름").ignored(),
                                        fieldWithPath("articleNo.languageNo").description("카테고리 언어 번호 pk"),
                                        fieldWithPath("articleNo.languageNo.languageNo").description("카테고리 언어 번호 pk").ignored(),
                                        fieldWithPath("articleNo.languageNo.languageName").description("카테고리 언어 이름").ignored(),
                                        fieldWithPath("articleNo.previoustestNo").description("카테고리 기출 문제 번호 pk"),
                                        fieldWithPath("articleNo.previoustestNo.previoustestNo").description("카테고리 기출 문제 번호 pk").ignored(),
                                        fieldWithPath("articleNo.previoustestNo.previoustestName").description("카테고리 기출 문제 이름").ignored()
                                )
                        )
                )
        ;
    }

    @Test
    void findAllComments() {
    }

    @Test
    void findAllByArticleNo() {
    }

    @Test
    void updateComment() {
    }

    @Test
    void deleteComment() {
    }
}