package gameSystem;
import gameEntities.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GameWindow window;
	private Player player = new Player();
	private EnemyController enemyControl = new EnemyController(this, player);
	private List<PhysicsEngine> gameLogic;
	
	public GamePanel(GameWindow window) {
		this.window = window;
		gameLogic = new ArrayList<PhysicsEngine>();
	}
	
	public void startGame() {
		setBackground(Color.WHITE);
		player = new Player();
		enemyControl = new EnemyController(this, player);
		for (PhysicsEngine enemy : enemyControl.getEnemyPhysics()) gameLogic.add(enemy);
		gameLogic.add(new PlayerPhysics(this, player));
		gameLogic.add(new GamePhysics(this, player, enemyControl.getEnemies()));
	}

	public void start() {
		for (PhysicsEngine enemy : enemyControl.getEnemyPhysics()) gameLogic.add(enemy);
		enemyControl.start();
		for (PhysicsEngine physics : gameLogic) physics.start();
	}
	
	public void pause() {
		for (PhysicsEngine enemy : enemyControl.getEnemyPhysics()) gameLogic.add(enemy);
		enemyControl.stop();
		for (PhysicsEngine physics : gameLogic) physics.stop();
	}
	
	public void playMusic(String fileName) {
		window.playMusic(fileName);
	}
	
	public void playMusic(String fileName, int loop) {
		window.playMusic(fileName, loop);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.draw(g);
		enemyControl.draw(g);
	}
}
