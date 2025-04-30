package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuizScore {
    // Oracle 데이터베이스 연결 정보
    private static final String URL = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
    private static final String USER = "campus_25SW_FS_p1_5";
    private static final String PASSWORD = "smhrd5";

    public static void saveScore(String playerName, int score) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // 2. 데이터베이스 연결 가져오기
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. SQL 쿼리 작성 (MERGE 구문 사용)
            String sql = "INSERT INTO PLAYERS(SCORE) VALUES (?)"; 

            // 4. PreparedStatement 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, score);

            // 5. 쿼리 실행
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("점수가 데이터베이스에 성공적으로 저장되었습니다.");
            } else {
                System.out.println("점수 저장에 실패했습니다."); // MERGE 구문은 0을 반환하지 않으므로, 이 else 블록은 실행되지 않아야 합니다.
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
