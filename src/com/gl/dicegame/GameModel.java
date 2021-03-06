package com.gl.dicegame;

public class GameModel {

	private int[] order;
	private int targetPoints;
	private int[] playerNumberByRank;
	private int playerCount;
	private int remainingPlayers;
	private PlayerModel[] players;

	GameModel() {
	}

	public GameModel(int totalPlayers, int targetPoints) {
		order = Utils.generateOrder(totalPlayers);
		playerNumberByRank = Utils.getOnetoNArray(totalPlayers);
		this.targetPoints = targetPoints;
		remainingPlayers = totalPlayers;
		players = new PlayerModel[totalPlayers];
		playerCount = totalPlayers;
	}

	// static class GameModelExtensions {
	public boolean isComplete(GameModel game) {
		return game.remainingPlayers == 0;
	}

	public void decreaseRemainingPlayers(GameModel game) {
		game.remainingPlayers--;
	}

	public PlayerModel getCurrentPlayer(GameModel game, int index) {
		return game.players[game.order[index] - 1];
	}

	public PlayerModel getPlayerByRank(GameModel game, int rank) {
		return game.players[game.playerNumberByRank[rank - 1] - 1];
	}

	public void initializePlayers(GameModel game) {
		for (int i = 0; i < game.players.length; i++) {
			game.players[i] = new PlayerModel(i + 1, i + 1);
		}
	}

	public void swapPositions(GameModel game, PlayerModel player1, PlayerModel player2) {
		game.playerNumberByRank[player1.getRank() - 1] = player2.getNumber();
		game.playerNumberByRank[player2.getRank() - 1] = player1.getNumber();

		int player1Rank = player1.getRank();
		player1.setRank(player2.getRank());
		player2.setRank(player1Rank);
	}

	// }

	public int[] getOrder() {
		return order;
	}

	public void setOrder(int[] order) {
		this.order = order;
	}

	public int getTargetPoints() {
		return targetPoints;
	}

	public void setTargetPoints(int targetPoints) {
		this.targetPoints = targetPoints;
	}

	public int[] getPlayerNumberByRank() {
		return playerNumberByRank;
	}

	public void setPlayerNumberByRank(int[] playerNumberByRank) {
		this.playerNumberByRank = playerNumberByRank;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public int getRemainingPlayers() {
		return remainingPlayers;
	}

	public void setRemainingPlayers(int remainingPlayers) {
		this.remainingPlayers = remainingPlayers;
	}

	public PlayerModel[] getPlayers() {
		return players;
	}

	public void setPlayers(PlayerModel[] players) {
		this.players = players;
	}
}
