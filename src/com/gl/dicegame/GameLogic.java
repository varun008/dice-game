package com.gl.dicegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GameLogic {

	static Random rand = new Random();

	static int getDiceValue() {

		return rand.nextInt(6 - 1 + 1) + 1;
	}

	public static boolean checkIfPlayerReachedTarget(GameModel game, PlayerModel player) {
		return player.getPoints() >= game.getTargetPoints();
	}

	static void updatePlayerRankArrayAfterDiceRoll(GameModel game, PlayerModel currentPlayer) {
		while (true) {
			if (currentPlayer.getRank() == 1) {
				break;
			}
			PlayerModel highRankPlayer = game.getPlayerByRank(game, currentPlayer.getRank() - 1);
			if (highRankPlayer.getPoints() < currentPlayer.getPoints()) {
				game.swapPositions(game, currentPlayer, highRankPlayer);
			} else {
				break;
			}
		}
	}

	static void printRankTable(GameModel game) {
		System.out.println();
		System.out.println("Player: ");
		System.out.println(" |  Player | " + "Points" + " | " + "Rank" + " | ");
		for (PlayerModel player : game.getPlayers()) {
			System.out.println(" |       " + player.getNumber() + " |     " + player.getPoints() + "  |   "
					+ player.getRank() + "  | ");
		}
	}

	public static int getNextPlayerByIndex(int i, int playercount) {
		return (i + 1) % playercount;
	}

	public static boolean giveAnotherChance(int diceval) {
		return diceval == 6;
	}

	public void startGame(int totalplayers, int targetpoints) {
		GameModel game = new GameModel(totalplayers, targetpoints);
		game.initializePlayers(game);
		int index = 0;
		while (!game.isComplete(game)) {
			PlayerModel currentplayer = game.getCurrentPlayer(game, index);
			if (currentplayer.isGameComplete() || currentplayer.isPenalized()) {
				index = getNextPlayerByIndex(index, game.getPlayerCount());
				currentplayer.setPenalized(false);
				continue;
			}
			System.out.println("---------------------------------------------------------");
			System.out.println(
					"Player - " + currentplayer.getNumber() + " Its your Turn now(Press Any key to Roll Dice)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int diceval = getDiceValue();
			System.out.println("You scored " + diceval + " points.");
			currentplayer.updatePoints(currentplayer, diceval);
			updatePlayerRankArrayAfterDiceRoll(game, currentplayer);
			printRankTable(game);
			if (currentplayer.shouldPenalize(currentplayer, diceval)) {
				currentplayer.setPenalized(true);
				System.out.println("You are penalized for rolling 1 twice consecutively");
			}
			currentplayer.updatePreviousRoll(currentplayer, diceval);
			if (checkIfPlayerReachedTarget(game, currentplayer)) {
				currentplayer.completeGame(currentplayer);
				game.decreaseRemainingPlayers(game);
				System.out.println("Congratuations!! You have completed the game.");
			}
			if (!giveAnotherChance(diceval)) {
				index = getNextPlayerByIndex(index, game.getPlayerCount());
			}
		}
		System.out.println("Game Over");

	}

}
