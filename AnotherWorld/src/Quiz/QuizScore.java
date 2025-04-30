package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class QuizScore {
    public static void saveScore(String playerName, int score) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 주소
        String user = "HELLOWORLD";                         // 사용자명
        String password = "비밀번호";                       // 비밀번호

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "MERGE INTO PLAYERS p USING DUAL ON (p.NAME = ?) " +
                         "WHEN MATCHED THEN UPDATE SET p.SCORE = ? " +
                         "WHEN NOT MATCHED THEN INSERT (NAME, SCORE) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, playerName);
            pstmt.setInt(2, score);
            pstmt.setString(3, playerName);
            pstmt.setInt(4, score);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            System.out.println("점수가 데이터베이스에 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("점수 저장 실패");
        }
    }
}
