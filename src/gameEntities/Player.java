package gameEntities;
import gameSystem.*;
import java.awt.*;

public class Player {
	private static final int SIZE = 40;
	
	private double x;
	private double y;
	private double velX = 0;
	private double velY = 0;
	private double accelX = 0;
	private double accelY = 0;
	
	private Rectangle collider;
	private Weapon weapon;
	
	public Player() {
		x = 500;
		y = 600;
		collider = new Rectangle(getX(), getY(), SIZE, SIZE);
		weapon = new Sword(getX(), getY(), 10);
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void draw(Graphics g) {
		weapon.draw(g);
		g.setColor(Color.PINK);
		g.drawRect(getX(), getY(), SIZE, SIZE);
		g.fillRect(getX(), getY(), SIZE, SIZE);
		
	}
	
	public void move() {
		x+=accelX*velX/3;
		y-=accelY*velY/3;
		collider = new Rectangle(getX(), getY(), SIZE, SIZE);
		weapon.setPosition(getX(), getY());
		if (accelX*velX/3 > 0) weapon.setDirection(true);
		else if (accelX*velX/3 < 0) weapon.setDirection(false);
	}
	
	// Getters and Setters for Position, Velocity and Acceleration
	
	public int getX() {return (int)Math.round(x);}
	public int getY() {return (int)Math.round(y);}
	public double getXPos() {return x;}
	public double getYPos() {return y;}
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}
	
	public double getVelX() {return velX;}
	public double getVelY() {return velY;}
	public void setVelX(double velX) {this.velX = velX;}
	public void setVelY(double velY) {this.velY = velY;}
	
	public double getAccelX() {return accelX;}
	public double getAccelY() {return accelY;}
	public void setAccelX(double accelX) {this.accelX = accelX;}
	public void setAccelY(double accelY) {this.accelY = accelY;}
	
	public int getSize() {return SIZE;}
	public Rectangle getCollider() {return collider;}
}
