package app.pixel.game;


import app.pixel.graphics.Render;
import app.pixel.test.TestSprite;
import app.pixel.world.World;

public class Game {

	public static void main(String[] args) {
		Render.init();

		World.currentWorld = new World();
		World.currentWorld.spites.add(new TestSprite(100, 100));

	}

	public static void quit() {
		System.exit(0);
	}
}
