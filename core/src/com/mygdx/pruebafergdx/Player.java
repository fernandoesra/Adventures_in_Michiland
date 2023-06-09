package com.mygdx.pruebafergdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.inventory.Inventory;
import com.mygdx.servicios.ServicioTextura;

import Map.MapDraw;

public class Player {
	
	public int x;
	public int y;
	public Tile tile;
	public Inventory inventory;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.tile = Tile.PLAYER;
		this.inventory = new Inventory(x,y);
	}
	
	public void update(MapDraw map) {
		if(Gdx.input.isKeyJustPressed(Keys.A)) {
			if (map.practicable(x-1, y) == true) {
				this.x -= 1;
			} else {
				
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.S)) {
			if (map.practicable(x, y-1) == true) {
				this.y -= 1;
			} else {
				
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.D)) {
			if (map.practicable(x+1, y) == true) {
				this.x += 1;
			} else {
				
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.W)) {
			if (map.practicable(x, y+1) == true) {
				this.y += 1;
			} else {
				
			}
		}

		if(Gdx.input.isKeyJustPressed(Keys.E)) {
			map.interact(this);
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.I)) {
			System.out.println(inventory.toString());
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.M)) {
			inventory.seeMap(map,x,y);
		}
	}
	
	public void addMoney(double add) {
		inventory.addMoney(add);
	}
	
	public void draw(SpriteBatch batch) {
		Sprite sprite = ServicioTextura.getSprite(tile);
		sprite.setPosition(x*16,y*16);
		sprite.draw(batch);
	}

}
