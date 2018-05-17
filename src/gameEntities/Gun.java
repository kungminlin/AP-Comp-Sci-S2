package gameEntities;
import gameSystem.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Gun implements Weapon, Shootable {
	private List<Bullet> bullets;
	private int x;
	private int y;
	private int speed;
	private int reloadSpeed;
	private boolean positiveDirection;
	
	public Gun(int x, int y, int reloadSpeed, int speed) {
		this.x = x;
		this.y = y;
		this.reloadSpeed = reloadSpeed;
		this.speed = speed;
		bullets = new ArrayList<Bullet>();
	}
	
	public void shoot() {
		Bullet bullet = new Bullet(x, y, speed, positiveDirection);
		bullets.add(bullet);
	}
	
	public List<Bullet> getBullets() {
		return bullets;
	}
	
	public void draw(Graphics g) {
		for (Bullet bullet : bullets) bullet.draw(g);
		g.setColor(Color.BLUE);
		if (positiveDirection) g.fillRect(x+20, y+15, 40, 10);
		else g.fillRect(x-20, y+15, 40, 10);
		
	}

	public void animationBehavior(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public int getSpeed() {
		return reloadSpeed;
	}

	public void attack() {
		shoot();
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setDirection(boolean right) {this.positiveDirection = right;}
}
