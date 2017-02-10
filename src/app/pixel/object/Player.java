package app.pixel.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.glass.events.KeyEvent;

import app.pixel.input.Input;
import app.pixel.world.World;

public class Player extends Mob {

	private float velocityY = 0;
	private float gravity = 200f;

	public Player(float posX, float posY) {
		super(posX, posY);

		width = 10;
		height = 10;
		runSpeed = 100;
	}

	public void update(float deltaTime) {
		float moveX = 0;
		if (Input.getKey(KeyEvent.VK_LEFT)) {
			moveX -= runSpeed;
		}
		if (Input.getKey(KeyEvent.VK_RIGHT)) {
			moveX += runSpeed;
		}

		velocityY += gravity * deltaTime;

		// Do Collisions
		Rectangle myRect = new Rectangle((int) (posX + moveX * deltaTime - width / 2),
				(int) (posY + velocityY * deltaTime - height / 2), (int) width, (int) height);

		for (Sprite sprite : World.currentWorld.spites) {
			if (sprite == this) {
				continue;
			}

			Rectangle otherRect = new Rectangle((int) (sprite.posX - sprite.width / 2),
					(int) (sprite.posY - sprite.height / 2), (int) sprite.width, (int) sprite.height);
			if (myRect.intersects(otherRect)) {
				moveX -= moveX;
				velocityY -= velocityY;
			}

		}
		// END COLLISIONS

		posX += moveX * deltaTime;
		posY += velocityY * deltaTime;
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect((int) (posX - width / 2), (int) (posY - height / 2), (int) width, (int) height);
	}
}
