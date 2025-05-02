package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizScore {
    // Oracle 데이터베이스 연결 정보
    private static final String URL = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
    private static final String USER = "campus_25SW_FS_p1_5";
    private static final String PASSWORD = "smhrd5";

    public static void saveScore(String username, String playerName, int score) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // 2. 데이터베이스 연결 가져오기
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
         // 3. 현재 점수를 조회하는 쿼리 작성
            String checkScoreQuery = "SELECT score FROM players WHERE username = ?";
            pstmt = conn.prepareStatement(checkScoreQuery);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            int currentScore = 0;
            
            if (rs.next()) {
                currentScore = rs.getInt("score");  // 기존 점수 가져오기
            }


            if (score > currentScore) {
                String sql = "UPDATE players SET score = ? WHERE username = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, score);
                pstmt.setString(2, username);

                // 5. 쿼리 실행
                pstmt.executeUpdate();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL 오류: " + e.getMessage());
        } finally {
            // 6. 자원 해제 (pstmt, conn) -  try-catch-finally 구문으로 변경하여 자원해제
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // 자원 해제 실패 시 오류 출력 (로깅 권장)
            }
        }
    }
}
