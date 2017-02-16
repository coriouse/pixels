package app.pixel.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.graphics.Render;

public class Platform extends Sprite {

	public Platform(float posX, float posY) {
		super(posX, posY);

		width = 300;
		height = 50;

	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect((int) (posX - width / 2) - (int) Render.camX + Render.gameWidth / 2,
				(int) (posY - height / 2) - (int) Render.camY + Render.gameHeight / 2, (int) width, (int) height);
	}

}
