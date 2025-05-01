package player;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PlayerController playerController = new PlayerController();
		QuizMain quizMain = null;
//        playerController.registerPlayer();  // 회원가입 진행
//        playerController.closeScanner();    // 사용 후 Scanner 닫기

		System.out.println("무서운 스인걔임");

		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [0]종료");
			System.out.print(">> ");
			num = sc.nextInt();
			if (num == 1) {
				playerController.registerPlayer();
			}
			else if(num == 2) {
				boolean succes = playerController.login();
				if (succes) {
                    PlayerDTO currentPlayer = playerController.getCurrentPlayer();
                    if (currentPlayer != null) {
                        quizMain = new QuizMain(currentPlayer);
                        break;
                    }
				}
			} else if(num == 0) {
				System.out.println("게임을 종료합니다");
				return;
			}
		}
		
		while(true) {
			System.out.println("[1]랭킹조회 [2]게임시작 [3]회원탈퇴 [0]종료");
			System.out.print(">> ");
			num = sc.nextInt();
			if(num == 1) {
				playerController.Ranking();
			} else if(num == 2) {
				if (quizMain != null) {
                    quizMain.StartGame(); // 퀴즈 게임 시작
                }
			} else if(num == 3) {
				playerController.delete();
			} else if(num == 0) {
				System.out.println("게임을 종료합니다");
				break;
			}
		}
		sc.close();
	}
}