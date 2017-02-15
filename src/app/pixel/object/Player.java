package app.pixel.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.glass.events.KeyEvent;

import app.pixel.input.Input;
import app.pixel.world.World;

public class Player extends Mob {

	private float velocityY = 0;
	private float gravity = 300f;
	private float jumpHeight = 50;

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
			System.out.println(moveX);
		}
		if (Input.getKey(KeyEvent.VK_RIGHT)) {
			moveX += runSpeed;
		}

		velocityY += gravity * deltaTime;
		if(doesCollide(posX, posY+1)) {
			if (Input.getKeyDown(KeyEvent.VK_UP)) {
				velocityY = (float) -Math.sqrt(2 * jumpHeight * gravity);
			}
		}
		// Do Collisions
		if (doesCollide(posX + moveX * deltaTime, posY)) {
			moveX -= moveX;
		}

		if (doesCollide(posX, posY + velocityY * deltaTime)) {
			velocityY -= velocityY;
		}

		// END COLLISIONS

		posX += moveX * deltaTime;
		posY += velocityY * deltaTime;
	}

	private boolean doesCollide(float x, float y) {

		float myLeft = x - width / 2;
		float myRight = x + width / 2;
		float myUp = y - height / 2;
		float myDown = y + height / 2;

		for (Sprite sprite : World.currentWorld.spites) {

			if (sprite == this) {
				continue;
			}
			float otherLeft = sprite.posX - sprite.width / 2;
			float otherRight = sprite.posX + sprite.width / 2;
			float otherUp = sprite.posY - sprite.height / 2;
			float otherDown = sprite.posY + sprite.height / 2;

			if (myLeft < otherRight && myRight > otherLeft && myDown > otherUp && myUp < otherDown) {
				return true;
			}
		}

		return false;

	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect((int) (posX - width / 2), (int) (posY - height / 2), (int) width, (int) height);
	}
}
