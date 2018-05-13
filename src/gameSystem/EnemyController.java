package gameSystem;
import gameEntities.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.*;

public class EnemyController implements ActionListener {
	private List<Enemy> enemies;
	private List<PhysicsEngine> enemyPhysics;
	private Player player;
	private JPanel gamePanel;
	private Timer gameTime;
	
	public EnemyController(JPanel gamePanel, Player player) {
		enemies = new ArrayList<Enemy>();
		enemyPhysics = new ArrayList<PhysicsEngine>();
		this.gamePanel = gamePanel;
		this.player = player;
		gameTime = new Timer(5000, this);
		gameTime.start();
	}
	
	public List<Enemy> getEnemies() {
		return enemies;
	}
	
	public void spawnEnemy(int x, int y) {
		Enemy enemy = new Enemy(x, y);
		enemyPhysics.add(new EnemyPhysics(gamePanel, enemy, player));
		enemies.add(enemy);
	}
	
	public void start() {
		gameTime.start();
	}
	
	public void stop() {
		gameTime.stop();
	}
	
	public void draw(Graphics g) {
		for (Enemy enemy : enemies) enemy.draw(g);
	}

	public void actionPerformed(ActionEvent e) {
		spawnEnemy((int)Math.round(Math.random())*1040-40, 600);
	}
	
	public List<PhysicsEngine> getEnemyPhysics() {
		return enemyPhysics;
	}
}
