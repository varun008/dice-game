package com.gl.dicegame;

public class MainProgram {

	public static void main(String[] args) {
		if (!Utils.validateArgs(args)) {
			System.out.println("Invalid Arguments");
			return;
		}
		int totalPlayers = Utils.convertStringToPositiveInteger(args[0]);
		int targetPoints = Utils.convertStringToPositiveInteger(args[1]);
		System.out.println("Welcome to Dice Game");
		System.out.println("Total Player: " + totalPlayers);
		System.out.println("Target Points: " + targetPoints);
		GameLogic game = new GameLogic();
		game.startGame(totalPlayers, targetPoints);
	}

}
