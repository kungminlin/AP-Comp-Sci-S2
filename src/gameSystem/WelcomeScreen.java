package gameSystem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;

public class WelcomeScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	private GameWindow window;
	private JPanel gamePanel;
	
	public WelcomeScreen(GameWindow window, JPanel gamePanel) {
		this.window = window;
		this.gamePanel = gamePanel;
		this.setLayout(null);
		this.setBackground(Color.PINK);

		Dimension size = window.getSize();
		
		JButton startButton = new JButton("Start");
		startButton.addMouseListener(new UIListener());
		startButton.setFocusPainted(false);
		startButton.setFont(new Font("Monospaced", Font.BOLD, 30));
		startButton.setBounds(size.width/2-150, 300, 300, 50);
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		
		JButton exitButton = new JButton("Quit");
		exitButton.addMouseListener(new UIListener());
		exitButton.setFocusPainted(false);
		exitButton.setFont(new Font("Monospaced", Font.BOLD, 30));
		exitButton.setBounds(size.width/2-150, 400, 300, 50);
		exitButton.setBackground(Color.BLACK);
		exitButton.setForeground(Color.WHITE);
		
		this.add(startButton);
		this.add(exitButton);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension size = window.getSize();
		
		String title = "B I O N G";
		Font titleFont = new Font("Consolas", Font.BOLD, 36);
		FontMetrics titleMetrics = g.getFontMetrics(titleFont);
		g.setFont(titleFont);
		g.drawString(title, size.width/2-titleMetrics.stringWidth(title)/2, 200);
	}
	
	private class UIListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() instanceof JButton) {
				if (((JButton)e.getSource()).getText().equals("Start")) {
					window.showPanel("Main Panel");	
					((GamePanel)gamePanel).startGame();
					gamePanel.requestFocusInWindow();
				}
				if (((JButton)e.getSource()).getText().equals("Quit")) {
					System.exit(0);
				}
			}
		}
		
		public void mouseEntered(MouseEvent e) {
			Dimension size = window.getSize();
			
			if (e.getSource() instanceof JButton) {
				((JButton)e.getSource()).setFont(new Font("Monospaced", Font.BOLD, 40));
				if (((JButton)e.getSource()).getText().equals("Start")) 
					((JButton)e.getSource()).setBounds(size.width/2-175, 288, 350, 75);
				if (((JButton)e.getSource()).getText().equals("Quit")) 
					((JButton)e.getSource()).setBounds(size.width/2-175, 388, 350, 75);
			}
		}
		
		
		public void mouseExited(MouseEvent e) {
			Dimension size = window.getSize();
			
			if (e.getSource() instanceof JButton) {
				((JButton)e.getSource()).setFont(new Font("Monospaced", Font.BOLD, 30));
				if (((JButton)e.getSource()).getText().equals("Start")) 
					((JButton)e.getSource()).setBounds(size.width/2-150, 300, 300, 50);
				if (((JButton)e.getSource()).getText().equals("Quit")) 
					((JButton)e.getSource()).setBounds(size.width/2-150, 400, 300, 50);
			}
		}
	}
}
