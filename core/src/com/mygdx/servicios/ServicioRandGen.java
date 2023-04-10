package com.mygdx.servicios;

import java.util.Random;

public final class ServicioRandGen {
	
	private static Random randomNumberGen;

	public void init() {
		if(randomNumberGen == null)randomNumberGen = new Random();
	}

	public static void setSeedToRandonGenerator(long seed) {
		randomNumberGen.setSeed(seed);
	} 

	public static float randomFloatNorm() {
		return randomNumberGen.nextFloat();
	}

	// Get a random int from [min - max], both inclusive 
	public static int randomIntInRange(int min, int max) {
		int totalRange = max - min;
		int randomRange = (int)Math.round(randomNumberGen.nextFloat() * totalRange);
		return randomRange + min;
	}
}
