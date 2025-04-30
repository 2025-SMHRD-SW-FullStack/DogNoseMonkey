package Chapter;

import java.util.Scanner;

public class Q_A {
    static class Question {
        String questionText;
        String correctAnswer;

        Question(String questionText, String correctAnswer) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
        }

        boolean isCorrect(String userAnswer) {
            return userAnswer.trim().equals(correctAnswer);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] questions = new Question[] {
            new Question("Q1. for(int i=0; i<5; i++) { System.out.print(i); } 출력 결과는?", "01234"),
            new Question("Q2. while(조건) 문에서 무한 루프를 만들려면 조건에 들어갈 말은?", "true"),
            new Question("Q3. do-while 문은 최소 몇 번 이상 실행되는가? (한 글자)", "1"),
            new Question("Q4. 다음 코드 실행 시 i 값은? int i=0; while(i<3){ i++; }", "3"),
            new Question("Q5. for()문의 기본 구성은?", "초기화;조건;증감"),
            new Question("Q6. break는 어떤 역할을 하나요?", "종료"),
            new Question("Q7. continue는 어떤 역할을 하나요?", "건너뛰기"),
            new Question("Q8. 다음 중 반복문이 아닌 것은? (if/while/for/do-while 중)", "if"),
            new Question("Q9. for-each 문은 어떤 자료형에 자주 사용되나요?", "배열"),
            new Question("Q10. 중첩 반복문이란 무엇인가요? (간단히: 반복문 안에 OOO)", "반복문")
        };

        System.out.println("=== 반복문 퀴즈 게임 시작 ===");

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i].questionText);
            System.out.print("당신의 답: ");
            String answer = scanner.nextLine();

            if (questions[i].isCorrect(answer)) {
                System.out.println("정답입니다!\n");
                score += 10;
            } else {
                System.out.println("틀렸습니다. 정답은: " + questions[i].correctAnswer + "\n");
            }
        }

        System.out.println("🎉 퀴즈 종료! 당신의 총 점수는: " + score + "점 입니다.");
        scanner.close();
    }
}
