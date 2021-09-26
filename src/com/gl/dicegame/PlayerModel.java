package com.gl.dicegame;

public class PlayerModel {

	private int number;
	private int rank;
	private int points;
	private boolean isGameComplete;
	private boolean isPreviousDiceRoll;
	private boolean isPenalized;

	public void updatePoints(PlayerModel player, int diceVal) {
		player.points += diceVal;
	}

	public void updatePreviousRoll(PlayerModel player, int diceval) {
		player.isPreviousDiceRoll = diceval == 1;
	}

	public boolean shouldPenalize(PlayerModel player, int diceval) {
		return player.isPreviousDiceRoll && diceval == 1;
	}

	public void completeGame(PlayerModel player) {
		player.isGameComplete = true;
	}
	// }

	public PlayerModel(int rank, int number) {
		this.rank = rank;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isGameComplete() {
		return isGameComplete;
	}

	public void setGameComplete(boolean isGameComplete) {
		this.isGameComplete = isGameComplete;
	}

	public boolean isPreviousDiceRoll() {
		return isPreviousDiceRoll;
	}

	public void setPreviousDiceRoll(boolean isPreviousDiceRoll) {
		this.isPreviousDiceRoll = isPreviousDiceRoll;
	}

	public boolean isPenalized() {
		return isPenalized;
	}

	public void setPenalized(boolean isPenalized) {
		this.isPenalized = isPenalized;
	}

}