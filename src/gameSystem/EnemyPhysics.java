package gameSystem;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;
import gameEntities.*;

public class EnemyPhysics implements PhysicsEngine, ActionListener {
	private JPanel gamePanel;
	private Enemy enemy;
	private Player player;
	private Timer gameTime;
	
	public EnemyPhysics(JPanel gamePanel, Enemy enemy, Player player) {
		this.gamePanel = gamePanel;
		this.enemy = enemy;
		this.player = player;
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
		
		if (player.getX() < enemy.getX()) enemy.setVelX(-1);
		else enemy.setVelX(1);
		
		updatePhysics();
		enemy.move();
		gamePanel.repaint();
	}
}
