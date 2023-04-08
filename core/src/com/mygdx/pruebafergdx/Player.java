package com.mygdx.pruebafergdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	
	public int x;
	public int y;
	public Tile tile;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.tile = Tile.PLAYER;
	}
	
	public void update(Map map) {
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

		if(Gdx.input.isKeyJustPressed(Keys.E)) {
			map.interact(this);
		}
	}
	
	public void draw(SpriteBatch batch) {
		Sprite sprite = ServicioTextura.getSprite(tile);
		sprite.setPosition(x*16,y*16);
		sprite.draw(batch);
	}

}
