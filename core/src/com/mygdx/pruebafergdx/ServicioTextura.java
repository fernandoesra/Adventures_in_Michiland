package com.mygdx.pruebafergdx;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class ServicioTextura {
	private static HashMap<Tile, TileContainer> TILE_CONTAINER_MAP;
	
	private ServicioTextura() {
	};
	
	public static void iniciarTexturas(Texture spriteSheet) {
		TILE_CONTAINER_MAP = new HashMap<Tile, TileContainer>();
		TILE_CONTAINER_MAP.put(Tile.EMPTY, new TileContainer(Tile.EMPTY, 144, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.TREE_01, new TileContainer(Tile.TREE_01, 57, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.TREE_02, new TileContainer(Tile.TREE_02, 1, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.TREE_03, new TileContainer(Tile.TREE_03, 93, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.HOUSE_01, new TileContainer(Tile.HOUSE_01, 19, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.HOUSE_02, new TileContainer(Tile.HOUSE_02, 37, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.HOUSE_03, new TileContainer(Tile.HOUSE_03, 111, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.CAVE, new TileContainer(Tile.CAVE, 75, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.MAN, new TileContainer(Tile.MAN, 127, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.PLAYER, new TileContainer(Tile.PLAYER, 127, 1, spriteSheet));
	}
	
	public static TileContainer getTileContainer(Tile tile) {
		return TILE_CONTAINER_MAP.get(tile);
	}

}
