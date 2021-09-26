package com.gl.dicegame.tests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.gl.dicegame.tests.GameLogic.CheckIfPlayerReachedTargetTest;
import com.gl.dicegame.tests.GameLogic.GetNextPlayerTest;
import com.gl.dicegame.tests.GameLogic.GiveAnotherChanceTest;
import com.gl.dicegame.tests.UtilsTest.ConvertStringToPositiveTest;
import com.gl.dicegame.tests.UtilsTest.GetOnetoNArrayTest;
import com.gl.dicegame.tests.UtilsTest.UtilsGenerateOrderTest;
import com.gl.dicegame.tests.UtilsTest.ValidateArgsTest;

@RunWith(Suite.class)
@SuiteClasses({ SwapPositionTesting.class,CheckIfPlayerReachedTargetTest.class,GetNextPlayerTest.class,GiveAnotherChanceTest.class,
	ConvertStringToPositiveTest.class,GetOnetoNArrayTest.class,UtilsGenerateOrderTest.class,ValidateArgsTest.class})
public class AllTests {

	@BeforeClass
	public static void print() {
		System.out.println("Running the test classes");

	}

}
