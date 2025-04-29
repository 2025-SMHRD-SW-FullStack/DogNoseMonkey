package ThemeTimeLoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeLoopController {

    static class Item {
        String name;
        String description;

        Item(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    static class Player {
        String name;
        int health;
        int sanity;
        boolean hasFlashlight = false;
        boolean eligibleForHiddenEnding = false;
        List<Item> inventory = new ArrayList<>();

        public Player(String name) {
            this.name = name;
            this.health = 100;
            this.sanity = 100;
        }

        void addItem(Item item) {
            inventory.add(item);
            if (item.name.equals("손전등")) {
                hasFlashlight = true;
            }
        }
    }

    static class Game {
        Player player;
        int loopCount = 0;
        Scanner scanner = new Scanner(System.in);

        public Game(Player player) {
            this.player = player;
        }

        void start() {
            while (loopCount < 7) {
                loopCount++;
                System.out.println("\n===== 루프 " + loopCount + "회차 시작 =====");
                System.out.println(player.name + "은(는) 어두운 저택에서 깨어났습니다...");

                if (loopCount == 1) {
                    firstLoopEvent();
                } else {
                    normalLoopEvent();
                }

                endOfDay();
            }

            // 7회차 루프 완료 후 엔딩 판단
            checkEnding();
        }

        void firstLoopEvent() {
            System.out.println("\n[이벤트] 침대 밑에서 뭔가 반짝이는 것을 발견했습니다.");
            System.out.println("1. 손전등을 집는다");
            System.out.println("2. 무시한다");
            System.out.print("선택 (1/2) : ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n당신은 손전등을 집었습니다.");
                player.addItem(new Item("손전등", "어둠을 밝히는 작은 빛."));
            } else {
                System.out.println("\n당신은 손전등을 무시했습니다. 어둠이 짙어집니다...");
                player.eligibleForHiddenEnding = true;
            }
        }

        void normalLoopEvent() {
            System.out.println("\n[탐색] 당신은 저택을 둘러보며 단서를 찾습니다...");

            if (!player.hasFlashlight) {
                System.out.println("[어둠] 손전등이 없어 벽에 흐릿한 글씨를 봅니다: '여기서 깨어나라...'");
            } else {
                System.out.println("[탐색] 손전등으로 주변을 밝히며 안전하게 탐색합니다.");
            }
        }

        void endOfDay() {
            System.out.println("\n0시가 다가옵니다...");
            System.out.println("어둠이 저택을 삼키고, 당신은 다시 처음으로 돌아갑니다.\n");
        }

        void checkEnding() {
            System.out.println("===== 마지막 루프 종료 =====");

            if (player.eligibleForHiddenEnding) {
                System.out.println("\n[히든 엔딩 조건 충족]");
                System.out.println("당신은 숨겨진 진실을 모두 보고, 저택과 함께 소멸하기로 결심했습니다.");
                System.out.println("히든 엔딩: <어둠 속으로>");
            } else {
                System.out.println("\n[일반 엔딩]");
                System.out.println("당신은 저택을 탈출했습니다. 하지만 마음 한켠엔 찝찝함이 남습니다...");
                System.out.println("True 엔딩: <탈출>");
            }
            System.exit(0);
        }
    }
}