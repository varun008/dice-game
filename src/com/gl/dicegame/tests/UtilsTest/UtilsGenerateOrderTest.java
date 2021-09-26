package com.gl.dicegame.tests.UtilsTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.gl.dicegame.Utils;

public class UtilsGenerateOrderTest {
	
	@Test
	public void returnArrayOfLengthN() {
		int[] arr = Utils.generateOrder(10);
		assertTrue(arr.length==10);
	}
	
	@Test
	public void returnArrayWithOutDuplicates()
    {
        int[] arr = Utils.generateOrder(3);
        assertTrue(arr[0] != arr[1]);
        assertTrue(arr[1] != arr[2]);
        assertTrue(arr[2] != arr[0]);
    } 
	
	@Test
	public void throwExceptionForNegativeInput()
    {
        assertThrows(IllegalArgumentException.class, () -> Utils.generateOrder(-1));
    }
}
