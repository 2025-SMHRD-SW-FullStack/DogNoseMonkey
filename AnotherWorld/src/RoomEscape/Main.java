package RoomEscape;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();
        RoomUI ui = new RoomUI();
        RoomLogic gameLogic = new RoomLogic(inputQueue, ui);
        RoomInput inputHandler = new RoomInput(inputQueue);

        Thread logicThread = new Thread(gameLogic);
        logicThread.start();
        inputHandler.start();

        // 게임 종료 시 스레드를 안전하게 종료하기 위한 코드 (예시 - 특정 조건 발생 시)
        // try {
        //     Thread.sleep(60000); // 1분 후 종료
        // } catch (InterruptedException e) {
        //     Thread.currentThread().interrupt();
        // }
        // gameLogic.stopGame();
        // inputHandler.stopThread();
    }
}