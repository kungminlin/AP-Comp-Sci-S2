package gameEntities;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import gameSystem.*;

public class Sword implements Weapon {
	private int x;
	private int y;
	private int swingSpeed;
	private boolean direction;
	
	public Sword(int x, int y, int swingSpeed) {
		this.x = x;
		this.y = y;
		this.swingSpeed = swingSpeed;
	}
	
	public void animationBehavior(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public void draw(Graphics g) {
		File inputFile = new File("sword.png");
		BufferedImage inputImage = null;
		try {
			inputImage = ImageIO.read(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(inputImage, x, y, null);
	}

	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public int getSpeed() {
		return swingSpeed;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
