package com.mygdx.pruebafergdx;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class ServicioTextura {
	private static HashMap<Tile, TileContainer> TILE_CONTAINER_MAP;
	
	private ServicioTextura() {
	};
	
	public static void iniciarTexturas(Texture spriteSheet) {
		TILE_CONTAINER_MAP = new HashMap<Tile, TileContainer>();
		TILE_CONTAINER_MAP.put(Tile.CAVE, new TileContainer(Tile.CAVE, 91, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.EMPTY_01, new TileContainer(Tile.EMPTY_01, 199, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.EMPTY_02, new TileContainer(Tile.EMPTY_02, 37, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.EMPTY_03, new TileContainer(Tile.EMPTY_03, 109, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.MAN, new TileContainer(Tile.MAN, 181, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.PLAYER, new TileContainer(Tile.PLAYER, 163, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.TREE_01, new TileContainer(Tile.TREE_01, 1, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.TREE_02, new TileContainer(Tile.TREE_02, 73, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.TREE_02, new TileContainer(Tile.TREE_03, 127, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.HOUSE_01, new TileContainer(Tile.HOUSE_01, 19, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.HOUSE_02, new TileContainer(Tile.HOUSE_02, 55, 1, spriteSheet));
		TILE_CONTAINER_MAP.put(Tile.HOUSE_02, new TileContainer(Tile.HOUSE_03, 145, 1, spriteSheet));
		
	
	}
	
	public static TileContainer getTileContainer(Tile tile) {
		return TILE_CONTAINER_MAP.get(tile);
	}

}
