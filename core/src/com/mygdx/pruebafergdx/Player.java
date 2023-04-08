package com.mygdx.pruebafergdx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	
	public int x;
	public int y;
	public Tile tile;
	
	private static final float SPEED_MOVING = 110;
	
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.tile = Tile.PLAYER;
	}
	
	public void update() {
		
	}
	
	public void draw(SpriteBatch batch) {
		TileContainer tileCon = ServicioTextura.getTileContainer(tile);
		tileCon.draw(batch, x, y);
	}

}
