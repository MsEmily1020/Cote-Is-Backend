INSERT INTO algorithm (algorithm_name) VALUES ('수학');
INSERT INTO algorithm (algorithm_name) VALUES ('구현');
INSERT INTO algorithm (algorithm_name) VALUES ('자료 구조');
INSERT INTO algorithm (algorithm_name) VALUES ('문자열');
INSERT INTO algorithm (algorithm_name) VALUES ('그리드 알고리즘');
INSERT INTO algorithm (algorithm_name) VALUES ('정렬');
INSERT INTO algorithm (algorithm_name) VALUES ('이분 탐색');
INSERT INTO algorithm (algorithm_name) VALUES ('사칙 연산');
INSERT INTO algorithm (algorithm_name) VALUES ('누적 합');
INSERT INTO algorithm (algorithm_name) VALUES ('재귀');

INSERT INTO difficulty (difficulty_name) VALUES ('Easy');
INSERT INTO difficulty (difficulty_name) VALUES ('Normal');
INSERT INTO difficulty (difficulty_name) VALUES ('Hard');
INSERT INTO difficulty (difficulty_name) VALUES ('Extreme');

INSERT INTO previoustest (previoustest_name) VALUES ('카카오 신입 공채');
INSERT INTO previoustest (previoustest_name) VALUES ('카카오 인턴십');
INSERT INTO previoustest (previoustest_name) VALUES ('카카오 코드 페스티벌');
INSERT INTO previoustest (previoustest_name) VALUES ('삼성 신입 공채');
INSERT INTO previoustest (previoustest_name) VALUES ('서울대학교 SCSC 프로그래밍 경시대회');
INSERT INTO previoustest (previoustest_name) VALUES ('네이버 코딩 테스트 기출');
INSERT INTO previoustest (previoustest_name) VALUES ('COS pro 2급');
INSERT INTO previoustest (previoustest_name) VALUES ('COS pro 1급');

INSERT INTO languages (language_name) VALUES ('Java');
INSERT INTO languages (language_name) VALUES ('JavaScript');
INSERT INTO languages (language_name) VALUES ('Python');
INSERT INTO languages (language_name) VALUES ('C');
INSERT INTO languages (language_name) VALUES ('C++');
INSERT INTO languages (language_name) VALUES ('C#');
INSERT INTO languages (language_name) VALUES ('Go');
INSERT INTO languages (language_name) VALUES ('Kotlin');

INSERT INTO users (user_name, user_id, user_pw, user_email) VALUES ('황혜경', 'hyek', 'hkpw12!!', 'hhk@mail.com');
INSERT INTO users (user_name, user_id, user_pw, user_email) VALUES ('김혜승', 'hyes', 'hspw12!!', 'khs@mail.com');
INSERT INTO users (user_name, user_id, user_pw, user_email) VALUES ('김하은', 'haeun', 'hepw12!!', 'khe@mail.com');
INSERT INTO users (user_name, user_id, user_pw, user_email) VALUES ('김수연', 'suy', 'supw12!!', 'ksy@mail.com');

INSERT INTO article (title, created_date, test_explain, answer, input_example, output_example, speed, code_explain, concept, user_no, algorithm_no, difficulty_no, language_no, previoustest_no) VALUES ('제목1', '2006-10-20 03:49:43', '테스트 설명1', '정답1', 'input1', 'output1', '20ms', '코드 설명1', '컨셉1', 1, 1, 1, 1, 1);
INSERT INTO article (title, created_date, test_explain, answer, input_example, output_example, speed, code_explain, concept, user_no, algorithm_no, difficulty_no, language_no, previoustest_no) VALUES ('제목2', '2013-02-02 08:30:03', '테스트 설명2', '정답2', 'input2', 'output2', '22ms', '코드 설명2', '컨셉2', 2, 2, 1, 1, 3);
INSERT INTO article (title, created_date, test_explain, answer, input_example, output_example, speed, code_explain, concept, user_no, algorithm_no, difficulty_no, language_no, previoustest_no) VALUES ('제목3', '2014-04-01 10:59:21', '테스트 설명3', '정답3', 'input3', 'output3', '24ms', '코드 설명3', '컨셉3', 3, 1, 3, 1, 1);
INSERT INTO article (title, created_date, test_explain, answer, input_example, output_example, speed, code_explain, concept, user_no, algorithm_no, difficulty_no, language_no, previoustest_no) VALUES ('제목4', '2016-06-16 06:19:43', '테스트 설명4', '정답4', 'input4', 'output4', '26ms', '코드 설명4', '컨셉4', 4, 1, 2, 4, 1);
INSERT INTO article (title, created_date, test_explain, answer, input_example, output_example, speed, code_explain, concept, user_no, algorithm_no, difficulty_no, language_no, previoustest_no) VALUES ('제목5', '2023-09-28 15:01:15', '테스트 설명5', '정답5', 'input5', 'output5', '28ms', '코드 설명5', '컨셉5', 1, 1, 3, 1, 2);