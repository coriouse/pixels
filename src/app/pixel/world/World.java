package app.pixel.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import app.pixel.graphics.Render;
import app.pixel.object.Sprite;

public class World {

	public static World currentWorld = null;

	private static long lastTime = System.nanoTime();

	public ArrayList<Sprite> spites = new ArrayList<Sprite>();

	private static BufferedImage backdrop = null;

	private static int backdropX = 0;

	public static void update() {

		float deltaTime = (System.nanoTime() - lastTime) / 1000000000.0f;
		lastTime = System.nanoTime();
		for (Sprite sprite : currentWorld.spites) {
			sprite.update(deltaTime);
		}
	}

	public static void render(Graphics g) {
		if (backdrop != null) {
			if (backdropX < Render.camX / 3 - Render.gameWidth) {
				backdropX += Render.gameHeight;
			}

			if (backdropX > Render.camX / 3 + Render.gameWidth) {
				backdropX -= Render.gameWidth;
			}

			int x = backdropX - (int) (Render.camX / 3);
			int bufferX = 0;
			if (backdropX > Render.camX / 3) {
				bufferX = backdropX - Render.gameWidth - (int) (Render.camX / 3);
			} else {
				bufferX = backdropX + Render.gameWidth - (int) (Render.camX / 3);
			}

			g.drawImage(backdrop, x, 0, Render.gameWidth, Render.gameHeight, null);
			g.drawImage(backdrop, bufferX, 0, Render.gameWidth, Render.gameHeight, null);
		} else {
			try {
				backdrop = Render.loadImage("/resources/images/backdrop.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (Sprite sprite : currentWorld.spites) {
			sprite.render(g);
		}
	}

}
