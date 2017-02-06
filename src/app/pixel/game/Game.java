package app.pixel.game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import app.pixel.graphics.Render;

public class Game {

	public static void main(String[] args) {
		Render.init();
		try {
			BufferedImage bufferedImage = Render.loadImage("/resources/images/test.png");
			System.out.println(bufferedImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void quit() {
		System.exit(0);
	}
}
