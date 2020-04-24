package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;
	private String playerName;
	private int points;
	private int bet;
	private DicePair result;
	
	/**
	 * Note: playerID is unique and if another player with same id is added it replaces the previous player
	 * 
	 * @param playerId unique
	 * @param playerName
	 * @param initialPoints
	 */
	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
	}
	
	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public boolean setBet(int bet) {
		if (bet <= points) {
			points -= bet;
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public void resetBet() {
		bet = 0;
	}

	@Override
	public DicePair getResult() {
		return result;
	}

	@Override
	public void setResult(DicePair rollResult) {
		result = rollResult;
	}

	@Override
	public String toString() {
		return "Player: id=" + getPlayerId() + ", name=" +  getPlayerName()
				+ ", bet=" + getBet() + ", points=" + getPoints()
				+ ", RESULT: " + getResult();
	}
}
