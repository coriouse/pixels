package app.pixel.object;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Sprite {

	public int direction = 0;// 0 = left, 1 = right
	
	public float speed = 400.0f;
	
	public float damage = 10.0f;

	public Bullet(float posX, float posY, int direction) {
		super(posX, posY);
		this.direction = direction;
	    width = 10;
	    height = 10;
		
	
	}

	public void update(float deltaTime) {
		float moveX = 0;
		if(direction == 0) {
			moveX -= speed;
		} else {
			moveX += speed;
		}
		
		posX += moveX * deltaTime; 
		
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int) (posX - width / 2), (int) (posY - height / 2), (int)width, (int)height);

	}
}
