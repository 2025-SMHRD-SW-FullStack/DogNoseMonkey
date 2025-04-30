package player;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerService {
	private PlayerDAO playerDAO;
	private static final Logger logger = Logger.getLogger(PlayerService.class.getName());

	public PlayerService() {
		playerDAO = new PlayerDAO(); // DAO 객체 생성
	}

	public boolean registerPlayer(PlayerDTO player) {
		try {
			// 아이디 중복 체크
			if (isUsernameTaken(player.getUsername())) {
				return false; // 아이디가 이미 존재하면 실패
			}

			// 회원가입 등록
			playerDAO.registerPlayer(player);
			return true;
		} catch (Exception e) {
			// 예외 발생 시 로그 기록
			logger.log(Level.SEVERE, "회원가입 처리 중 오류 발생: " + e.getMessage(), e);
			return false;
		}
	}

	private boolean isUsernameTaken(String username) {
		return playerDAO.checkUsernameExists(username);
	}
}