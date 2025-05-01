package Ranking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RankingDAO {

	private static final String URL = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
	private static final String USER = "campus_25SW_FS_p1_5";
	private static final String PASSWORD = "smhrd5";

	public static void getScore(String playerName, int score) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet result = null;
		try {
			// 1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결 가져오기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. SQL 쿼리 작성
			String sql = "SELECT USERNAME,SCORE FROM PLAYERS ORDER BY SCORE";

			// 4. PreparedStatement 생성
			psmt = conn.prepareStatement(sql);

			// 5. 쿼리 실행
			result = psmt.executeQuery();
			
			System.out.println("====== 랭킹 조회 ======");
			System.out.println("순위\t이름\t점수");
			while(result.next()) {
				int rank =1;
				System.out.println(rank+"\t"+result.getString("USERNAME") + "\t" + result.getString("SCORE"));
				rank++;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류: " + e.getMessage());
		} finally {
			// 6. 자원 해제 
			try {
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (result!= null) {
					result.close();
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
	}

}
