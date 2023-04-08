package com.mygdx.pruebafergdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.pruebafergdx.ServicioTextura;

/**
 * 
 * @author Fernando Esra and Michi
 *
 */

public class Main extends ApplicationAdapter {
	SpriteBatch spriteBatch;
	Texture spriteSheet;
	Sprite spriteTest;
	int widthTotal = 300;
	int heigthTotal = 300;
	
	OrthographicCamera orthoCamera;
	
	Map tilemap;
	
	Player player;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		spriteSheet = new Texture("michi_tile_03.png");
		// spriteTest = new Sprite(spriteSheet, 2, 2, 16, 16);
		
		orthoCamera = new OrthographicCamera(480,480);
		// orthoCamera.translate(((heigthTotal/2)*16),((widthTotal/2)*16));
		orthoCamera.position.set(((heigthTotal/2)*16), ((widthTotal/2)*16), 0);
		orthoCamera.update();
		
		ServicioTextura.iniciarTexturas(spriteSheet);
		
		tilemap = new Map(heigthTotal,widthTotal,spriteSheet);
		
		player = new Player((heigthTotal/2),(widthTotal/2));
	}

	@Override
	public void render () {
		// Update
		player.update();
		orthoCamera.position.set(player.x*16, player.y*16, 0);
		orthoCamera.update();

		// Draw
		ScreenUtils.clear(39/256f, 40/256f, 35/256f, 1);
		
		spriteBatch.setProjectionMatrix(orthoCamera.combined);
		spriteBatch.begin();
		tilemap.draw(spriteBatch);
		// spriteTest.draw(spriteBatch);
		
		player.draw(spriteBatch);
		
		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		spriteSheet.dispose();
	}
}
