package RoomEscape;

public class RoomUI {
    public void displayMessage(String message) {
        System.out.println("[알림] " + message);
    }

    public void displayProgress(String currentInput, int targetLength) {
        System.out.println("현재 입력: " + currentInput + (currentInput.length() < targetLength ? "_" : "") +
                           " (" + currentInput.length() + "/" + targetLength + ")");
    }
}
