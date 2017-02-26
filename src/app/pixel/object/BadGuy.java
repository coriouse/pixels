package app.pixel.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.graphics.Render;
import app.pixel.world.World;

public class BadGuy extends Mob {

	private float velocityY = 0;
	private float gravity = 300f;
	private float jumpHeight = 50;

	private float damage = 10f;

	private int direction = 1; // 1 - left, -1 - right

	public BadGuy(float posX, float posY) {
		super(posX, posY);

		width = 15;
		height = 50;

	}

	public void update(float deltaTime) {
		float moveX = 0;

		moveX += direction * runSpeed;

		velocityY += gravity * deltaTime;
		if (doesCollide(posX, posY + 1)) {
			//
		}

		// Do Collisions
		if (doesCollide(posX + moveX * deltaTime, posY)) {
			moveX -= moveX;
			direction = -direction;
		}

		if (doesCollide(posX, posY + velocityY * deltaTime)) {
			velocityY -= velocityY;
		}
		// END COLLISIONS

		// edge check

		if (!doesCollide(posX + width * direction, posY + 1)) {
			direction = -direction;
		}

		posX += moveX * deltaTime;
		posY += velocityY * deltaTime;

	}

	public void render(Graphics g) {
		int realX = (int) (posX - width / 2);
		int realY = (int) (posY - height / 2);

		realX = realX - (int) Render.camX + Render.gameWidth / 2;
		realY = realY - (int) Render.camY + Render.gameHeight / 2;

		g.setColor(Color.red);
		g.fillRect(realX, realY, (int) width, (int) height);

	}

	public void takeDamage(float damage) {
		World.currentWorld.removeSprite(this);
	}

}
