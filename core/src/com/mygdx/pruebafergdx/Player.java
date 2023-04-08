package com.mygdx.pruebafergdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
		if(Gdx.input.isKeyJustPressed(Keys.A)) {
            this.x -= 1;
        }
        if(Gdx.input.isKeyJustPressed(Keys.S)) {
            this.y -= 1;
        }
        if(Gdx.input.isKeyJustPressed(Keys.D)) {
            this.x += 1;
        }
        if(Gdx.input.isKeyJustPressed(Keys.W)) {
            this.y += 1;
        }
	}
	
	public void draw(SpriteBatch batch) {
		TileContainer tileCon = ServicioTextura.getTileContainer(tile);
		tileCon.draw(batch, x*16, y*16);
	}

}
