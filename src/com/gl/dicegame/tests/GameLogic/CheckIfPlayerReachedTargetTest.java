package com.gl.dicegame.tests.GameLogic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gl.dicegame.GameLogic;
import com.gl.dicegame.GameModel;

public class CheckIfPlayerReachedTargetTest {

	@Test
	public void ReturnTrueIfTargetReached() {
		GameModel game = new GameModel(2, 10);
		game.initializePlayers(game);
		game.getPlayers()[1].updatePoints(game.getPlayers()[1], 10);
		assertTrue(GameLogic.checkIfPlayerReachedTarget(game, game.getPlayers()[1]));
	}

	@Test
	public void ReturnTrueIfTargetCrossed() {
		GameModel game = new GameModel(2, 10);
		game.initializePlayers(game);
		game.getPlayers()[1].updatePoints(game.getPlayers()[1], 12);
		assertTrue(GameLogic.checkIfPlayerReachedTarget(game, game.getPlayers()[1]));
	}

	@Test
	public void ReturnFalseIfTargetNotReached() {
		GameModel game = new GameModel(2, 10);
		game.initializePlayers(game);
		game.getPlayers()[1].updatePoints(game.getPlayers()[1], 2);
		assertFalse(GameLogic.checkIfPlayerReachedTarget(game, game.getPlayers()[1]));
	}

}
