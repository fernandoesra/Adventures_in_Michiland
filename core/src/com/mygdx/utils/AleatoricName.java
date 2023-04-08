package com.mygdx.utils;

public class AleatoricName {
	
	String name;
	
	public AleatoricName() {
		this.name = 
				""+
		this.generateConsonantMayus()+
		this.generateVowelMinus()+
		this.generateConsonantMinus()
		
		;
	}
	
	public char generateVowelMinus() {
		int random = (int) (Math.random() * 6 + 1);
		char vowel = 'a';
		switch (random) {
		case 1:
			vowel = 'a';
			break;
		case 2:
			vowel = 'e';
			break;
		case 3:
			vowel = 'i';
			break;
		case 4:
			vowel = 'o';
			break;
		case 5:
			vowel = 'u';
			break;
		default:
			break;
		}
		return vowel;
	}
	
	public char generateConsonantMinus() {
		int random = 0;
		
		do {
			random = (int) (Math.random() * 123 + 97);
		} while (random == 97 || random == 101 || random == 105 || random == 111 || random == 117);
		
		
		return (char)random;
	}
	
	public char generateVowelMayus() {
		int random = (int) (Math.random() * 6 + 1);
		char vowel = 'A';
		switch (random) {
		case 1:
			vowel = 'A';
			break;
		case 2:
			vowel = 'E';
			break;
		case 3:
			vowel = 'I';
			break;
		case 4:
			vowel = 'O';
			break;
		case 5:
			vowel = 'U';
			break;
		default:
			break;
		}
		return vowel;
	}
	
	public char generateConsonantMayus() {
		int random = 0;
		
		do {
			random = (int) (Math.random() * 91 + 65);
		} while (random == 65 || random == 69 || random == 73 || random == 79 || random == 85);
		
		
		return (char)random;
	}
	
	public String toString() {
		return name;
	}
	
	/*
	 * Mayus: 65 (A), 69 (E), 73 (I), 79 (O), 85 (U) - 90 (Z)
	 * Minus: 97 (a), 101 (e), 105 (i), 111 (o), 117 (u) - 122 (z)
	 */

}
