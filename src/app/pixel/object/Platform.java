package app.pixel.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.graphics.Render;

public class Platform extends Sprite {

	public Platform(float posX, float posY, float width, float height) {
		super(posX, posY);

		this.width = width;
		this.height = height;

	}

	public void render(Graphics g) {
		g.setColor(new Color(110, 70, 40));
		g.fillRect((int) (posX - width / 2) - (int) Render.camX + Render.gameWidth / 2,
				(int) (posY - height / 2) - (int) Render.camY + Render.gameHeight / 2, (int) width, (int) height);
	}

}
