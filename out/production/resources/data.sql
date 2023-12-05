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

--1
INSERT INTO article (title,
 created_date,
 test_explain,
 answer,
 input_example,
 output_example,
 speed,
 code_explain,
 concept,
 user_no,
 algorithm_no,
 difficulty_no,
 language_no,
 previoustest_no)
VALUES (
'프로그래머스 [level 0] 피자 나눠 먹기 (3) - 자바(java)',
'2023-09-07 03:49:43',
'머쓱이네 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다. 피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때, n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
 (단, 2 ≤ slice ≤ 10, 1 ≤ n ≤ 100)',
'class Solution {
    public int solution(int slice, int n) {
        int answer = 0;

        if (slice >= 2 && slice <= 10 && n >= 1 && n <= 100) {
            if (n % slice > 0) {
                answer = n / slice + 1;
            }
            else {
                answer = n / slice;
            }
        }
        return answer;
    }
}',
'| slice : 7 | n : 10 |',
'return : 2',
'메모리: 73.1 MB, 시간: 0.01 ms',
'사람수 (n) % 피자조각 (slice)의 나머지가 0보다 크면 피자를 한 판 더 시켜야 모두 한 조각 이상 먹을 수 있습니다.
 따라서 사람수 (n) / 피자조각 (slice)의 몫에서 +1(피자 한 판)을 더한 값을 answer에 대입합니다.
 그 외에는 나머지가 0이기 때문에 모두 한 조각 이상 먹을 수 있습니다.
 따라서 사람수 (n) / 피자조각 (slice)의 몫을 answer에 대입해줍니다.',
'10명이 7조각으로 자른 피자를 한 조각 이상씩 먹으려면 최소 2판을 시켜야 합니다.',
1, 1, 1, 1, 1);

--2
INSERT INTO article (title,
 created_date,
 test_explain,
 answer,
 input_example,
 output_example,
 speed,
 code_explain,
 concept,
 user_no,
 algorithm_no,
 difficulty_no,
 language_no,
 previoustest_no)
VALUES (
'프로그래머스 [level 0] 피자 나눠 먹기 (1) - 자바(java)',
'2023-01-13 14:58:23',
'머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
(단, 1 ≤ n ≤ 100)',
'class Solution {
    public int solution(int n) {
        int answer = 0;

        if (n >= 1 && n <= 100) {
            if (n % 7 == 0) {
                answer = n / 7;
            }
            else {
                answer = n / 7 + 1;
            }
        }
        return answer;
    }
}',
'| n : 7 |',
'return : 1',
'메모리: 75.2 MB, 시간: 0.01 ms',
'머쓱이네 가게는 피자를 7조각으로 잘라주기 때문에 7로 나누어서 나머지가 있을 경우 피자를 한 판 더 추가하면 됩니다.
 조건문 if를 사용하여 만약 입력된 사람의 수 n값이 7로 나누어 나머지가 0이면 n / 7의 몫 만큼 피자를 주문하면 됩니다.
 만약 입력된 사람의 수가 n으로 나누어 떨어지지 않으면 n / 7의 몫 만큼 피자를 주문하고 +1판 더 주문하면 됩니다.',
'7명이 최소 한 조각씩 먹기 위해서 최소 1판이 필요합니다.',
2, 2, 1, 1, 3);

--3
INSERT INTO article (title,
 created_date,
 test_explain,
 answer,
 input_example,
 output_example,
 speed,
 code_explain,
 concept,
 user_no,
 algorithm_no,
 difficulty_no,
 language_no,
 previoustest_no)
VALUES (
'프로그래머스 [level 0] 머쓱이보다 키 큰 사람 - 자바(java)',
'2023-01-11 13:53:03',
'머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다. 머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.
(단, 1 ≤ array의 길이 ≤ 100, 1 ≤ height ≤ 200, 1 ≤ array의 원소 ≤ 200)',
'class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) {
                answer++;
            }
        }
        return answer;
    }
}',
'| array : [149, 180, 192, 170] | height : 167 |',
'return : 3',
'메모리: 74.4 MB, 시간: 0.02 ms',
'반복문 for문을 돌려 array 배열 길이만큼 반복하고, i값을 하나씩 증가시킵니다.
 만약 array의 i번째 값이 > height(머쓱이의 키)보다 크면
 answer을 하나씩 증가시켜 카운팅 해줍니다.',
'149, 180, 192, 170 중 머쓱이보다 키가 큰 사람은 180, 192, 170으로 세 명입니다.',
3, 1, 3, 1, 1);

--4
INSERT INTO article (title,
 created_date,
 test_explain,
 answer,
 input_example,
 output_example,
 speed,
 code_explain,
 concept,
 user_no,
 algorithm_no,
 difficulty_no,
 language_no,
 previoustest_no)
