package app.pixel.world;

import java.awt.Graphics;
import java.util.ArrayList;

import app.pixel.object.Sprite;

public class World {

	public static World currentWorld = null;

	private static long lastTime = System.nanoTime();

	public ArrayList<Sprite> spites = new ArrayList<Sprite>();

	public static void update() {

		float deltaTime = (System.nanoTime() - lastTime) / 1000000000.0f;
		lastTime = System.nanoTime();
		for (Sprite sprite : currentWorld.spites) {
			sprite.update(deltaTime);
		}
	}

	public static void render(Graphics g) {
		for (Sprite sprite : currentWorld.spites) {
			sprite.render(g);
		}
	}

}
