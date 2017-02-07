package app.pixel.test;

import java.io.IOException;

import app.pixel.graphics.Render;
import app.pixel.object.Sprite;

public class TestSprite extends Sprite {

	public TestSprite(float posX, float posY) {
		super(posX, posY);

		try {
			image = Render.loadImage("/resources/images/test.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(float deltaTime) {
		posX += 10 * deltaTime;
	}

}