VALUES (
'프로그래머스 [level 0] 배열 뒤집기 - 자바(java)',
'2023-01-20 18:19:32',
'정수가 들어 있는 배열 num_list가 매개변수로 주어집니다. num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.
(단, 1 ≤ num_list의 길이 ≤ 1,000, 0 ≤ num_list의 원소 ≤ 1,000)',
'import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];

        for(int i = 0; i < num_list.length; i++) {
            answer[num_list.length - i - 1] = num_list[i];
        }

        return answer;
    }
}',
'| num_list : [1, 2, 3, 4, 5] |',
'return : [5, 4, 3, 2, 1]',
'메모리: 74.1 MB, 시간: 0.02 ms',
'answer 배열을 초기화 해주는데 이때 num_list의 길이만큼 크기를 가지도록 선언해줍니다.
 반복문 for문을 이용해 num_list 배열의 길이 만큼 반복하고, i를 하나씩 증가시킵니다.
 answer[num_list.length - i - 1] 즉, "answer 배열의 마지막 위치부터 num_list 배열의 첫번째 값을 담아주는 것"입니다.
 answer 배열 위치가 하나씩 줄어들고, 반면에 num_list 배열의 위치는 i가 하나씩 증가되면서 거꾸로 뒤집은 배열이 담기게 됩니다.',
'num_list가 [1, 2, 3, 4, 5]이므로 순서를 거꾸로 뒤집은 배열 [5, 4, 3, 2, 1]을 return합니다.',
4, 1, 2, 4, 1);

--5
INSERT INTO article (title,
 created_date,
 test_explain,
 answer,
 input_example,
 output_example,
 speed,
 code_explain,
 concept,
 user_no,
 algorithm_no,
 difficulty_no,
 language_no,
 previoustest_no)
VALUES (
'프로그래머스 [level 0] 과제 안 내신 분..? - 자바(java)',
'2023-02-20 10:38:10',
'사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.
 - x 좌표와 y 좌표가 모두 양수이면 제1사분면에 속합니다.
 - x 좌표가 음수, y 좌표가 양수이면 제2사분면에 속합니다.
 - x 좌표와 y 좌표가 모두 음수이면 제3사분면에 속합니다.
 - x 좌표가 양수, y 좌표가 음수이면 제4사분면에 속합니다.
 x 좌표 (x, y)를 차례대로 담은 정수 배열 dot이 매개변수로 주어집니다. 좌표 dot이 사분면 중 어디에 속하는지 1, 2, 3, 4 중 하나를 return 하도록 solution 함수를 완성해주세요.
 (단, dot의 길이 = 2, dot[0]은 x좌표를, dot[1]은 y좌표를 나타냅니다, -500 ≤ dot의 원소 ≤ 500, dot의 원소는 0이 아닙니다.)',
'class Solution {
    public int solution(int[] dot) {
        int answer = 0;

        for (int i = 0; i < 2; i++) {
            if (dot[i] >= -500 && dot[i] <= 500) {
                if (dot[0] > 0 && dot[1] > 0) {
                    answer = 1;
                }
                else if(dot[0] < 0 && dot[1] > 0) {
                    answer = 2;
                }

                else if (dot[0] < 0 && dot[1] < 0) {
                    answer = 3;
                }
                else {
                    answer = 4;
                }
            }
        }
        return answer;
    }
}',
'| dot : [2, 4] |',
'return : 1',
'메모리: 75.9 MB, 시간: 0.02 ms',
'조건문 if를 사용하여 dot 배열의 0번째 값이 0보다 크고(양수), 1번째 값이 0보다 크면(양수) -> 1사분면을 뜻하는 1을 반환합니다.
 dot 배열의 0번째 값이 0보다 작고(음수), 1번째 값이 0보다 크면(양수) -> 2사분면을 뜻하는 2를 반환합니다.
 dot 배열의 0번째 값이 0보다 작고(양수), 1번째 값이 0보다 작으면(양수) -> 3사분면을 뜻하는 3 반환합니다.
 그 외의 값은 4사분면이기 때문에 4를 반환합니다.',
'dot이 [2, 4]로 x 좌표와 y 좌표 모두 양수이므로 제 1 사분면에 속합니다. 따라서 1을 return 합니다.',
1, 1, 3, 1, 2);

INSERT INTO comment (content, created_date, user_no, article_no) VALUES ('멋진 포스트 감사합니다.', '2023-11-28 05:01:30', 1, 1);
INSERT INTO comment (content, created_date, user_no, article_no) VALUES ('참고해서 써도 괜찮을까요?', '2023-11-30 19:30:10', 2, 1);
INSERT INTO comment (content, created_date, user_no, article_no) VALUES ('잘 정리하셨네요!', '2023-05-18 07:03:12', 3, 1);
INSERT INTO comment (content, created_date, user_no, article_no) VALUES ('더 많은 글을 원해요', '2023-12-01 09:05:15', 1, 2);
INSERT INTO comment (content, created_date, user_no, article_no) VALUES ('우아~!', '2023-03-11 12:10:32', 1, 3);
