package com.first.first;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Objects;

public class First extends ApplicationAdapter {
	public static final int SCR_WIDTH = 720;
	public static final int SCR_HEIGHT = 1500;

	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;
	Texture braille;
	TextureRegion[] charBraille = new TextureRegion[26];

	int numberOfChar = 0;

	InputKeyboard keyboard;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		touch = new Vector3();
		braille = new Texture("original.png");
		for (int i = 0; i < charBraille.length; i++) {
			if (i < 10) charBraille[i] = new TextureRegion(braille, (i * 58), 0, 58, 103);
			if (i >= 10 && i < 20) charBraille[i] = new TextureRegion(braille, ((i-10) * 58), 102, 58, 103);
			if (i >= 20 && i < 26) charBraille[i] = new TextureRegion(braille, ((i-20) * 58), 204, 58, 103);
		}

		keyboard = new InputKeyboard(SCR_WIDTH, 650, 1);
	}

	@Override
	public void render () {
		if(Gdx.input.justTouched()) {
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);

			keyboard.endOfEdit(touch.x, touch.y);
		}

		if (Objects.equals(keyboard.text, "a")) numberOfChar = 0;
		if (Objects.equals(keyboard.text, "b")) numberOfChar = 1;
		if (Objects.equals(keyboard.text, "c")) numberOfChar = 2;
		if (Objects.equals(keyboard.text, "d")) numberOfChar = 3;
		if (Objects.equals(keyboard.text, "e")) numberOfChar = 4;
		if (Objects.equals(keyboard.text, "f")) numberOfChar = 5;
		if (Objects.equals(keyboard.text, "g")) numberOfChar = 6;
		if (Objects.equals(keyboard.text, "h")) numberOfChar = 7;
		if (Objects.equals(keyboard.text, "i")) numberOfChar = 8;
		if (Objects.equals(keyboard.text, "j")) numberOfChar = 9;
		if (Objects.equals(keyboard.text, "k")) numberOfChar = 10;
		if (Objects.equals(keyboard.text, "l")) numberOfChar = 11;
		if (Objects.equals(keyboard.text, "m")) numberOfChar = 12;
		if (Objects.equals(keyboard.text, "n")) numberOfChar = 13;
		if (Objects.equals(keyboard.text, "o")) numberOfChar = 14;
		if (Objects.equals(keyboard.text, "p")) numberOfChar = 15;
		if (Objects.equals(keyboard.text, "q")) numberOfChar = 16;
		if (Objects.equals(keyboard.text, "r")) numberOfChar = 17;
		if (Objects.equals(keyboard.text, "s")) numberOfChar = 18;
		if (Objects.equals(keyboard.text, "t")) numberOfChar = 19;
		if (Objects.equals(keyboard.text, "u")) numberOfChar = 20;
		if (Objects.equals(keyboard.text, "v")) numberOfChar = 21;
		if (Objects.equals(keyboard.text, "w")) numberOfChar = 22;
		if (Objects.equals(keyboard.text, "x")) numberOfChar = 23;
		if (Objects.equals(keyboard.text, "y")) numberOfChar = 24;
		if (Objects.equals(keyboard.text, "z")) numberOfChar = 25;
		ScreenUtils.clear(1, 1, 1, 1);
		camera.update();
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		keyboard.draw(batch);
//		for (int i = 0; i < charBraille.length; i++) {
//			if (i < 10) batch.draw(charBraille[i], i*60+10, 700, 50, 50*103/59f);
//			if (i >= 10 && i < 20) batch.draw(charBraille[i], (i-10)*60+10, 600, 50, 50*103/59f);
//			if (i >= 20 && i < 26) batch.draw(charBraille[i], (i-20)*60+10, 500, 50, 50*103/59f);
//		}
		if (!Objects.equals(keyboard.text, "")) batch.draw(charBraille[numberOfChar], SCR_WIDTH/2f-150, 700, 300, 300*103/59f);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
