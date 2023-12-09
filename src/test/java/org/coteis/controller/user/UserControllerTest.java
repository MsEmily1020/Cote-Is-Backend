package org.coteis.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.coteis.dto.user.AddUserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("addUser() : 유저 사용자 등록")
    void addUser() throws Exception {
        AddUserRequest request = new AddUserRequest();
        request.setUserName("김혜승");
        request.setUserId("hyeseung");
        request.setUserPw("hyeseung!!");
        request.setUserEmail("peace10200khs@gmail.com");

        mockMvc.perform(
                        post("/api/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo( // rest docs 문서 작성 시작
                        document("user-post", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("userName").description("유저 이름"),
                                        fieldWithPath("userId").description("유저 아이디"),
                                        fieldWithPath("userPw").description("유저 패스워드"),
                                        fieldWithPath("userEmail").description("유저 이메일")
                                ),

                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userName").description("유저 이름"),
                                        fieldWithPath("userId").description("유저 아이디"),
                                        fieldWithPath("userPw").description("유저 패스워드"),
                                        fieldWithPath("userEmail").description("유저 이메일")
                                )
                        )
                )
        ;
    }

    @Test
    @DisplayName("findAllUsers() : 유저 목록 조회")
    void findAllUsers() throws Exception {
        mockMvc.perform(
                        get("/api/users")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("users-get",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("[].userNo").description("유저 번호 pk"),
                                        fieldWithPath("[].userName").description("유저 이름"),
                                        fieldWithPath("[].userId").description("유저 아이디"),
                                        fieldWithPath("[].userPw").description("유저 패스워드"),
                                        fieldWithPath("[].userEmail").description("유저 이메일").optional()
                                )
                        )
                )
        ;
    }

    @Test
    @DisplayName("findUser() : 특정 사용자 조회")
    void findUser() throws Exception {
        mockMvc.perform(
                        get("/api/users/{id}", 2L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo( // rest docs 문서 작성 시작
                        document("user-get", // 문서 조각 디렉토리 명
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("유저 번호 pk")
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("userNo").description("유저 번호 pk"),
                                        fieldWithPath("userName").description("유저 이름"),
                                        fieldWithPath("userId").description("유저 아이디"),
                                        fieldWithPath("userPw").description("유저 패스워드"),
                                        fieldWithPath("userEmail").description("유저 이메일")
                                )
                        )
                )
        ;
    }

    @Test
    @DisplayName("deleteUser() : 특정 사용자 삭제")
    void deleteUser() throws Exception {
        mockMvc.perform(
                        delete("/api/users/{id}", 2L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("user-delete",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("유저 번호 pk")
                                )

                        )
                )
        ;
    }
}