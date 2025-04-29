package RoomEscape;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class RoomInput extends Thread {
    private BlockingQueue<String> inputQueue; // 입력 전체를 String으로 받도록 변경
    private boolean running = true;

    public RoomInput(BlockingQueue<String> inputQueue) {
        this.inputQueue = inputQueue;
    }

    public void stopThread() {
        running = false;
        interrupt();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력을 시작하세요:");
        while (running) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim(); // 대소문자 변환은 RoomLogic에서 처리
                try {
                    inputQueue.put(input);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            } else if (!running) {
                break;
            }
        }
        scanner.close();
        System.out.println("입력 스레드 종료");
    }
}
