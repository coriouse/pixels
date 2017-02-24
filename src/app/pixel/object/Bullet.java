package app.pixel.object;

import java.io.IOException;

import app.pixel.graphics.Animation;
import app.pixel.graphics.Render;

public class Bullet extends Sprite {

	public int direction = 1;// -1  = left, 1 = right

	public float speed = 400.0f;

	public float damage = 10.0f;

	public Bullet(float posX, float posY, int direction) {
		super(posX, posY);
		this.direction = direction;
		width = 10;
		height = 10;
		isSolid = false;

		Animation anim = new Animation();

		try {
			anim.images.add(Render.loadImage("/resources/images/bullet_0.png"));
			anim.images.add(Render.loadImage("/resources/images/bullet_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Animation anim2 = new Animation();

		try {
			anim2.images.add(Render.loadImage("/resources/images/bullet_0_left.png"));
			anim2.images.add(Render.loadImage("/resources/images/bullet_1_right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		animations = new Animation[] { anim, anim2 };

	}

	public void update(float deltaTime) {
		float moveX = 0;

		moveX += speed * direction;

		posX += moveX * deltaTime;
		
		
		//direction
		if(direction > 0) {
			currentAnimation = 0;
		}
		
		if(direction < 0) {
			currentAnimation = 1;
		}

	}

}
