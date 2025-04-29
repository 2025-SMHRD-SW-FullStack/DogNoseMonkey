package player;

import java.sql.*;

public class PlayerDAO {
    private Connection connection;

    public PlayerDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game_db", "hr", "12345");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 로그인 메서드 (아이디와 패스워드로 인증)
    public PlayerDTO login(String username, String password) {
        String query = "SELECT * FROM players WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PlayerDTO(
                    rs.getLong("player_id"),
                    rs.getString("player_name"),
                    rs.getString("username"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 로그인 실패
    }

    // 새로운 플레이어 등록
    public void registerPlayer(PlayerDTO player) {
        String query = "INSERT INTO players (player_name, username, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, player.getPlayerName());
            stmt.setString(2, player.getUsername());
            stmt.setString(3, player.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //아이디 중복 체크하는 메서드
    public boolean checkUsernameExists(String username) {
        String query = "SELECT * FROM players WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // 아이디가 존재하면 true, 없으면 false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
