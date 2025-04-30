package OOP_Quiz;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OOPQuiz quiz = new OOPQuiz();
		OOPQuiz.Question[] questions = quiz.getQuestions();

		System.out.println("=== 자바 객체지향 프로그래밍 객관식 문제 ===\n");

		int score = 0;

		for (int i = 0; i < questions.length; i++) {
			System.out.println(questions[i].questionText);
			System.out.print("당신의 답: ");
			String answer = sc.nextLine();

			if (questions[i].isCorrect(answer)) {
				System.out.println("정답입니다!\n");
				score += 10;
			} else {
				System.out.println("틀렸습니다. 정답은: " + questions[i].correctAnswer + "\n");
			}
		}

		System.out.println("🎉 퀴즈 종료! 당신의 총 점수는: " + score + "점 입니다.");
		sc.close();
	}

}