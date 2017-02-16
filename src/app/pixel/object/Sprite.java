package app.pixel.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import app.pixel.graphics.Render;

public class Sprite {

	public float posX = 0;
	public float posY = 0;

	public float width = 0;
	public float height = 0;

	public boolean isSolid = false;

	public BufferedImage image = null;

	public Sprite(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void update(float deltaTime) {
		//
	}

	public void render(Graphics g) {
		if (image == null) {
			return;
		}

		int realX = (int) posX - image.getWidth() / 2;
		int realY = (int) posY - image.getHeight() / 2;

		realX = realX - (int) Render.camX + Render.gameWidth / 2;
		realY = realY - (int) Render.camY + Render.gameHeight / 2;

		g.drawImage(image, realX, realY, image.getWidth(), image.getHeight(), null);
	}

}
