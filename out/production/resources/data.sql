insert into algorithm (algorithm_name) values ('수학');
insert into algorithm (algorithm_name) values ('구현');
insert into algorithm (algorithm_name) values ('자료 구조');
insert into algorithm (algorithm_name) values ('문자열');
insert into algorithm (algorithm_name) values ('그리드 알고리즘');
insert into algorithm (algorithm_name) values ('정렬');
insert into algorithm (algorithm_name) values ('이분 탐색');
insert into algorithm (algorithm_name) values ('사칙 연산');
insert into algorithm (algorithm_name) values ('누적 합');
insert into algorithm (algorithm_name) values ('재귀');

insert into difficulty (difficulty_name) values ('Easy');
insert into difficulty (difficulty_name) values ('Normal');
insert into difficulty (difficulty_name) values ('Hard');
insert into difficulty (difficulty_name) values ('Extreme');

insert into previoustest (previoustest_name) values ('카카오 신입 공채');
insert into previoustest (previoustest_name) values ('카카오 인턴십');
insert into previoustest (previoustest_name) values ('카카오 코드 페스티벌');
insert into previoustest (previoustest_name) values ('삼성 신입 공채');
insert into previoustest (previoustest_name) values ('서울대학교 SCSC 프로그래밍 경시대회');
insert into previoustest (previoustest_name) values ('네이버 코딩 테스트 기출');
insert into previoustest (previoustest_name) values ('COS pro 2급');
insert into previoustest (previoustest_name) values ('COS pro 1급');

insert into languages (language_name) values ('Java');
insert into languages (language_name) values ('JavaScript');
insert into languages (language_name) values ('Python');
insert into languages (language_name) values ('C');
insert into languages (language_name) values ('C++');
insert into languages (language_name) values ('C#');
insert into languages (language_name) values ('Go');
insert into languages (language_name) values ('Kotlin');

insert into users (user_name, user_id, user_pw, user_email) values ('황혜경', 'hyek', 'hkpw12!!', 'hhk@mail.com');
insert into users (user_name, user_id, user_pw, user_email) values ('김혜승', 'hyes', 'hspw12!!', 'khs@mail.com');
insert into users (user_name, user_id, user_pw, user_email) values ('김하은', 'haeun', 'hepw12!!', 'khe@mail.com');
insert into users (user_name, user_id, user_pw, user_email) values ('김수연', 'suy', 'supw12!!', 'ksy@mail.com');

