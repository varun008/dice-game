package com.gl.dicegame.tests.UtilsTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.gl.dicegame.Utils;

public class GetOnetoNArrayTest {

	@Test
	public void ReturnArrayOfLengthN() {
		int[] arr = Utils.getOnetoNArray(10);
		assertTrue(arr.length == 10);
	}

	@Test
	public void ReturnValidArray() {
		int[] arr = Utils.getOnetoNArray(10);
		assertTrue(arr[5] == 6);
		assertTrue(arr[1] == 2);
		assertTrue(arr[7] == 8);
		assertTrue(arr[9] == 10);
	}

	@Test
	public void ThrowExceptionForNegativeInput() {
		assertThrows(IllegalArgumentException.class, () -> Utils.getOnetoNArray(-1));
	}

}
