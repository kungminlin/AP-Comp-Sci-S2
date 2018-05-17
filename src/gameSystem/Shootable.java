package gameSystem;
import java.util.List;

import gameEntities.*;

public interface Shootable extends Weapon {
	List<Bullet> getBullets();
}
