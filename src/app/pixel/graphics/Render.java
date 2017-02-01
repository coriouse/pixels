package app.pixel.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.VolatileImage;

import app.pixel.game.Game;

public class Render {

	private static Frame frame;
	private static Canvas canvas;

	private static int canvasWidth = 0;
	private static int canvasHeight = 0;

	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 250;

	private static int gameWidth = 0;
	private static int gameHeight = 0;
	
	private static long lastFpsChecked = 0;
	private static int currentFPS = 0;
	private static int totalFrames = 0;

	private static void getBestSize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		boolean done = false;

		while (!done) {
			canvasWidth += GAME_WIDTH;
			canvasHeight += GAME_HEIGHT;
			if (canvasWidth > screenSize.width || canvasHeight > screenSize.width) {
				canvasWidth -= GAME_WIDTH;
				canvasHeight -= GAME_HEIGHT;
				done = true;
			}
		}

		int xDiff = screenSize.width - canvasWidth;
		int yDiff = screenSize.height - canvasHeight;
		int factor = canvasWidth / GAME_WIDTH;

		gameWidth = canvasWidth / factor + xDiff / factor;
		gameHeight = canvasHeight / factor + yDiff / factor;

		canvasWidth = gameWidth + factor;
		canvasHeight = gameHeight + factor;

	}

	private static void makeFullScreen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = env.getDefaultScreenDevice();
		if (gd.isFullScreenSupported()) {
			frame.setUndecorated(true);
			gd.setFullScreenWindow(frame);
		}

	}

	public static void init() {
		getBestSize();

		frame = new Frame();
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		frame.add(canvas);
		// makeFullScreen();
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Game.quit();
			}
		});
		frame.setVisible(true);

		startRendering();

	}

	private static void startRendering() {
		Thread thread = new Thread() {
			public void run() {
				GraphicsConfiguration gc = canvas.getGraphicsConfiguration();
				VolatileImage vImage = gc.createCompatibleVolatileImage(gameWidth, gameHeight);
				while (true) {
					totalFrames ++;
					//FPS counter
					if(System.nanoTime() > lastFpsChecked + 1000000000) {
						lastFpsChecked = System.nanoTime();
						currentFPS = totalFrames;
						totalFrames = 0;
					
					}
					
					
					if (vImage.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE) {
						vImage = gc.createCompatibleVolatileImage(gameWidth, gameHeight);
					}
					
					Graphics g = vImage.getGraphics();
					g.setColor(Color.black);					
					g.fillRect(0, 0, gameWidth, gameHeight);
				
					//RENDER STUFF
					
					//Draw FPS counter
					g.setColor(Color.red);
					g.drawString(String.valueOf(currentFPS), 2, gameHeight-2);
					
					g.dispose();
					g = canvas.getGraphics();
					g.drawImage(vImage, 0, 0, canvasWidth, canvasHeight, null); 
				
				}
			}

		};

		thread.setName("Rendering thread");
		thread.start();
	}
}
