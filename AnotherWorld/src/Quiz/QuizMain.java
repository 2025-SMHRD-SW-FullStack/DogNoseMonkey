package Quiz;

import java.util.List;
import java.util.Scanner;

public class QuizMain {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizDAO quizDAO = new QuizDAO();
        int score = 0;
        int correctCount = 0;

        // 첫 번째 퀴즈 세트
        System.out.println("=== 반복문 퀴즈 게임 시작 ===");
        List<QuizDTO> questions1 = quizDAO.getQuestions(1); // 첫 번째 문제 세트 가져오기
        correctCount = playQuiz(scanner, quizDAO, questions1, score);
        if (correctCount < questions1.size()) {
            scanner.close();
            return; // 틀리면 종료
        }
        score = correctCount * 10;

        // 두 번째 퀴즈 세트 (첫 번째 세트를 모두 맞춘 경우에만 진행)
        System.out.println("=== 객체지향 퀴즈 게임 시작 ===");
        List<QuizDTO> questions2 = quizDAO.getQuestions(2); // 두 번째 문제 세트 가져오기
        correctCount = playQuiz(scanner, quizDAO, questions2, score);
        score = correctCount * 10;

        scanner.close();
    }

    // 퀴즈를 진행하고 맞춘 문제 수를 반환하는 메서드
    public static int playQuiz(Scanner scanner, QuizDAO quizDAO, List<QuizDTO> questions, int currentScore) {
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
                System.out.println("퀴즈 종료! 당신이 맞춘 문제 수는: " + correctCount + "개 입니다.");
                System.out.println("🎉 퀴즈 종료! 당신의 총 점수는: " + (currentScore + correctCount * 10) + "점 입니다.");
                return correctCount; // 틀리면 현재까지 맞춘 문제 수 반환
            }
        }
        System.out.println("🎉 퀴즈 종료! 당신이 맞춘 문제 수는: " + correctCount + "개 입니다.");
        System.out.println("🎉 퀴즈 종료! 당신의 총 점수는: " + (currentScore + correctCount * 10) + "점 입니다.");
        return correctCount; // 모든 문제를 맞췄을 경우, 맞춘 문제 수 반환
    }

}
