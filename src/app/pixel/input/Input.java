package app.pixel.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

	private static boolean[] currentKeys = new boolean[196];

	public static boolean getKey(int keyCode) {
		return currentKeys[keyCode];
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
	//	System.out.println(e.getKeyCode());
		currentKeys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
	//	System.out.println(e.getKeyCode());
		currentKeys[e.getKeyCode()] = false;
	}
}
