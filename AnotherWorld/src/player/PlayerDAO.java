package player;

import java.sql.*;
import java.util.ArrayList;


public class PlayerDAO {
    private Connection connection;

    public PlayerDAO() {
        try {
        	connection = DriverManager.getConnection("jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe", "campus_25SW_FS_p1_5", "smhrd5");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 로그인 메서드 (아이디와 패스워드로 인증)
    public PlayerDTO login(String username, String password) {
    	if (username == null || password == null) {
            System.out.println("아이디와 비밀번호는 필수 입력 항목입니다.");
            return null;
        }
    	
        String query = "SELECT * FROM players WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	String playerName = rs.getString("player_name");
                if (playerName == null || playerName.isEmpty()) {
                    System.out.println("Player name is empty!");
                    return null;  // 비정상적인 값이 들어오면 null 반환
                }

                String playerUsername = rs.getString("username");
                String playerPassword = rs.getString("password");

                if (playerUsername == null || playerPassword == null) {
                    System.out.println("Username or Password is null!");
                    return null;
                }

                // 정상적인 경우 PlayerDTO 반환
                return new PlayerDTO(
                    rs.getLong("player_id"),
                    playerName,  // player_name은 null 체크 후 반환
                    playerUsername,  // username
                    playerPassword,  // password
                    rs.getInt("score")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 로그인 실패
    }

    // 새로운 플레이어 등록
    public void registerPlayer(PlayerDTO player) {
    	if (player.getPassword() == null || player.getPassword().isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 필수 항목입니다.");
        }
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
    
    // 랭킹 조회 메소드
    public ArrayList<PlayerDTO> Ranking() {
        PlayerDTO dto = null;
        ArrayList<PlayerDTO> list = new ArrayList<PlayerDTO>();
        String query = "SELECT player_id, player_name, username, score FROM players ORDER BY score DESC";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dto = new PlayerDTO();
                dto.setPlayerId(rs.getLong("player_id"));
                dto.setPlayerName(rs.getString("player_name"));
                dto.setUsername(rs.getString("username"));
                dto.setScore(rs.getInt("score"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public boolean delete(String username, String password) {
    	String query = "DELETE FROM players WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
   
    
}
