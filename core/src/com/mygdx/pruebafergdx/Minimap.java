package com.mygdx.pruebafergdx;

import java.util.Arrays;
import java.util.Iterator;

public class Minimap {
	
	char minimap[][];
	int miniHeigth;
	int miniWidth;
	
	public Minimap() {

	}
	
	public void seeMinimap(Tile tilemap[][]) {
		
		// First write the minimap
		int realHeigth = tilemap.length;
		int realWidth = tilemap[0].length;
		
		minimap = new char[realHeigth/10][realWidth/10];
		this.miniHeigth = realHeigth/10;
		this.miniWidth = realWidth/10;
		
		Arrays.fill(minimap, ' ');
		
		for (int i = 0; i < realHeigth; i++) {
			for (int j = 0; j < realWidth; j++) {
				if (tilemap[i][j] == Tile.CAVE_01) {
					minimap[i/10][j/10] = 'C';
				}
			}
		}
		
		// Then draw the minimap
		for (int i = 0; i < miniHeigth; i++) {
			for (int j = 0; j < miniWidth; j++) {
				System.out.print(minimap[i][j]);
			}
			System.out.println();
		}
		
		minimap = null;
		
	}
	

}
