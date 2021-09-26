package com.gl.dicegame;

import java.util.Random;

public class Utils {

	static Random random = new Random();

	public static int convertStringToPositiveInteger(String number) {
		if (isValid(number)) {
			return Integer.parseInt(number);
		} else {
			return -1;
		}

	}

	public static boolean isValid(String value) {
		if (value == null) {
			return false;
		}
		try {
			int n = Integer.parseInt(value);
			if (n > 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}

	public static boolean validateArgs(String[] args) {
		if (args.length != 2) {
			return false;
		}
		if (convertStringToPositiveInteger(args[0]) > 0 && convertStringToPositiveInteger(args[1]) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int[] getOnetoNArray(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n cannot be less or equal to zero");
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}

	public static int[] generateOrder(int totalPlayers) throws IllegalArgumentException {
		if (totalPlayers <= 0) {
			throw new IllegalArgumentException("n cannot be less than or equal to zero");
		}
		int[] orderarray = new int[totalPlayers];
		boolean[] orderedArray = new boolean[totalPlayers];
		int i = 0;
		System.out.println("Player Order: ");
		while (i < totalPlayers) {
			int playerNumber = random.nextInt((totalPlayers - 1) + 1) + 1;
			if (!orderedArray[playerNumber - 1]) {
				orderarray[i] = playerNumber;
				orderedArray[playerNumber - 1] = true;
				i++;
				System.out.println("Player Number :" + playerNumber);
			}
		}
		System.out.println();
		return orderarray;
	}

}
