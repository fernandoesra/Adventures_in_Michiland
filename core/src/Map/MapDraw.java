package Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pruebafergdx.Minimap;
import com.mygdx.pruebafergdx.Player;
import com.mygdx.pruebafergdx.Tile;
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
		double maxPercent = (WIDTH * HEIGHT) * 0.50;

		double FILL = (Math.random() * maxPercent + minPercent);

		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			
			if (this.practicable(fillWidth, fillHeight)) {
				
				int random = (int) (Math.random() * 91 + 1);
				if (random >= 1 && random <= 10) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_01;
				} else if (random >= 11 && random <= 20) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_02;
				} else if (random >= 21 && random <= 30) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_03;
				} else if (random >= 31 && random <= 40) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_04;
				} else if (random >= 41 && random <= 50) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_05;
				} else if (random >= 51 && random <= 60) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_06;
				} else if (random >= 61 && random <= 70) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_07;
				} else if (random >= 71 && random <= 80) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_08;
				} else if (random >= 81 && random <= 90) {
					tilemap[fillWidth][fillHeight] = Tile.TREE_09;
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
			
			if (this.practicable(fillWidth, fillHeight)) {
				/*
				 * 5 types of normal houses (18% per type)
				 * 2 of big buildings (5% per type)
				 */
				
				int random = (int) (Math.random() * 101 + 1);
				if (random >= 1 && random <= 18) {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_01;
				} else if (random >= 19 && random <= 36) {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_02;
				} else if (random >= 37 && random <= 54) {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_03;
				} else if (random >= 55 && random <= 72) {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_04;
				} else if (random >= 73 && random <= 90) {
					tilemap[fillWidth][fillHeight] = Tile.HOUSE_05;
				} else if (random >= 91 && random <= 95) {
					tilemap[fillWidth][fillHeight] = Tile.BUILDING_01;
				} else if (random >= 96 && random <= 100) {
					tilemap[fillWidth][fillHeight] = Tile.BUILDING_02;
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
			
			if (this.practicable(fillWidth, fillHeight)) {
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
			
			if (this.practicable(fillWidth, fillHeight)) {
				
				int random = (int) (Math.random() * 5 + 1);
				
				if (random == 1) {
					tilemap[fillWidth][fillHeight] = Tile.CAVE_01;
				}
				if (random == 2) {
					tilemap[fillWidth][fillHeight] = Tile.CAVE_02;
				}
				if (random == 3) {
					tilemap[fillWidth][fillHeight] = Tile.CAVE_03;
				}
				if (random == 4) {
					tilemap[fillWidth][fillHeight] = Tile.CAVE_04;
				}
				
			} else {
				i--;
			}

		}
		
		// Generate Mushrooms
		minPercent = WIDTH/150;
		maxPercent = minPercent*2;
		FILL = (Math.random() * maxPercent + minPercent);
		
		for (int i = 0; i < FILL; i++) {
			int fillWidth = (int) (Math.random() * WIDTH + 0);
			int fillHeight = (int) (Math.random() * HEIGHT + 0);
			if (this.practicable(fillWidth, fillHeight)) {

				int random = (int) (Math.random() * 3 + 1);

				if (random == 1) {
					tilemap[fillWidth][fillHeight] = Tile.MUSHROOM_01;
				}
				if (random == 2) {
					tilemap[fillWidth][fillHeight] = Tile.MUSHROOM_02;
				} else {
					i--;
				}
			}
		}

		// Generate X behind the player
		
		tilemap[(WIDTH/2)-1][(HEIGHT/2)] = Tile.CAVE_01;
		
		// Clean the tile for the player
		tilemap[(WIDTH/2)][(HEIGHT/2)] = Tile.EMPTY_01;
		
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
			case CAVE_01:
			case CAVE_02:
			case CAVE_03:
			case CAVE_04:
				if(explomap.getInterior(player.x, player.y) == null) {
					
					explomap.createCave(player.x, player.y);
					String text = ((Cave) explomap.mapExploration[player.x][player.y]).discoverCave();
					System.out.println(text);
					
					double add = ((Cave) explomap.mapExploration[player.x][player.y]).getMoney();
					player.inventory.addMoney(add);
					
				} else {
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				}
				break;
			case HOUSE_01:
			case HOUSE_02:
			case HOUSE_03:
			case HOUSE_04:
			case HOUSE_05:
			case BUILDING_01:
			case BUILDING_02:
				if(explomap.getInterior(player.x, player.y) == null) {
					explomap.createHouse(player.x, player.y);
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				} else {
					System.out.println(explomap.mapExploration[player.x][player.y].toString());
				}
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
	
	public boolean empty(int x, int y) {
		boolean empty = false;
		
		switch (tilemap[x][y]) {
		case EMPTY_01:
		case EMPTY_02:
		case EMPTY_03:
			empty = true;
			break;
		default:
			break;
		}
		return empty;
	}
	
	public boolean practicable(int x, int y) {
		boolean practible = true;
		
		switch (tilemap[x][y]) {
		case OBSTACLE_01:
		case OBSTACLE_02:
		case WATER_01:
		case WATER_02:
		case WATER_03:
		case TREE_01:
		case TREE_02:
		case TREE_03:
		case TREE_04:
		case TREE_05:
		case TREE_06:
		case TREE_07:
		case TREE_08:
		case TREE_09:
			practible = false;
			break;
		default:
			break;
		}
		
		return practible;
	}
	
}
