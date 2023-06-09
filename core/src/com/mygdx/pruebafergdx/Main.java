package com.mygdx.pruebafergdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.servicios.ServicioRandGen;
import com.mygdx.servicios.ServicioTexto;
import com.mygdx.servicios.ServicioTextura;

import Map.MapDraw;

/**
 * 
 * @author 	Code: 	Fernando Esra and Michael Valwin
 * 			Tiles:	miriamramosart on Instagram
 *
 */

public class Main extends ApplicationAdapter {
	SpriteBatch spriteBatch;
	Texture spriteSheet;
	Sprite spriteTest;
	int widthTotal = 300;
	int heigthTotal = 300;
	
	OrthographicCamera orthoCamera;
	
	MapDraw tilemap;
	
	Player player;
	
	@Override
	public void create () {
		ServicioRandGen.init();
		ServicioTexto.inicializaFuente();

		spriteBatch = new SpriteBatch();
		spriteSheet = new Texture("tile_michi_outside.png");
		
		ServicioTextura.iniciarTexturas(spriteSheet);
		
		tilemap = new MapDraw(heigthTotal,widthTotal,spriteSheet);
		
		player = new Player((heigthTotal/2),(widthTotal/2));

		orthoCamera = new OrthographicCamera(480,480);
		orthoCamera.position.set(player.x*16, player.y*16, 0);
		orthoCamera.update();
	}

	@Override
	public void render () {
		// Update
		player.update(tilemap);
		orthoCamera.position.set(player.x*16, player.y*16, 0);
		orthoCamera.update();
		

		// Draw
		ScreenUtils.clear(39/256f, 40/256f, 35/256f, 1);
		
		spriteBatch.setProjectionMatrix(orthoCamera.combined);
		spriteBatch.begin();

		tilemap.draw(spriteBatch);
		player.draw(spriteBatch);

		// Test to draw some text
		// ServicioTexto.getBitmapFont().draw(spriteBatch, "Hello", player.x*16,player.y*16, 0, 0, false);
		
		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		spriteSheet.dispose();
	}
}
