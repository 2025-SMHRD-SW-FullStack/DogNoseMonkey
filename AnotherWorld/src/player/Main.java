package player;

public class Main {
    public static void main(String[] args) {
        PlayerController playerController = new PlayerController();
        playerController.registerPlayer();  // 회원가입 진행
        playerController.closeScanner();    // 사용 후 Scanner 닫기
    }
}