package Ranking;

import player.PlayerDTO;
import Quiz.QuizDTO;

import java.util.List;

public class RankingController {
    private RankingDAO rankingDAO;

    public RankingController(RankingDAO rankingDAO) {
        this.rankingDAO = rankingDAO;
    }

    // 퀴즈 결과 저장
    public void submitQuizResult(PlayerDTO player, QuizDTO quiz) {
//        rankingDAO.saveScore(player.getPlayerId(), quiz.isCorrect(true));
//        System.out.println("점수가 저장되었습니다: " + quiz.isCorrect(true));
    }

    // 랭킹 출력
    public void printTopRanking() {
        List<RankingDTO> topList = rankingDAO.getTopRanking();
        System.out.println("🏆 현재 TOP 10 랭킹 🏆");
        for (RankingDTO dto : topList) {
            System.out.println(dto);
        }
    }
}