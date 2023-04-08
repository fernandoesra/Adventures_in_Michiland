package com.mygdx.servicios;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.pruebafergdx.Tile;

public class ServicioTextura {
	private static HashMap<Tile, Sprite> TILE_SPRITE_MAP;
	
	private final static int WIDTH = 16;
	private final static int HEIGHT = 16;

	private ServicioTextura() {
	};
	
	public static void iniciarTexturas(Texture spriteSheet) {
		
		TILE_SPRITE_MAP = new HashMap<Tile, Sprite>();
		
		TILE_SPRITE_MAP.put(Tile.CAVE, new Sprite(spriteSheet, 91, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.EMPTY_01, new Sprite(spriteSheet, 199, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.EMPTY_02, new Sprite(spriteSheet, 37, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.EMPTY_03, new Sprite(spriteSheet, 109, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.MAN, new Sprite(spriteSheet, 181, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.PLAYER, new Sprite(spriteSheet, 163, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.TREE_01, new Sprite(spriteSheet, 1, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.TREE_02, new Sprite(spriteSheet, 73, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.TREE_03, new Sprite(spriteSheet, 127, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.HOUSE_01, new Sprite(spriteSheet, 19, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.HOUSE_02, new Sprite(spriteSheet, 55, 1, WIDTH, HEIGHT));
		TILE_SPRITE_MAP.put(Tile.HOUSE_03, new Sprite(spriteSheet, 145, 1, WIDTH, HEIGHT));

		// TODO: replace this for an actual loading atlas
		Set<Tile> AllTiles = EnumSet.allOf(Tile.class);
		Iterator<Tile> iter = AllTiles.iterator();
		while(iter.hasNext()) {
			Enum<Tile> tile = iter.next();
			if(!TILE_SPRITE_MAP.keySet().contains(tile)) {
				System.err.println("TILE: " + tile + " is not in hashMap tile Container");
			}
		}		

	}

	public static Sprite getSprite(Tile tile) {
		return TILE_SPRITE_MAP.get(tile);
	}

}
