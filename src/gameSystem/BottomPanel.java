package gameSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BottomPanel extends JPanel {	
	private static final long serialVersionUID = 1L;
	private GameWindow window;
	
	public BottomPanel(GameWindow window) {
		this.window = window;
		this.setPreferredSize(new Dimension(WIDTH, 125));
		
		setBackground(Color.BLACK);
		this.setLayout(null);
		
		JLabel power = new JLabel(new ImageIcon("power.png"));
		Dimension size = power.getPreferredSize();
		power.addMouseListener(new UIListener());
		power.setName("power");
		power.setBounds(1000-size.width-20,125-size.height-10, size.width, size.height);
		
		JLabel settings = new JLabel(new ImageIcon("settings.png"));
		size = settings.getPreferredSize();
		settings.addMouseListener(new UIListener());
		settings.setName("settings");
		settings.setBounds(1000-size.width-power.getPreferredSize().width-20,125-size.height-10, size.width, size.height);
		
		this.add(power);
		this.add(settings);
	}
	
	private class UIListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				if (((JLabel)e.getSource()).getName().equals("power")) System.exit(0);
				if (((JLabel)e.getSource()).getName().equals("settings")) window.showMenu();
			}
		}
	}
}
