package app.pixel.game;

import app.pixel.graphics.Render;
import app.pixel.object.Platform;
import app.pixel.object.Player;
import app.pixel.world.World;

public class Game {

	public static void main(String[] args) {
		Render.init();

		World.currentWorld = new World();
		World.currentWorld.spites.add(new Player(100, 100));
		World.currentWorld.spites.add(new Platform(200, 200));

	}

	public static void quit() {
		System.exit(0);
	}
}
