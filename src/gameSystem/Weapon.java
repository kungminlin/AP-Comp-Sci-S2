package gameSystem;

import java.awt.*;

public interface Weapon {
	void draw(Graphics g);
	void animationBehavior(Graphics g);
	void attack();
	int getSpeed();
	void setDirection(boolean direction);
	void setPosition(int x, int y);
}
