package Quiz;

import java.util.List;
import java.util.Scanner;

public class QuizMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizDAO quizDAO = new QuizDAO();
        int totalCorrectCount = 0;
        int setCorrectCount;

        // 사용자 이름 입력 받기
        System.out.print("플레이어 이름을 입력하세요: ");
        String playerName = scanner.nextLine();

        // 첫 번째 퀴즈 세트
        System.out.println("=== 반복문 퀴즈 게임 시작 1 ===");
        List<QuizDTO> questions1 = quizDAO.getQuestions(1);
        setCorrectCount = playQuiz(scanner, questions1);
        totalCorrectCount += setCorrectCount;
        if (setCorrectCount < questions1.size()) {
            endGame(playerName, totalCorrectCount);
            scanner.close();
            return;
        }

        // 두 번째 세트
        System.out.println("=== 객체지향 퀴즈 게임 시작 2 ===");
        List<QuizDTO> questions2 = quizDAO.getQuestions(2);
        setCorrectCount = playQuiz(scanner, questions2);
        totalCorrectCount += setCorrectCount;
        if (setCorrectCount < questions2.size()) {
            endGame(playerName, totalCorrectCount);
            scanner.close();
            return;
        }

        // 세 번째 세트
        System.out.println("=== 객체지향 퀴즈 게임 시작 3 ===");
        List<QuizDTO> questions3 = quizDAO.getQuestions(3);
        setCorrectCount = playQuiz(scanner, questions3);
        totalCorrectCount += setCorrectCount;

        scanner.close();
        endGame(playerName, totalCorrectCount);
    }

    public static int playQuiz(Scanner scanner, List<QuizDTO> questions) {
        int correctCount = 0;
        for (QuizDTO q : questions) {
            System.out.println(q.getQuestionText());
            System.out.print("당신의 답: ");
            String answer = scanner.nextLine();

            if (q.isCorrect(answer)) {
                System.out.println("정답입니다!\n");
                correctCount++;
            } else {
                System.out.println("틀렸습니다. 정답은: " + q.getCorrectAnswer() + "\n");
                return correctCount;
            }
        }
        return correctCount;
    }

    public static void endGame(String name, int correctCount) {
        int score = correctCount * 10;
        System.out.println("🎉 퀴즈 종료! 당신이 맞춘 문제 수는: " + correctCount + "개 입니다.");
        System.out.println("🎉 퀴즈 종료! 당신의 총 점수는: " + score + "점 입니다.");
        QuizScore.saveScore(name, score); // 점수 저장
    }
}
