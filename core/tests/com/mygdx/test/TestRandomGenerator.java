package com.mygdx.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mygdx.servicios.ServicioRandGen;

public class TestRandomGenerator {
	
	@Before
	public void initRandomNumberGenerator() {
		ServicioRandGen.init();
	}

	@Test
	public void testRandomIntRange0To10() {
		// [0 - 10]
		ServicioRandGen.setSeedToRandonGenerator(740367); // Close to 0
		assertTrue(ServicioRandGen.randomIntInRange(0, 10) == 0);
		ServicioRandGen.setSeedToRandonGenerator(35340451); // Close to 1.0
		assertTrue(ServicioRandGen.randomIntInRange(0, 10) == 10);
	}

	@Test
	public void testRandomIntRange0To1() {
		// [0 - 1]
		ServicioRandGen.setSeedToRandonGenerator(740367); // Close to 0
		assertTrue(ServicioRandGen.randomIntInRange(0, 1) == 0);
		ServicioRandGen.setSeedToRandonGenerator(35340451); // Close to 1.0
		assertTrue(ServicioRandGen.randomIntInRange(0, 1) == 1);
	}


	@Test
	public void testRandomIntRangeNeg100ToNeg50() {
		// [-100, -50]
		ServicioRandGen.setSeedToRandonGenerator(740367); // Close to 0
		assertTrue(ServicioRandGen.randomIntInRange(-100, -50) == -100);
		ServicioRandGen.setSeedToRandonGenerator(35340451); // Close to 1.0
		assertTrue(ServicioRandGen.randomIntInRange(-100, -50) == -50);
	}

	@Test
	public void testRandomIntRangeNeg100to0() {
		// [-100, 0]
		ServicioRandGen.setSeedToRandonGenerator(740367); // Close to 0
		assertTrue(ServicioRandGen.randomIntInRange(-100, 0) == -100);
		ServicioRandGen.setSeedToRandonGenerator(35340451); // Close to 1.0
		assertTrue(ServicioRandGen.randomIntInRange(-100, 0) == 0);
	}

	@Test
	public void testRandomIntRangeNeg100To50() {
		// [-100, 50]
		ServicioRandGen.setSeedToRandonGenerator(740367); // Close to 0
		assertTrue(ServicioRandGen.randomIntInRange(-100, 50) == -100);
		ServicioRandGen.setSeedToRandonGenerator(35340451); // Close to 1.0
		assertTrue(ServicioRandGen.randomIntInRange(-100, 50) == 50);
	}
}
