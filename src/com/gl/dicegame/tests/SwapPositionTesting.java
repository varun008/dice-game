package com.gl.dicegame.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gl.dicegame.GameModel;
import com.gl.dicegame.PlayerModel;

public class SwapPositionTesting {

	@Test
	public void PlayerRanksShouldBeSwapped() {
		GameModel game = new GameModel(3, 10);
		game.initializePlayers(game);
		PlayerModel player1 = game.getPlayerByRank(game,1);
		PlayerModel player2 = game.getPlayerByRank(game,2);
		game.swapPositions(game,player1, player2);
		assertTrue(player1.getRank() == 2);
		assertTrue(player2.getRank() == 1);
		PlayerModel updatedPlayer1 = game.getPlayerByRank(game,1);
		PlayerModel updatedPlayer2 = game.getPlayerByRank(game,2);
	}

	@Test
	public void PlayerRanksOrderInGameShouldBeSwapped() {
		GameModel game = new GameModel(3, 10);
		game.initializePlayers(game);
		PlayerModel player1 = game.getPlayerByRank(game,1);
		PlayerModel player2 = game.getPlayerByRank(game,2);
		game.swapPositions(game,player1, player2);
		PlayerModel updatedRank1Player = game.getPlayerByRank(game,1);
		PlayerModel updatedRank2Player = game.getPlayerByRank(game,2);
		assertTrue(player1.getRank() == updatedRank2Player.getRank());
		assertTrue(player2.getRank() == updatedRank1Player.getRank());
	}

}
