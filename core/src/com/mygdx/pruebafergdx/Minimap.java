package com.mygdx.pruebafergdx;


import Map.MapDraw;

public class Minimap {
	
	public static void seeMinimap(MapDraw map, int playerX, int playerY) {
		
		Tile[][] tilemap = map.tilemap;
		
		// First write the minimap
		int realHeigth = tilemap.length;
		int realWidth = tilemap[0].length;
		
		char[][] minimap = new char[realHeigth/10][realWidth/10];
		int miniHeigth = realHeigth/10;
		int miniWidth = realWidth/10;
		
		for (int i = 0; i < miniHeigth; i++) {
			for (int j = 0; j < miniWidth; j++) {
				minimap[i][j] = ' ';
			}
		}
		
		for (int i = 0; i < realHeigth; i++) {
			for (int j = 0; j < realWidth; j++) {
				if (tilemap[i][j] == Tile.CAVE_01) {
					minimap[i/10][j/10] = 'C';
				}
				if (tilemap[i][j] == Tile.MAN) {
					minimap[i/10][j/10] = 'M';
				}
			}
		}
		
		minimap[playerY/10][playerX/10] = 'P';
		
		// Then draw the minimap
		for (int i = 0; i < miniHeigth; i++) {
			
			if (i == 0) {
				for (int j = 0; j < miniWidth; j++) {
					System.out.print("-");
				}
				System.out.println();
			}
			
			for (int j = 0; j < miniWidth; j++) {
				System.out.print(minimap[i][j]);
			}
			System.out.println();
			
			if (i == miniHeigth-1) {
				for (int j = 0; j < miniWidth; j++) {
					System.out.print("-");
				}
				System.out.println();
			}
		}
		
		minimap = null;
		
	}
	

}
