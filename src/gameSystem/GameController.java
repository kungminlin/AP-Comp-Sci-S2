package gameSystem;

public class GameController {
	private GameWindow game;
	
	public GameController(GameWindow game) {
		this.game = game;
	}
	
	public GameWindow getGame() {
		return game;
	}
}
