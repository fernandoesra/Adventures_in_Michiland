package com.mygdx.servicios;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class ServicioTexto {
	
	public static final String FONT_TRUE_TYPE_SOURCE = "fonts/PixeloidSans-JR6qo.ttf";

	private static BitmapFont bitmapFont;

	private ServicioTexto() {

	}

	public static void inicializaFuente() {
		if(bitmapFont != null)bitmapFont.dispose();

		// Load True type font
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_TRUE_TYPE_SOURCE));

		FreeTypeFontGenerator.FreeTypeFontParameter fontGenerationParams = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontGenerationParams.size = 30;
		fontGenerationParams.borderWidth = 1;
		fontGenerationParams.color = Color.YELLOW;
		fontGenerationParams.shadowOffsetX = 3;
		fontGenerationParams.shadowOffsetY = 3;
		fontGenerationParams.shadowColor = Color.BLACK;

		bitmapFont = fontGenerator.generateFont(fontGenerationParams); // font size is 24 pixels
		fontGenerator.dispose(); // Free resources
	}

	public static void dispose() {
		bitmapFont.dispose();
	}

	public static BitmapFont getBitmapFont() {
		return bitmapFont;
	}

}
