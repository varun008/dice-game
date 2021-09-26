package com.gl.dicegame.tests.GameLogic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gl.dicegame.GameLogic;

public class GiveAnotherChanceTest {

	@Test
	public void returnTrueIf6() {
		assertTrue(GameLogic.giveAnotherChance(6));
	}

	@Test
	public void returnFalseIfNot6() {
		//assertTrue(GameLogic.giveAnotherChance(5));
		assertFalse(GameLogic.giveAnotherChance(5));
	}
}
