package gameSystem;
import java.awt.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel welcomeScreen;
	private JPanel container;
	private JPanel mainPanel;
	private JPanel gamePanel;
	private JPanel menuPanel;
	private BottomPanel bottomPanel;
	private CardLayout cardLayout;
	private Clip clip;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
	
	public GameWindow() {
		this.setLayout(new FlowLayout());
		this.setSize(WIDTH, HEIGHT);
		
		cardLayout = new CardLayout();
		container = new JPanel();
		container.setLayout(cardLayout);
		
		mainPanel = new JPanel();
		gamePanel = new GamePanel(this);
		bottomPanel = new BottomPanel(this);
		welcomeScreen = new WelcomeScreen(this, gamePanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		
		menuPanel = new MenuPanel(this);
		
		container.add(welcomeScreen, "Welcome Screen");
		container.add(mainPanel, "Main Panel");
		container.add(menuPanel, "Menu");
		cardLayout.show(container, "Welcome Screen");
		
		this.setContentPane(container);
		
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		playMusic("bgm.wav", Clip.LOOP_CONTINUOUSLY);
	}
	
	public void showPanel(String panelName) {
		cardLayout.show(container, panelName);
		gamePanel.requestFocusInWindow();
		if (panelName.equals("Main Panel")) ((GamePanel)gamePanel).start();
	}
	
	public void restart() {
		cardLayout.show(container, "Main Panel");
		((GamePanel)gamePanel).startGame();
	}
	
	public void showMenu() {
		cardLayout.show(container, "Menu");
		((GamePanel)gamePanel).pause();
	}
	
	public void playMusic(String fileName, int loop) {
		try {
			File soundFile = new File(fileName);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			if (loop>0) clip.loop(loop);
		} 
		catch (Exception e) {
			e.printStackTrace(); 
		} 
	}
	
	public void playMusic(String fileName) {
		try {
			File soundFile = new File(fileName);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}
}
