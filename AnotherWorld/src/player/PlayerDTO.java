package player;

public class PlayerDTO {
    private Long playerId;
    private String playerName;
    private String username;  // 로그인 아이디
    private String password;  // 로그인 패스워드

    private int score;		  
    

	public PlayerDTO(Long playerId, String playerName, String username, String password, int score) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.username = username;
		this.password = password;
		this.score = score;
	}

	public PlayerDTO() {
    	
    }

    // Getter 및 Setter
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
    	return score;
    }
    
    public void setScore(int score) {
    	this.score = score;
    }
    
    @Override
    public String toString() {
        return "PlayerDTO{id=" + playerId + ", name='" + playerName + "', username='" + username + "'}";
    }
}
