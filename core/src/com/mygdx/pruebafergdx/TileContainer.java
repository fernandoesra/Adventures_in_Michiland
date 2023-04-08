package com.mygdx.pruebafergdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileContainer {
	private Tile tile;
	private int textRegionX, textRegionY;
	private Texture spriteSheet;
	private final static int WIDTH = 16;
	private final static int HEIGHT = 16;
	
	private Sprite sprite;

	public TileContainer(Tile tile, int textRegionX, int textRegionY, Texture spriteSheet) {
		this.tile = tile;
		this.textRegionX = textRegionX;
		this.textRegionY = textRegionY;
		this.spriteSheet = spriteSheet;
		
		this.sprite = new Sprite(spriteSheet, textRegionX, textRegionY, WIDTH, HEIGHT);
	}
	
	public void draw(SpriteBatch batch, int x, int y) {
		sprite.setPosition(x,y);
		sprite.draw(batch);
	}
	
	
}
