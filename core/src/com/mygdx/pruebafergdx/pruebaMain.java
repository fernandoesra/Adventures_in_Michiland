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

public class pruebaMain extends ApplicationAdapter {
	SpriteBatch spriteBatch;
	Texture spriteSheet;
	Sprite spriteTest;
	
	OrthographicCamera orthoCamera;
	
	Map tilemap;
	
	Player player;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		spriteSheet = new Texture("main_tiles.png");
		// spriteTest = new Sprite(spriteSheet, 2, 2, 16, 16);
		
		orthoCamera = new OrthographicCamera(480,480);
		orthoCamera.translate(480/2,480/2);
		orthoCamera.update();
		
		ServicioTextura.iniciarTexturas(spriteSheet);
		
		tilemap = new Map(40,40,spriteSheet);
		
		player = new Player(0,0);
	}

	@Override
	public void render () {
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
