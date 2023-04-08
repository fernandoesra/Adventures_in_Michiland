package com.mygdx.pruebafergdx;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	private int WIDTH;
	private int HEIGHT;
	private Tile tilemap[][];
	public Map(int WIDTH, int HEIGHT, Texture spriteSheet) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
				
		tilemap = new Tile[WIDTH][HEIGHT];
		
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {				
				tilemap[i][j] = Tile.EMPTY;
			}
			
		}
		
		// Generate TREE
		double minPercent = (WIDTH * HEIGHT) * 0.05;
		double maxPercent = (WIDTH * HEIGHT) * 0.60;

		double FILL = (Math.random() * maxPercent + minPercent);

		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY) {
				tilemap[fillWidth][fillHeight] = Tile.TREE;
			} else {
				i--;
			}
			
		}
		
		// Generate HOUSE
		minPercent = 1;
		maxPercent = 10;
		FILL = (Math.random() * maxPercent + minPercent);
		
		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY) {
				tilemap[fillWidth][fillHeight] = Tile.HOUSE;
			} else {
				i--;
			}
			
		}
		
		// Generate MAN
		
		minPercent = 0;
		maxPercent = 5;
		FILL = (Math.random() * maxPercent + minPercent);
		
		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY) {
				tilemap[fillWidth][fillHeight] = Tile.MAN;
			} else {
				i--;
			}
			
		}
		
		// Generate CAVE
		
		minPercent = 0;
		maxPercent = 2;
		FILL = (Math.random() * maxPercent + minPercent);
		
		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY) {
				tilemap[fillWidth][fillHeight] = Tile.CAVE;
			} else {
				i--;
			}
			
		}
		

	}
	
	public void draw(SpriteBatch batch) {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				Tile tile = tilemap[i][j];
				
				TileContainer tilecont = ServicioTextura.getTileContainer(tile);
				
				tilecont.draw(batch, i*16,j*16);
			}
			
		}
	}
	
}
