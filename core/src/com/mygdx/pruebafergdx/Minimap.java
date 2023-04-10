package com.mygdx.pruebafergdx;


import Map.MapDraw;

public class Minimap {
	
	public static void seeMinimap(MapDraw map, int playerX, int playerY) {
		
		Tile[][] tilemap = map.tilemap;
		
		// First write the minimap
		int realHeigth = tilemap.length;
		int realWidth = tilemap[0].length;
		
		char[][] minimap = new char[realHeigth/10][(realWidth/10)*2];
		int miniHeigth = realHeigth/10;
		int miniWidth = (realWidth/10)*2;
		
		for (int i = 0; i < miniHeigth; i++) {
			for (int j = 0; j < miniWidth; j++) {
				minimap[i][j] = ' ';
			}
		}
		
		for (int i = 0; i < realHeigth; i++) {
			for (int j = 0; j < realWidth; j++) {
				if (tilemap[i][j] == Tile.CAVE_01) {
					// minimap[i/10][j/10] = 'C';
				}
				if (tilemap[i][j] == Tile.MAN) {
					// minimap[i/10][j/10] = 'M';
				}
			}
		}
		
		// Always write the player at finish
		minimap[playerY/10][(playerX/10)*2] = 'P';
		
		// Then draw the minimap
		for (int i = 0; i < miniHeigth; i++) {
			if (i == 0) {
				System.out.print("|");
				for (int j = 0; j < miniWidth; j++) {
					System.out.print("-");
				}
				
				System.out.println("|");
			}
			
			System.out.print("|");
			for (int j = 0; j < miniWidth; j++) {
				System.out.print(minimap[i][j]);				
				
			}
			System.out.print("|");
			
			if (i == 3) {
				System.out.print("           N");
			}
			if (i == 4) {
				System.out.print("          S E");
			}
			if (i == 5) {
				System.out.print("           W");
			}
			if (i == 7) {
				System.out.print("   --------------------");
			}
			if (i == 8) {
				System.out.print("   | Michiland map    |");
			}
			if (i == 9) {
				System.out.print("   |                  |");
			}
			if (i == 10) {
				System.out.print("   | Legend           |");
			}
			if (i == 11) {
				System.out.print("   |                  |");
			}
			if (i == 12) {
				System.out.print("   | X: Cave          |");
			}
			if (i == 13) {
				System.out.print("   | J: Objetive      |");
			}
			if (i == 14) {
				System.out.print("   | P: You           |");
			}
			if (i == 15) {
				System.out.print("   |                  |");
			}
			if (i == 16) {
				System.out.print("   --------------------");
			}
			
			System.out.println();
			
			if (i == miniHeigth-1) {
				System.out.print("|");
				for (int j = 0; j < miniWidth; j++) {
					System.out.print("-");
				}
				System.out.println("|");
			}
		}
		
		minimap = null;
		
	}
	

}
