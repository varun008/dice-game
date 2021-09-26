package com.gl.dicegame.tests.GameLogic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gl.dicegame.GameLogic;

public class GetNextPlayerTest {

	@Test
	public void ReturnNextPlayerWhenNotReachedLimit() {
		int nextPlayer = GameLogic.getNextPlayerByIndex(5, 10);
		assertTrue(nextPlayer == 6);
	}

	@Test
	public void ReturnNextPlayerWhenReachedLimit() {
		int nextPlayer = GameLogic.getNextPlayerByIndex(9, 10);
		assertTrue(nextPlayer == 0);
	}
}
