package RoomEscape;

import java.util.concurrent.BlockingQueue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class RoomLogic implements Runnable {
    private BlockingQueue<String> inputQueue;
    private RoomUI ui;
    private volatile boolean running = true;
    private int currentStage = 1;
    private String stage1Answer = "LRLR";
    private String[] stage2Questions = {"서울의 수도는?", "노을의 색은?", "배우고 있는 언어는?"};
    private String[] stage2Answers = {"서울", "주황색", "JAVA"};
    private int currentStage2QuestionIndex = 0;
    private Set<String> stage3Answers = new HashSet<>(Set.of("19", "28", "37", "46", "55"));
    private Set<String> userStage3Inputs = new HashSet<>();
    private String stage3Hint = "힌트는 각 2자리의 숫자의 합은 10입니다.";
    private String stage3InputRequest = "십의 자리가 1부터 5까지인 두 자리 숫자를 입력해주세요";

    public RoomLogic(BlockingQueue<String> inputQueue, RoomUI ui) {
        this.inputQueue = inputQueue;
        this.ui = ui;
    }

    public void stopGame() {
        running = false;
    }

    @Override
    public void run() {
        ui.displayMessage("게임 시작!");

        while (running) {
            switch (currentStage) {
                case 1:
                    ui.displayMessage("[스테이지 1] L, R 중 한 글자씩 입력하세요 : ");
                    if (playStage1()) {
                        currentStage = 2;
                        currentStage2QuestionIndex = 0;
                    } else {
                        currentStage = 1;
                        Image();
                        ui.displayMessage("You Died!");
                        ui.displayMessage("처음부터 다시 시작합니다.");
                    }
                    break;
                case 2:
                    if (currentStage2QuestionIndex < stage2Questions.length) {
                        ui.displayMessage("[스테이지 2 - " + (currentStage2QuestionIndex + 1) + "/" + stage2Questions.length + "] " + stage2Questions[currentStage2QuestionIndex]);
                        if (playStage2()) {
                            currentStage2QuestionIndex++;
                            if (currentStage2QuestionIndex == stage2Questions.length) {
                                currentStage = 3;
                                userStage3Inputs.clear(); // 스테이지 3 시작 시 사용자 입력 초기화
                            }
                        } else {
                            currentStage = 1;
                            Image();
                            ui.displayMessage("You Died!");
                            ui.displayMessage("처음부터 다시 시작합니다.");
                        }
                    }
                    break;
                case 3:
                    ui.displayMessage("[스테이지 3] " + stage3InputRequest + " (" + stage3Hint + ")");
                    if (playStage3()) {
                        ui.displayMessage("모든 스테이지를 완료했습니다! 탈출 성공!");
                        running = false;
                    } else {
                        currentStage = 1;
                        Image();
                        ui.displayMessage("You Died!");
                        ui.displayMessage("처음부터 다시 시작합니다.");
                    }
                    break;
                default:
                    running = false;
                    break;
            }
        }
        ui.displayMessage("게임 종료");
        System.exit(0);
    }

    private boolean playStage1() {
        StringBuilder currentInput = new StringBuilder();
        ui.displayProgress(currentInput.toString(), stage1Answer.length());
        while (currentInput.length() < stage1Answer.length() && running) {
            try {
                String input = inputQueue.take();
                if (!running) return false;
                if (input.length() == 1) {
                    String upperInput = input.toUpperCase();
                    if (upperInput.equals("L") || upperInput.equals("R")) {
                        currentInput.append(upperInput);
                        ui.displayProgress(currentInput.toString(), stage1Answer.length());
                        if (currentInput.toString().equals(stage1Answer)) {
                            ui.displayMessage("[스테이지 1] 통과!");
                            return true;
                        }
                    } else {
                        ui.displayMessage("[스테이지 1] 틀렸습니다!");
                        return false; // L, R, F 외의 입력이 들어오면 스테이지 1 실패
                    }
                } else {
                    ui.displayMessage("[스테이지 1] 한 글자씩 입력해주세요.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return false;
    }

    private boolean playStage2() {
        try {
            String input = inputQueue.take();
            if (!running) return false;
            if (input.equalsIgnoreCase(stage2Answers[currentStage2QuestionIndex])) {
                ui.displayMessage("[스테이지 2 - " + (currentStage2QuestionIndex + 1) + "] 정답!");
                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    private boolean playStage3() {
        while (userStage3Inputs.size() < stage3Answers.size() && running) {
            try {
                String input = inputQueue.take();
                if (!running) return false;
                if (input.length() == 2 && input.matches("[0-9]{2}")) {
                    if (stage3Answers.contains(input)) {
                        userStage3Inputs.add(input);
                        ui.displayMessage("[스테이지 3] " + input + " 입력!");
                        if (userStage3Inputs.equals(stage3Answers)) {
                            ui.displayMessage("[스테이지 3] 통과!");
                            return true;
                        }
                    } else {
                        ui.displayMessage("[스테이지 3] 틀렸습니다! 힌트를 다시 확인해주세요.");
                        return false;
                    }
                } else {
                    ui.displayMessage("[스테이지 3] " + stage3InputRequest);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return userStage3Inputs.equals(stage3Answers); // 루프 종료 후 최종 확인
    }

    private void Image() {
        System.out.println(".......................:!##!............\r\n"
                + "......................;=#@#$~...........\r\n"
                + ".....................;=@@@#$:...........\r\n"
                + "....................;$@@@@@#*-......,-,,\r\n"
                + ".......,,,........,:*#@@@@##$-....--:**!\r\n"
                + "....-:;;;::~,..,~:!**=$@@@##$-...~*!!***\r\n"
                + "....~=$##$=!:~:;*$###=!$@##$$-...!****!!\r\n"
                + "....,*#@@@=***!!=@@@@#=!=##$=~.:!!**!!!!\r\n"
                + ".....;#@@#*$#@*!$@@@@@@!!;;;!~;=!!!!!!!!\r\n"
                + ".....-=#@$=@@@=!=@@#$##:;*===*==!!;!!!!!\r\n"
                + "......:$#!$@@#$;!$#*-*=!=$$##===!!!!!!*!\r\n"
                + ".......*$*#@=!*;;;*=**=$#@@@#===*!*==*!*\r\n"
                + ".......-=*#@!-*****=$$#@@@@@#$$$=!====**\r\n"
                + ".......-;;!**!=#####@@@@@@@@@$==$====**=\r\n"
                + "......:!!*!*$##@@@@@@@@@@@@@#==#@===***=\r\n"
                + "......!=$#@@@@@@@@@@@@@@@@@@$=#@@==*====\r\n"
                + "......!$@@@@@@@@@@@@@@@@@@@@$=#@@====$=$\r\n"
                + "......,=#@@@@@@@@@@@@@@@@@@@$$#@@====$$$\r\n"
                + ".......*=@@@@@@@@@@@@@@@@@@#=#@@@==$=$$$\r\n"
                + ".......-=$@@@@@@@@@@@@@@@@#$$@@@#====$$$\r\n"
                + "........;=$@@@@@@@@@@@@@@@==#@@@======$$\r\n"
                + ".........:=#@@@@@@@@@@@@@==##@@@===*==$$\r\n"
                + ".........,!*#@@@@@@@@@@@==####@#$$=**==$\r\n"
                + "..........-**#@@@@@@@@#*$$$####$$======$\r\n"
                + "...........-***$#####==$#$$==$###$$$===$\r\n"
                + "............-;*=======*!#$*:;*$$=$$$$==$");
    }
}
