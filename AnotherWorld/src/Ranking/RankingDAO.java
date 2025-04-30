
package Ranking;

import player.PlayerDTO;
import Ranking.RankingDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankingDAO {
	private DataSource dataSource;

	public RankingDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 점수 저장
	public void saveScore(long playerId, int score) {
		String sql = "INSERT INTO PLAYER_SCORES (SCORE_ID, PLAYER_ID, SCORE) " + "VALUES (SCORE_SEQ.NEXTVAL, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, playerId);
			stmt.setInt(2, score);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 랭킹 조회
	public List<RankingDTO> getTopRanking() {
		String sql = "SELECT * FROM ( " + "  SELECT p.PLAYER_ID, p.PLAYER_NAME, MAX(s.SCORE) AS HIGH_SCORE, "
				+ "         RANK() OVER (ORDER BY MAX(s.SCORE) DESC) AS RANKING " + "  FROM PLAYERS p "
				+ "  JOIN PLAYER_SCORES s ON p.PLAYER_ID = s.PLAYER_ID " + "  GROUP BY p.PLAYER_ID, p.PLAYER_NAME "
				+ ") WHERE ROWNUM <= 10";

		List<RankingDTO> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				PlayerDTO player = new PlayerDTO(rs.getLong("PLAYER_ID"), rs.getString("PLAYER_NAME"), null, null // 로그인
																													// 정보는
																													// 필요
																													// 없으니
																													// 생략
				);
				RankingDTO ranking = new RankingDTO(player, rs.getInt("HIGH_SCORE"), rs.getInt("RANKING"));
				list.add(ranking);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
