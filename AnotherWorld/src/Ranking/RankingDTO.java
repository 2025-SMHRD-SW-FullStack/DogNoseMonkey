package Ranking;

import player.PlayerDTO;

public class RankingDTO {
	private PlayerDTO player;
	private int score;
	private int rank;

	public RankingDTO(PlayerDTO player, int score, int rank) {
		this.player = player;
		this.score = score;
		this.rank = rank;
	}

	public PlayerDTO getPlayer() {
		return player;
	}

	public int getScore() {
		return score;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank + "위: " + player.getPlayerName() + " (점수: " + score + ")";
	}

}