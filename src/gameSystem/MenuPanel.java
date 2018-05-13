package gameSystem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GameWindow window;
	
	public MenuPanel(GameWindow window) {
		this.window = window;
		
		this.setPreferredSize(new Dimension(50, 50));
		this.setLayout(new FlowLayout());
		this.setBackground(Color.PINK);
		
		JLabel back = new JLabel(new ImageIcon("back.png"));
		back.addMouseListener(new UIListener());
		back.setName("back");
		
		JLabel resume = new JLabel(new ImageIcon("resume.png"));
		resume.addMouseListener(new UIListener());
		resume.setName("resume");
		
		JLabel replay = new JLabel(new ImageIcon("replay.png"));
		replay.addMouseListener(new UIListener());
		replay.setName("replay");
		
		this.add(back);
		this.add(resume);
		this.add(replay);
	}
	
	private class UIListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				if (((JLabel)e.getSource()).getName().equals("back")) window.showPanel("Welcome Screen");
				if (((JLabel)e.getSource()).getName().equals("resume")) window.showPanel("Main Panel");
				if (((JLabel)e.getSource()).getName().equals("replay")) window.restart();
			}
		}
	}
}
