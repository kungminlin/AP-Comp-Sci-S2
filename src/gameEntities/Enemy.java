package gameEntities;
import java.awt.*;

public class Enemy {
	private static final int SIZE = 40;
	
	private double x;
	private double y;
	private double velX;
	private double velY;
	
	private Rectangle collider;
	
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		collider = new Rectangle(getX(), getY(), SIZE, SIZE);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(getX(), getY(), SIZE, SIZE);
		g.fillRect(getX(), getY(), SIZE, SIZE);
	}
	
	public void move() {
		x+=velX;
		y-=velY;
		collider = new Rectangle(getX(), getY(), SIZE, SIZE);
	}
	
	public int getX() { return (int)Math.round(x); }
	public int getY() { return (int)Math.round(y); }
	public double getXPos() { return x; }
	public double getYPos() { return y; }
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	
	public double getVelX() { return velX; }
	public double getVelY() { return velY; }
	public void setVelX(double velX) { this.velX = velX; }
	public void setVelY(double velY) { this.velY = velY; }
	
	public int getSize() { return SIZE; }
	public Rectangle getCollider() { return collider; }
}
