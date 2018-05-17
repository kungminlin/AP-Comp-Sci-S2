package gameEntities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

public class Bullet {
	public static final int SIZE = 5;
	private int x;
	private int y;
	private int speed;
	private boolean positiveDirection;
	private Ellipse2D collider;
	
	public Bullet(int x, int y, int speed, boolean positiveDirection) {
		this.x = x;
		this.y = y+17;
		this.speed = speed;
		this.positiveDirection = positiveDirection;
		collider = new Ellipse2D.Double(x, y, SIZE, SIZE);
	}
	
	public void move() {
		if (positiveDirection) {
			x+=speed;
		} else {
			x-=speed;
		}
		collider.setFrame(x, y, SIZE, SIZE);
	}
	
	public int getX() {
		return x;
	}
	
	public Ellipse2D getCollider() {
		return collider;
	}
	
	public void draw(Graphics g) {
		move();
		g.setColor(Color.BLACK);
		g.drawOval(x, y, SIZE, SIZE);
		g.fillOval(x, y, SIZE, SIZE);
	}
}
