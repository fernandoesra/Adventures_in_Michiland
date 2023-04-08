package com.mygdx.pruebafergdx;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class ServicioTextura {
	private static HashMap<Tile, TileContainer> TILE_CONTAINER_MAP;
	
	private ServicioTextura() {
	};
	
	public static void iniciarTexturas(Texture spriteSheet) {
		TILE_CONTAINER_MAP = new HashMap<Tile, TileContainer>();
		TILE_CONTAINER_MAP.put(Tile.TREE, new TileContainer(Tile.TREE, 2, 2, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.HOUSE, new TileContainer(Tile.HOUSE, 20, 2, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.MAN, new TileContainer(Tile.MAN, 38, 2, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.CAVE, new TileContainer(Tile.CAVE, 56, 2, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.EMPTY, new TileContainer(Tile.EMPTY, 74, 2, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.PLAYER, new TileContainer(Tile.PLAYER, 92, 2, spriteSheet));
	}
	
	public static TileContainer getTileContainer(Tile tile) {
		return TILE_CONTAINER_MAP.get(tile);
	}

}
