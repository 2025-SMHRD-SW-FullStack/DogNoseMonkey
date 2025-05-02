package player;

import java.util.Scanner;

import Audio.AudioPlayer;
import Quiz.QuizMain;

public class Main {

	public static void main(String[] args) {
		PlayerController playerController = new PlayerController();
		QuizMain quizMain = null;
		PlayerDTO currentPlayer = null;
//        playerController.registerPlayer();  // 회원가입 진행
//        playerController.closeScanner();    // 사용 후 Scanner 닫기
		
	      AudioPlayer player = new AudioPlayer();
	       
//	      try {
//	            player.load("resources/audio/QuizBGM.wav");
//	            player.play();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//		
//		System.out.println("!!!달려라 자바왕!!!\n");
//        try {
//            Thread.sleep(3000); // 3초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("서기 2999년\n");
//        try {
//            Thread.sleep(3000); // 3초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("여러분은 어느 피라미드를 탐험하기 위해 이 곳을 방문하였습니다");
//        System.out.println(".　　　☆ *　. 　☆\r\n"
//        		+ "　　☆　. ∧＿∧∩　* ☆\r\n"
//        		+ "     ━등━━( ・∀・)/ . ━━장━！！\r\n"
//        		+ "　　　. ⊂　　 ノ* ☆\r\n"
//        		+ "　　☆ * (つ ノ .☆\r\n"
//        		+ "　　　　 (ノ\r\n"
//        		+ "");
//        try {
//            Thread.sleep(3000); // 3초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("그러나 여러분은 보고야 말았습니다\n");
//        try {
//            Thread.sleep(3000); // 6초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("마침 여러분이 지나가던 곳에는 스핑크스처럼 생긴 스핑크스가");
//        System.out.println("그랜절을 하고 있던 순간이었습니다");
//        System.out.println(".　 　∩　∩\r\n"
//        		+ "　　 / | ／/\r\n"
//        		+ "　　/ 　　/\r\n"
//        		+ "⊂二 　 　 二⊃\r\n"
//        		+ "　（ ､σ， ）능아아아아아아앍～\r\n"
//        		+ "　　Ｖ\"Ｖ\r\n"
//        		+ "");
//        try {
//            Thread.sleep(6000); // 6초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("\n마침 그랜절을 하고 있던 스핑크스처럼 생긴 스핑크스는 여러분을 처참하게 박살내기 위해 모험을 떠나기로 결심을 했고");
//        System.out.println("하필이면 자바 문제로 도망치지 못하게 하려는 속셈이었지만 이럴때를 대비해 저희는 자바를 배워뒀습니다");
//        System.out.println(".　∧,,∧\r\n"
//        		+ "∩(＾0＾) 오우~ 시스템아우또!\r\n"
//        		+ "ヽ　　　  ノ\r\n"
//        		+ "　|　　|\r\n"
//        		+ "　 U⌒U.\r\n"
//        		+ "");
//        try {
//            Thread.sleep(6000); // 6초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("솔직히 자신 없습니다");
//        System.out.println(".　　 /＼＿＿／ヽ\r\n"
//        		+ "　 ／ _ノ||||ヽ､_  ＼\r\n"
//        		+ " ／ oﾟ⌒　　⌒ﾟo　＼\r\n"
//        		+ "|　三（__人__）三　 | 하 씨... 나 문과인데...\r\n"
//        		+ " ＼　　 ``ー'´　　　／\r\n"
//        		+ "　  ／⌒))　((⌒ヽ\r\n"
//        		+ "");
//        try {
//            Thread.sleep(1000); // 1초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("여러분께서는 부디 이 정신나간 돌덩어리의 문제를 풀고 이 돌덩어리에게서 도망치시기 바랍니다\n");
//        System.out.println("\r\n"
//        		+ "　 　∧_∧\r\n"
//        		+ "　　(`･ω･´ ) 三 보지만 말고 저 좀 살려주세요!!!\r\n"
//        		+ "　　O┳〇 )\r\n"
//        		+ "　　◎し◎- 三\r\n"
//        		+ "");
//        try {
//            Thread.sleep(3000); // 3초 동안 지연
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

		System.out.println("   스핑크스의 피라미드에 오신 것을 환영합니다");
		System.out.println("\t   스핑크스네 피라미드");
		System.out.println("┍━♫¸.•¨`♬ʕ ﾉ•ᴥ•ʔﾉ♫ヽʕ•ᴥ•ʔﾉ♩ヽʕ •ᴥ•ʔﾉ♬*`.♫━┑\r\n"
				+ "├━♬　　   　•　정상 영업 중 　•　　　     ♬━┤　\r\n"
				+ "┕━━━━━━━•　      ♪　♬　♪　       •━━━━━━━━┙\r\n"
				+ "");

		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (true) {
			if (currentPlayer == null) {
			System.out.println("       [1]회원가입 [2]로그인 [3]회원탈퇴 [0]종료");
			System.out.print(">> ");
			num = sc.nextInt();
			if (num == 1) {
				playerController.registerPlayer();
			}
			else if(num == 2) {
				boolean succes = playerController.login();
				if (succes) {
                    	currentPlayer = playerController.getCurrentPlayer();
                        quizMain = new QuizMain(currentPlayer);
				}
			} else if(num == 3) {
				playerController.delete();
			} else if(num == 0) {
				System.out.println("게임을 종료합니다");
				break;
			}
		} else {
			System.out.println("[1]랭킹조회 [2]게임시작 [3]로그아웃 [0]종료");
			System.out.print(">> ");
			num = sc.nextInt();
			if(num == 1) {
				playerController.Ranking();
			} else if(num == 2) {
				if (quizMain != null) {
                    quizMain.StartGame(); // 퀴즈 게임 시작
                }
			} else if (num == 3) {
                currentPlayer = null;
                quizMain = null;
                System.out.println("로그아웃 되었습니다.");
            }else if(num == 0) {
				System.out.println("게임을 종료합니다");
				break;
			}
		}
	}
		sc.close();
}
}