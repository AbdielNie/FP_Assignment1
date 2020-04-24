package model;

import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	
	private Collection<Player> players;
	private GameEngineCallback callback;
	private DicePair houseResult;

	public GameEngineImpl() {
		players = new ArrayList<Player>();
		callback = null;
	}
	
	@Override
	public void rollPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) {
		roll(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
		player.setResult(houseResult);
		callback.playerDieUpdate(player, houseResult.getDie1(), this);
		callback.playerDieUpdate(player, houseResult.getDie2(), this);
		callback.playerResult(player, houseResult, this);
	}

	@Override
	public void rollHouse(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) {
		roll(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
		for (Player player : players) {
			applyWinLoss(player, houseResult);
			callback.houseResult(player.getResult(), this);			
			player.resetBet();
		}
	}
	
	private void roll(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) {
		houseResult = new DicePairImpl();
	}

	@Override
	public void applyWinLoss(Player player, DicePair houseResult) {
		if (player.getResult().getTotal() > houseResult.getTotal()) {
			player.setPoints(player.getPoints() + 2 * player.getBet());
		} else if (player.getResult().getTotal() == houseResult.getTotal()) {
			player.setPoints(player.getPoints() + player.getBet());
		} 
	}

	@Override
	public void addPlayer(Player player) {
		Player same = getPlayer(player.getPlayerId());
		if (same != null) {
			players.remove(same);
		}
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for (Player player : players) {
			if (player.getPlayerId().equals(id)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		return players.remove(player);
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.setBet(bet);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		callback = gameEngineCallback;
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (callback != null) {
			callback = null;
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players;
	}

}
