package com.gl.dicegame.tests.UtilsTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gl.dicegame.Utils;

public class ConvertStringToPositiveTest {

	@Test
	public void ReturnNumberForValidNumber() {
		int number = Utils.convertStringToPositiveInteger("10");
		assertTrue(number == 10);
	}

	@Test
	public void ReturnMinusOneForNegativeNumber() {
		int number = Utils.convertStringToPositiveInteger("-10");
		assertTrue(number == -1);
	}

	@Test
	public void ReturnMinusOneForInvalidNumber() {
		int number = Utils.convertStringToPositiveInteger("10s");
		assertTrue(number == -1);
	}

	@Test
	public void ReturnMinusOneForNonIntegers() {
		int number = Utils.convertStringToPositiveInteger("10.2");
		assertTrue(number == -1);
	}

}
