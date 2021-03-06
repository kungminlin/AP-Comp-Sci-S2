package gameSystem;
import gameEntities.*;
import javax.swing.*;
import java.awt.event.*;

public class PlayerPhysics implements PhysicsEngine, ActionListener, KeyListener {
	private JPanel gamePanel;
	private Player player;
	private boolean accelEnd = true;
	private boolean initAccel = false;
	private boolean onGround = true;
	private boolean falling = false;
	private Timer gameTime;
	
	public PlayerPhysics(JPanel gamePanel, Player player) {
		this.gamePanel = gamePanel;
		this.player = player;
		gamePanel.addKeyListener(this);
		gameTime = new Timer(10, this);
		gameTime.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char input = e.getKeyChar();
		if (input == 'a') {
			if (player.getX() > 0) {
				player.setVelX(-3);
				accelEnd = false;
				if (!initAccel) {
					initAccel = true;
					player.setAccelX(0);
				}
			}
		} else if (input == 'd') {
			if (player.getX() < gamePanel.getWidth()-player.getSize()) {
				player.setVelX(3);
				accelEnd = false;
				if (!initAccel) {
					initAccel = true;
					player.setAccelX(0);
				}
			}
		} else if (input == ' ') {
			player.getWeapon().attack();
		}
	}

	public void keyReleased(KeyEvent e) {
		char input = e.getKeyChar();
		if (input == 'a') {
			accelEnd = true;
			initAccel = false;
		} else if (input == 'd') {
			accelEnd = true;
			initAccel = false;
		}
	}
	public void keyTyped(KeyEvent e) { }
	
	public void updatePhysics() {
		
		// Physics X
		if (accelEnd && player.getAccelX() >= 0) {
			player.setAccelX(player.getAccelX()-0.1);
			if (Math.abs(Math.round(player.getAccelX())) <= 0) player.setAccelX(0); // Eliminate Rounding Errors
		} else if (!accelEnd && player.getAccelX() < 7) player.setAccelX(player.getAccelX()+0.1);

		
		// Physics Y
		if (!onGround) {
			if (Math.round(player.getAccelY()) <= 0) falling = true;
		}
		
		if (falling) {
			player.setAccelY(player.getAccelY()+0.1);
			player.setVelY(-Math.abs(player.getVelY()));
		} else {
			player.setVelY(Math.abs(player.getVelY()));
			player.setAccelY(player.getAccelY()-0.1);
		}
		
		player.setAccelY(Math.abs(player.getAccelY()));
		
		
	}
	
	public void start() {
		gameTime.start();
	}
	
	public void stop() {
		gameTime.stop();
	}

	public void actionPerformed(ActionEvent e) {
		
		// Limit player boundaries
		if (player.getXPos() <= 0) player.setVelX(Math.abs(player.getVelX()));
		if (player.getXPos() >= gamePanel.getWidth()-player.getSize()) player.setVelX(-Math.abs(player.getVelX()));
		
		if (player.getWeapon() instanceof Shootable) for (int i=0; i<((Shootable)player.getWeapon()).getBullets().size(); i++) {
			Bullet bullet = ((Shootable)player.getWeapon()).getBullets().get(i);
			if (bullet.getX() <= 0 || bullet.getX() >= gamePanel.getWidth()) {
				((Shootable)player.getWeapon()).getBullets().remove(i);
				i--;
			}
		}
		
		if (player.getYPos()>=600) {
			player.setY(600);
			onGround = true;
			falling = false;
		} else onGround = false;
		
		if (onGround) {
			player.setAccelY(0);
		}
		
		updatePhysics();
		player.move();
		gamePanel.repaint();
	}
	
	
}
