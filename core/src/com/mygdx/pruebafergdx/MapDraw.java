package com.mygdx.pruebafergdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.servicios.ServicioTextura;
import com.mygdx.tiles.Cave;

public class MapDraw {
	private int WIDTH;
	private int HEIGHT;
	private Tile tilemap[][];
	private MapExploration explomap;
	
	public MapDraw(int WIDTH, int HEIGHT, Texture spriteSheet) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
				
		tilemap = new Tile[WIDTH][HEIGHT];
		explomap = new MapExploration(WIDTH,HEIGHT);
		
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {				
				
				int random = (int) (Math.random() * 101 + 1);
				
				if (random >= 1 && random <= 70) {
					tilemap[i][j] = Tile.EMPTY_01;
				} else if (random >= 71 && random <= 90) {
					tilemap[i][j] = Tile.EMPTY_02;
				} else {
					tilemap[i][j] = Tile.EMPTY_03;
				}
				
			}
			
		}
		
		// Generate TREE
		double minPercent = (WIDTH * HEIGHT) * 0.05;
		double maxPercent = (WIDTH * HEIGHT) * 0.60;

		double FILL = (Math.random() * maxPercent + minPercent);

		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY_01 || tilemap[fillWidth][fillHeight] == Tile.EMPTY_02
					|| tilemap[fillWidth][fillHeight] == Tile.EMPTY_03) {
				int random = (int) (Math.random() * 101 + 1);
				if (random >= 1 && random <= 50) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_01;
				} else if (random >= 51 && random <= 90) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_02;
				} else {
					tilemap[fillWidth][fillHeight] = Tile.TREE_03;
				}
			} else {
				i--;
			}
			
		}
		
		// Generate HOUSE
		minPercent = WIDTH/10;
		maxPercent = minPercent*2;
		FILL = (Math.random() * maxPercent + minPercent);
		
		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY_01 || tilemap[fillWidth][fillHeight] == Tile.EMPTY_02
					|| tilemap[fillWidth][fillHeight] == Tile.EMPTY_03) {
				int random = (int) (Math.random() * 101 + 1);
				if (random >= 1 && random <= 40) {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_01;
				} else if (random >= 41 && random <= 70) {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_02;
				} else {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_03;
				}
			} else {
				i--;
			}
			
		}
		
		// Generate MAN
		
		minPercent = WIDTH/20;
		maxPercent = minPercent*2;
		FILL = (Math.random() * maxPercent + minPercent);
		
		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY_01 || tilemap[fillWidth][fillHeight] == Tile.EMPTY_02
					|| tilemap[fillWidth][fillHeight] == Tile.EMPTY_03) {
				tilemap[fillWidth][fillHeight] = Tile.MAN;
			} else {
				i--;
			}
			
		}
		
		// Generate CAVE
		
		minPercent = WIDTH/100;
		maxPercent = minPercent*10;
		FILL = (Math.random() * maxPercent + minPercent);
		
		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (tilemap[fillWidth][fillHeight] == Tile.EMPTY_01 || tilemap[fillWidth][fillHeight] == Tile.EMPTY_02
					|| tilemap[fillWidth][fillHeight] == Tile.EMPTY_03) {
				tilemap[fillWidth][fillHeight] = Tile.CAVE;
			} else {
				i--;
			}
			
		}
		
		// Generate X behind the player
		
		tilemap[(WIDTH/2)-1][(HEIGHT/2)] = Tile.CAVE;
		

	}
	
	public void draw(SpriteBatch batch) {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				Tile tile = tilemap[i][j];
				
				Sprite sprite = ServicioTextura.getSprite(tile);
				sprite.setPosition(i*16,j*16);
				sprite.draw(batch);
			}
			
		}
	}

	public void interact(Player player) {
		Tile tile = tilemap[player.x][player.y];

		switch(tile) {
			case CAVE:
				if(explomap.getInterior(player.x, player.y) == null) {
					explomap.createCave(player.x, player.y);
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
					
					double add = ((Cave) explomap.mapExploration[player.x][player.y]).getMoney();
					player.inventory.addMoney(add);
					
				} else {
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				}
				break;
			case HOUSE_01:
			case HOUSE_02:
			case HOUSE_03:
				if(explomap.getInterior(player.x, player.y) == null) {
					explomap.createHouse(player.x, player.y);
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				} else {
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				}
				break;
			case TREE_01:
			case TREE_02:
			case TREE_03:
				System.out.println("Just a tree");
				break;
			case MAN:
				if(explomap.getInterior(player.x, player.y) == null) {
					explomap.createMan(player.x, player.y);
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				} else {
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				}
				break;
			default:
				break;
		}
	}
	
	public boolean practicable(int x, int y) {
		boolean practible = true;
		
		switch (tilemap[x][y]) {
		case TREE_01:
			practible = false;
			break;
		case TREE_02:
			practible = false;
			break;
		case TREE_03:
			practible = false;
			break;
		default:
			break;
		}
		
		return practible;
	}
	
}
