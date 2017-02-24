package app.pixel.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import app.pixel.graphics.Animation;
import app.pixel.graphics.Render;
import app.pixel.world.World;

public class Sprite {

	public float posX = 0;
	public float posY = 0;

	public float width = 0;
	public float height = 0;

	public boolean isSolid = true;

	public Animation[] animations;
	public int currentAnimation = 0;

	public Sprite(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void update(float deltaTime) {
		//
	}

	public void render(Graphics g) {
		if (animations == null || currentAnimation >= animations.length) {
			return;
		}
		animations[currentAnimation].playAnimation();

		BufferedImage image = animations[currentAnimation].getImage();

		if (image == null) {
			return;
		}

		int realX = (int) posX - image.getWidth() / 2;
		int realY = (int) posY - image.getHeight() / 2;

		realX = realX - (int) Render.camX + Render.gameWidth / 2;
		realY = realY - (int) Render.camY + Render.gameHeight / 2;

		g.drawImage(image, realX, realY, image.getWidth(), image.getHeight(), null);
	}
	
	protected boolean doesCollide(float x, float y) {

		float myLeft = x - width / 2;
		float myRight = x + width / 2;
		float myUp = y - height / 2;
		float myDown = y + height / 2;

		for (Sprite sprite : World.currentWorld.spites) {

			if (sprite == this || !sprite.isSolid) {
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

}
