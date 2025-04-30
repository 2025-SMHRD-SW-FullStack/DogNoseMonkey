package Quiz;

import java.util.List;
import java.util.Scanner;

public class QuizMain {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizDAO quizDAO = new QuizDAO();
        int score = 0;
        int totalCorrectCount = 0;
        int setCorrectCount = 0;

        // 첫 번째 퀴즈 세트
        System.out.println("=== 반복문 퀴즈 게임 시작 1 ===");
        List<QuizDTO> questions1 = quizDAO.getQuestions(1);
        setCorrectCount = playQuiz(scanner, quizDAO, questions1);
        totalCorrectCount += setCorrectCount;
        if (setCorrectCount < questions1.size()) {
            showFinalResult(totalCorrectCount);
            scanner.close();
            return; // 틀리면 종료
        }

        // 두 번째 퀴즈 세트
        System.out.println("=== 객체지향 퀴즈 게임 시작 2 ===");
        List<QuizDTO> questions2 = quizDAO.getQuestions(2);
        setCorrectCount = playQuiz(scanner, quizDAO, questions2);
        totalCorrectCount += setCorrectCount;
        if (setCorrectCount < questions2.size()) {
            showFinalResult(totalCorrectCount);
            scanner.close();
            return;
        }

        // 세 번째 퀴즈 세트
        System.out.println("=== 객체지향 퀴즈 게임 시작 3 ===");
        List<QuizDTO> questions3 = quizDAO.getQuestions(3);
        setCorrectCount = playQuiz(scanner, quizDAO, questions3);
        totalCorrectCount += setCorrectCount;

        scanner.close();
        showFinalResult(totalCorrectCount); // 전체 결과 출력
    }

    // 퀴즈 진행 메서드
    public static int playQuiz(Scanner scanner, QuizDAO quizDAO, List<QuizDTO> questions) {
        int correctCount = 0;
        for (int i = 0; i < questions.size(); i++) {
            QuizDTO currentQuestion = questions.get(i);
            System.out.println(currentQuestion.getQuestionText());
            System.out.print("당신의 답: ");
            String answer = scanner.nextLine();

            if (currentQuestion.isCorrect(answer)) {
                System.out.println("정답입니다!\n");
                correctCount++;
            } else {
                System.out.println("틀렸습니다. 정답은: " + currentQuestion.getCorrectAnswer() + "\n");
                return correctCount;
            }
        }
        return correctCount;
    }

    // 최종 결과 출력
    public static void showFinalResult(int totalCorrectCount) {
        int score = totalCorrectCount * 10;
        System.out.println("🎉 퀴즈 종료! 당신이 맞춘 문제 수는: " + totalCorrectCount + "개 입니다.");
        System.out.println("🎉 퀴즈 종료! 당신의 총 점수는: " + score + "점 입니다.");
    }
}
