package app.pixel.graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.pixel.game.Game;

public class Render {

	
	private static Frame frame;
	private static Canvas canvas;
	
	private static int canvasWidth = 0;
	private static int canvasHeight = 0;
			
	private static int GAME_WIDTH = 400;
	private static int GAME_HEIGHT = 250;
	
	private static int gameWidth = 0;
	private static int gameHeight = 0;
	
	
	private static void getBestSize() {
			
	}
	
	public static void init() {
		getBestSize();
		
		frame = new Frame();
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		frame.add(canvas);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				Game.quit();
			}
		});		
		frame.setVisible(true);
		
	}
}
