package com.gl.dicegame.tests.UtilsTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gl.dicegame.Utils;

public class ValidateArgsTest {

	@Test
	public void returnFalseForMoreThan2CommandLineInputs() {
		boolean isValid = Utils.validateArgs(new String[] { "", "", "" });
		assertFalse(isValid);
	}

	@Test
	public void returnFalseForNonIntegerOutput() {
		boolean isValid = Utils.validateArgs(new String[] { "", "", });
		assertFalse(isValid);
	}

	@Test
	public void returnFalseForNonIntegerOutputCase2() {
		boolean isValid = Utils.validateArgs(new String[] { "1", "", });
		assertFalse(isValid);
	}

	@Test
	public void returnFalseForLessThan2Args() {
		boolean isValid = Utils.validateArgs(new String[] { "1" });
		assertFalse(isValid);
	}

	@Test
	public void returnFalseForNegetiveIntegerArgs() {
		boolean isValid = Utils.validateArgs(new String[] { "-1", "10" });
		assertFalse(isValid);
	}

	@Test
	public void returnTrueForValidArgs() {
		boolean isValid = Utils.validateArgs(new String[] { "1", "10" });
		assertTrue(isValid);
	}

}
