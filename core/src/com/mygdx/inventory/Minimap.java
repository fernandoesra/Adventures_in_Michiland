package com.mygdx.inventory;


import com.badlogic.gdx.math.Vector2;
import com.mygdx.pruebafergdx.Tile;
import com.mygdx.utils.ConsoleColors;

import Map.MapDraw;

public class Minimap {
	
	// Esto necesita una refactorizacion muy bestia, para empezar usa 'x' e 'y' en los for cuando te refieras a coordenadas en los mapas
	// Ademas no has seguido le mismo sistema que has usado para el mapa normal
	// Ya que esto esta en una clase diferente, implementa el objeto Minimap con su witdh y height, y quizas algun metodo mas para referirte a las coordeanas del mapa normal
	// o directamente haz metodos para escribir en el mapa con coordenadas del normal, lo que mas te guste
	// Ademas MapDraw de por si tiene width y height

	public static void seeMinimap(MapDraw map, int playerX, int playerY) {
		
		Tile[][] tilemap = map.tilemap;
		char playerIcon = (char)1146;
		char caveIcon = (char)1126;
		char objetiveIcon = (char)1131;
		
		
		
		// First write the minimap
		int realWidth = tilemap.length;
		int realHeigth = tilemap[0].length;

		int miniHeigth = realHeigth/10;
		int miniWidth = (realWidth/10)*2;
		
		char[][] minimap = new char[miniWidth][miniHeigth];
		
		
		for (int i = 0; i < miniWidth; i++) {
			for (int j = 0; j < miniHeigth; j++) {
				minimap[i][j] = ' ';
			}
		}
		
		for (int i = 0; i < realWidth; i++) {
			for (int j = 0; j < realHeigth; j++) {
				if (tilemap[i][j] == Tile.CAVE_01) {
					Vector2 coordsMinimap = getCoordinaetsOnMinimap(map, i, j);
					minimap[(int)coordsMinimap.x][(int)coordsMinimap.y] = caveIcon;
				}
				if (tilemap[i][j] == Tile.MAN) {
					Vector2 coordsMinimap = getCoordinaetsOnMinimap(map, i, j);
					minimap[(int)coordsMinimap.x][(int)coordsMinimap.y] = objetiveIcon;
				}
			}
		}
		
		// Always write the player at finish
		
		Vector2 playerCoordsMinimap = getCoordinaetsOnMinimap(map, playerX, playerY);
		minimap[(int)playerCoordsMinimap.x][(int)playerCoordsMinimap.y] = playerIcon;
		
		// Then draw the minimap
		for (int j = 0; j < miniHeigth; j++) {
			
			
			if (j == 0) {
				System.out.print("|");
				for (int i = 0; i < miniWidth; i++) {
					System.out.print("-");
				}
				System.out.println("|");
				
				System.out.print("|");
				for (int i = 0; i < (miniWidth/2)-5; i++) {
					System.out.print(" ");
				}
				System.out.print(ConsoleColors.YELLOW_BOLD+"MICHILAND"+ConsoleColors.RESET);
				for (int i = 0; i < (miniWidth/2)-5; i++) {
					System.out.print(" ");
				}
				System.out.println(" |");
				
				System.out.print("|");
				for (int i = 0; i < miniWidth; i++) {
					System.out.print("-");
				}
				System.out.println("|");
			}
			
			System.out.print("|");
			for (int i = 0; i < miniWidth; i++) {
				if (minimap[i][j] == playerIcon) {
					System.out.print(ConsoleColors.RED_BOLD_BRIGHT+playerIcon+ConsoleColors.RESET);
				} else if (minimap[i][j] == objetiveIcon) {
					System.out.print(ConsoleColors.BLUE_BRIGHT+objetiveIcon+ConsoleColors.RESET);
				} else {
					System.out.print(minimap[i][j]);
				}
				
			}
			System.out.print("|");
			
			if (j == 1) {
				System.out.print("            "+(char)9650);
			}
			if (j == 2) {
				System.out.print("            N");
			}
			if (j == 3) {
				System.out.print("        "+(char)9664+" S "+(char)10022+" E "+(char)9654);
			}
			if (j == 4) {
				System.out.print("            W");
			}
			if (j == 5) {
				System.out.print("            "+(char)9660);
			}
			if (j == 7) {
				System.out.print("   --------------------");
			}
			if (j == 8) {
				System.out.print("   | Legend           |");
			}
			if (j == 9) {
				System.out.print("   |                  |");
			}
			if (j == 10) {
				System.out.print("   | "+caveIcon+": Cave          |");
			}
			if (j == 11) {
				System.out.print("   | "+ConsoleColors.BLUE_BRIGHT+objetiveIcon+ConsoleColors.RESET+": Objetive      |");
			}
			if (j == 12) {
				System.out.print("   | "+ConsoleColors.RED_BOLD_BRIGHT+playerIcon+ConsoleColors.RESET+": You           |");
			}
			if (j == 13) {
				System.out.print("   |                  |");
			}
			if (j == 14) {
				System.out.print("   --------------------");
			}
			
			System.out.println();
			
			if (j == miniHeigth-1) {
				System.out.print("|");
				for (int i = 0; i < miniWidth; i++) {
					System.out.print("-");
				}
				System.out.println("|");
			}
		}
		
		minimap = null;
	}

	public static Vector2 getCoordinaetsOnMinimap(MapDraw map, int xMap, int yMap) {
		int realHeigth = map.tilemap.length;

		int miniHeigth = realHeigth/10;
		
		int x = (xMap/10)*2;
		int y = (miniHeigth-1) - (yMap/10);
		return new Vector2(x, y);
	}
	

}
