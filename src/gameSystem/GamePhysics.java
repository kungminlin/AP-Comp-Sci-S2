package gameSystem;
import gameEntities.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.*;

public class GamePhysics implements PhysicsEngine, ActionListener, FocusListener {
	private Player player;
	private List<Enemy> enemies;
	private JPanel gamePanel;
	private Timer gameTime;
	
	public GamePhysics(JPanel gamePanel, Player player, List<Enemy> enemies) {
		this.gamePanel = gamePanel;
		this.player = player;
		this.enemies = enemies;
		gamePanel.addFocusListener(this);
		gameTime = new Timer(10, this);
		gameTime.start();
	}
	
	public void updatePhysics() { }
	
	public void start() {
		gameTime.start();
	}
	
	public void stop() {
		gameTime.stop();
	}
	
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (player.getWeapon() instanceof Shootable) for (int j=0; j < ((Shootable)player.getWeapon()).getBullets().size(); j++) {
				Bullet bullet = ((Shootable)player.getWeapon()).getBullets().get(i);
				if (enemy.getCollider().intersects(bullet.getCollider().getBounds())) {
					((GamePanel)gamePanel).playMusic("hitsound.wav");
					enemies.remove(enemy);
					((Shootable)player.getWeapon()).getBullets().remove(j);
					j--;
					i--;
				}
			}
			
			
//			if (player.getCollider().intersects(enemies.get(i).getCollider())) {
//				//if ()
//				//enemies.remove(i);
//				//i--;
//			}
		}
	}

	public void focusGained(FocusEvent e) { }

	public void focusLost(FocusEvent e) {
		gamePanel.requestFocusInWindow();
	}
}
