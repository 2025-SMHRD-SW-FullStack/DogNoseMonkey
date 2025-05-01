package player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerController {
	private PlayerService playerService;
	private Scanner scanner;
	private PlayerDTO saveid;


	public PlayerController() {
		playerService = new PlayerService();
		scanner = new Scanner(System.in); // Scanner를 클래스 필드로 선언
	}
	
	public PlayerDTO getCurrentPlayer() {
	    return saveid;
	}

	public void registerPlayer() {
		System.out.println("회원가입을 시작합니다.");
		System.out.print("이름을 입력하세요: ");
		String playerName = scanner.nextLine();
		System.out.print("아이디를 입력하세요: ");
		String username = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();
		
		if (password == null || password.isEmpty()) {
	        System.out.println("비밀번호를 입력해주세요!");
	        return;
	    }

		PlayerDTO player = new PlayerDTO(null, playerName, username, password, 0);
		boolean success = playerService.registerPlayer(player);

		if (success) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("회원가입 실패! 아이디가 중복될 수 있습니다.");
		}
	}

	// Scanner 종료 메서드
	public void closeScanner() {
		if (scanner != null) {
			scanner.close();
		}
	}

	public boolean login() {
		System.out.print("아이디를 입력하세요: ");
		String username = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();

		PlayerDTO player = playerService.login(username, password);

		if (player != null) {
			System.out.println(player.getPlayerName() + "님, 로그인 성공했습니다!");
			saveid = player;
			return true;
		} else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			return false;
		}
	}
	
	// 랭킹 조회 메소드
	public void Ranking() {
	    ArrayList<PlayerDTO> list = playerService.Ranking();

	    System.out.println("=========== 랭킹 조회 ===========");
		System.out.println("순위\t이름\t점수");
		int rank = 1;
		
		list.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
		
	    for (PlayerDTO p : list) {
	        System.out.println(rank + "\t" + p.getPlayerName() + "\t" +p.getScore());
	        rank++;
	    }
	}
	
	public void delete() {
		System.out.print("아이디를 입력하세요: ");
		String username = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();
		System.out.println("계정이 탈퇴되었습니다");

		playerService.delete(username, password);
	}

	
}