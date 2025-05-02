package Quiz;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import player.PlayerDTO;

public class QuizMain {

	private final PlayerDTO player;

	public QuizMain(PlayerDTO player) {
		super();
		this.player = player;
	}

	public void StartGame() {
		Scanner scanner = new Scanner(System.in);
		QuizDAO quizDAO = new QuizDAO();
		int totalCorrectCount = 0;
		int setCorrectCount;

		// 사용자 이름 입력 받기
		if (player != null) {
			if (player.getPassword() == null || player.getPassword().isEmpty()) {
				System.out.println("비밀번호가 설정되지 않았습니다. 게임을 종료합니다.");
				return; // 비밀번호가 없으면 게임을 종료
			}
			System.out.println("현재 로그인 사용자: " + player.getPlayerName());
		}

		// 첫 번째 퀴즈 세트
		System.out.println("=== 반복문 퀴즈 게임 시작 1 ===");
		List<QuizDTO> questions1 = quizDAO.getQuestions(1);
		setCorrectCount = playQuiz(scanner, questions1);
		totalCorrectCount += setCorrectCount;
		if (setCorrectCount < questions1.size()) {
			endGame(player, totalCorrectCount);
			return;
		}

		// 두 번째 세트
		System.out.println("=== 객체지향 퀴즈 게임 시작 2 ===");
		List<QuizDTO> questions2 = quizDAO.getQuestions(2);
		setCorrectCount = playQuiz(scanner, questions2);
		totalCorrectCount += setCorrectCount;
		if (setCorrectCount < questions2.size()) {
			endGame(player, totalCorrectCount);
			return;
		}

		// 세 번째 세트
		System.out.println("=== 객체지향 퀴즈 게임 시작 3 ===");
		List<QuizDTO> questions3 = quizDAO.getQuestions(3);
		setCorrectCount = playQuiz(scanner, questions3);
		totalCorrectCount += setCorrectCount;

		endGame(player, totalCorrectCount);
	}

	public static int playQuiz(Scanner scanner, List<QuizDTO> questions) {
		int correctCount = 0;
		final int TIME_LIMIT = 10;

		for (QuizDTO q : questions) {
			System.out.println(q.getQuestionText());

			ExecutorService executor = Executors.newSingleThreadExecutor();
			Future<String> future = executor.submit(() -> scanner.nextLine());

			Thread timerThread = new Thread(() -> {
				for (int i = TIME_LIMIT; i >= 1; i--) {
					System.out.print("\r당신의 답 (제한시간: " + i + "초): ");
					System.out.flush();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ignored) {
						return;
					}
				}
			});

			timerThread.start();

			String answer = null;
			try {
				answer = future.get(TIME_LIMIT, TimeUnit.SECONDS); // 입력 대기
				timerThread.interrupt(); // 입력 완료 시 타이머 종료
			} catch (TimeoutException e) {
				System.out.println("\n시간 초과 문제를 풀지 못했습니다.");
				System.out.println("여러분은 스핑크스 같이 생긴 돌덩어리에게 깔려 죽었습니다\n");
				future.cancel(true);
				executor.shutdownNow();
				return correctCount;
			} catch (Exception e) {
				System.out.println("\n오류 발생: " + e.getMessage());
				executor.shutdownNow();
				return correctCount;
			}

			executor.shutdown();

			if (q.isCorrect(answer)) {
				System.out.println("운이 좋군... 하지만 다음 문제도 풀 수 있을까?!");
				System.out.println();
				correctCount++;
			} else {
				System.out.println("틀렸습니다. 정답은: " + q.getCorrectAnswer() + "\n");
				System.out.println("여러분은 달리는 돌덩어리가 자신은 속도를 주채못하고 벽쿵을 당해 가루가 되었습니다");
				timerThread.interrupt();
				return correctCount;
			}
		}
		return correctCount;
	}

	public static void endGame(PlayerDTO player, int correctCount) {
		int score = correctCount * 10;
		System.out.println("🎉 퀴즈 종료! 당신이 맞춘 문제 수는: " + correctCount + "개 입니다.");
		System.out.println("🎉 퀴즈 종료! 당신의 총 점수는: " + score + "점 입니다.");
		if (player.getPassword() == null || player.getPassword().isEmpty()) {
			System.out.println("비밀번호가 누락되었습니다! 점수를 저장할 수 없습니다.");
			return;
		}
		QuizScore.saveScore(player.getUsername(), player.getPlayerName(), score); // 점수 저장
	}
}