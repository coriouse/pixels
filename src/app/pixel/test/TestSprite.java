package app.pixel.test;

import java.io.IOException;

import com.sun.glass.events.KeyEvent;

import app.pixel.graphics.Render;
import app.pixel.input.Input;
import app.pixel.object.Sprite;

public class TestSprite extends Sprite {

	public TestSprite(float posX, float posY) {
		super(posX, posY);

		/*try {
			image = Render.loadImage("/resources/images/test.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}

	public void update(float deltaTime) {


		if (Input.getKey(KeyEvent.VK_W)) {
			posY -= 80 * deltaTime;			
		}
		
		if (Input.getKey(KeyEvent.VK_S)) {
			posY += 80 * deltaTime;
		}
		
		if (Input.getKey(KeyEvent.VK_A)) {
			posX -= 80 * deltaTime;
		}
		
		if (Input.getKey(KeyEvent.VK_D)) {
			posX += 80 * deltaTime;
		}
	}

}
