package ThemeTimeLoop;

import java.util.Scanner;

import ThemeTimeLoop.TimeLoopController.Game;
import ThemeTimeLoop.TimeLoopController.Player;

public class InstantMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("플레이어 이름을 입력하세요: ");
		String name = scanner.nextLine();
		Player player = new Player(name);

		Game game = new Game(player);
		game.start();
	}
}