--1
insert into article (title,
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
values (
'피자 나눠 먹기 (3)',
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
'slice : 7, n : 10',
'return : 2',
'메모리: 73.1 MB, 시간: 0.01 ms',
'사람수 (n) % 피자조각 (slice)의 나머지가 0보다 크면 피자를 한 판 더 시켜야 모두 한 조각 이상 먹을 수 있습니다.
 따라서 사람수 (n) / 피자조각 (slice)의 몫에서 +1(피자 한 판)을 더한 값을 answer에 대입합니다.
 그 외에는 나머지가 0이기 때문에 모두 한 조각 이상 먹을 수 있습니다.
 따라서 사람수 (n) / 피자조각 (slice)의 몫을 answer에 대입해줍니다.',
'10명이 7조각으로 자른 피자를 한 조각 이상씩 먹으려면 최소 2판을 시켜야 합니다.',
1, 1, 1, 1, 1);
-- user_no,
-- algorithm_no,
-- difficulty_no,
-- language_no,
-- previoustest_no

--2
insert into article (title,
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
values (
'피자 나눠 먹기 (1)',
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
'n : 7',
'return : 1',
'메모리: 75.2 MB, 시간: 0.01 ms',
'머쓱이네 가게는 피자를 7조각으로 잘라주기 때문에 7로 나누어서 나머지가 있을 경우 피자를 한 판 더 추가하면 됩니다.
 조건문 if를 사용하여 만약 입력된 사람의 수 n값이 7로 나누어 나머지가 0이면 n / 7의 몫 만큼 피자를 주문하면 됩니다.
 만약 입력된 사람의 수가 n으로 나누어 떨어지지 않으면 n / 7의 몫 만큼 피자를 주문하고 +1판 더 주문하면 됩니다.',
'7명이 최소 한 조각씩 먹기 위해서 최소 1판이 필요합니다.',
2, 1, 1, 1, 3);
-- user_no,
-- algorithm_no,
-- difficulty_no,
-- language_no,
-- previoustest_no

--3
insert into article (title,
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
values (
'머쓱이보다 키 큰 사람',
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
'array : [149, 180, 192, 170], height : 167',
'return : 3',
'메모리: 74.4 MB, 시간: 0.02 ms',
'반복문 for문을 돌려 array 배열 길이만큼 반복하고, i값을 하나씩 증가시킵니다.
 만약 array의 i번째 값이 > height(머쓱이의 키)보다 크면
 answer을 하나씩 증가시켜 카운팅 해줍니다.',
'149, 180, 192, 170 중 머쓱이보다 키가 큰 사람은 180, 192, 170으로 세 명입니다.',
3, 1, 3, 1, 1);
--user_no,
-- algorithm_no,
-- difficulty_no,
-- language_no,
-- previoustest_no

--4
insert into article (title,
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
values (
'기능개발',
'2023-01-20 18:19:32',
'프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 (단, 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다,
  작업 진도는 100 미만의 자연수입니다,
  작업 속도는 100 이하의 자연수입니다,
  배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.)',
'using System;
using System.Linq;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds)
    {
        int[] answer = new int[progresses.Length];

        // length를 밖에서 선언하면 실행시간을 단축시킬 수 있습니다.
        int length = progresses.Length;

        int[] remainProgressPerDay = new int[progresses.Length];

        for (int i = 0; i < length; i++)
        {
            // 남은 Progress / speed 한 값을 올림하면 며칠 뒤에 배포가 가능한지 알 수 있습니다.
            // 올림하기 위해 double로 형변환은 해 주어야 합니다.
            remainProgressPerDay[i] = (int)Math.Ceiling(((100 - progresses[i]) / (double)speeds[i]));
        }

        int answerCnt = 0;

        int releaseCount = 1;
        int tmpbiggestvalue = remainProgressPerDay[0];

        for (int i = 0; i < length; i++)
        {
            if (i == length - 1)
            {
                // 제일 마지막 인덱스에 도달하였다면 무조건 배포합니다.
                answer[answerCnt++] = releaseCount;
            }
            else if (tmpbiggestvalue >= remainProgressPerDay[i + 1])
            {
                // 다음 프로그레스도 이미 완료되었다면 다음 기능까지 함께 배포하도록 하기위한 코드입니다.
                releaseCount++;
            }
            else
            {
                // 다음 기능은 아직 배포준비 되지 않았다면 현재까지의 기능을 배포합니다.
                answer[answerCnt++] = releaseCount;
                tmpbiggestvalue = remainProgressPerDay[i + 1];
                releaseCount = 1;
            }
        }

        // 0을 제외하고 return합니다.
        return answer.Where(x => x != 0).ToArray();
    }
}',
'progresses : [93, 30, 55], speeds : [1, 30, 5]',
'return : [2, 1]',
'메모리: 31.4 MB, 시간: 1.40 ms',
'남은 Progress / speed 한 값을 올림하면 며칠 뒤에 배포가 가능한지 알 수 있고, 올림하기 위해 double로 한 번 형변환 해주어 for문을 돌립니다.
 제일 마지막 인덱스에 도달하였다면 무조건 배포합니다.
 다음 progress도 이미 완료되었다면 다음 기능까지 함께 배포하도록 ++을 해줍니다.
 다음 기능은 아직 배포준비 되지 않았다면 현재까지의 기능을 배포합니다.
 0을 제외하고 answer을 array로 리턴시킵니다.',
'첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.',
4, 1, 3, 6, 1);
-- user_no,
-- algorithm_no,
-- difficulty_no,
-- language_no,
-- previoustest_no

-- language : C임

--5
insert into article (title,
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
values (
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
'dot : [2, 4]',
'return : 1',
'메모리: 75.9 MB, 시간: 0.02 ms',
'조건문 if를 사용하여 dot 배열의 0번째 값이 0보다 크고(양수), 1번째 값이 0보다 크면(양수) -> 1사분면을 뜻하는 1을 반환합니다.
 dot 배열의 0번째 값이 0보다 작고(음수), 1번째 값이 0보다 크면(양수) -> 2사분면을 뜻하는 2를 반환합니다.
 dot 배열의 0번째 값이 0보다 작고(양수), 1번째 값이 0보다 작으면(양수) -> 3사분면을 뜻하는 3 반환합니다.
 그 외의 값은 4사분면이기 때문에 4를 반환합니다.',
'dot이 [2, 4]로 x 좌표와 y 좌표 모두 양수이므로 제 1 사분면에 속합니다. 따라서 1을 return 합니다.',
1, 1, 3, 1, 2);
-- user_no,
-- algorithm_no,
-- difficulty_no,
-- language_no,
-- previoustest_no

insert into comment (content, created_date, user_no, article_no) values ('멋진 포스트 감사합니다.', '2023-11-28 05:01:30', 1, 1);
insert into comment (content, created_date, user_no, article_no) values ('참고해서 써도 괜찮을까요?', '2023-11-30 19:30:10', 2, 1);
insert into comment (content, created_date, user_no, article_no) values ('잘 정리하셨네요!', '2023-05-18 07:03:12', 3, 1);
insert into comment (content, created_date, user_no, article_no) values ('더 많은 글을 원해요', '2023-12-01 09:05:15', 1, 2);
insert into comment (content, created_date, user_no, article_no) values ('우아~!', '2023-03-11 12:10:32', 1, 3);
