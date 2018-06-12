package dev.majimo.rpggame.states;

import java.awt.Graphics;

import dev.majimo.rpggame.Game;
import dev.majimo.rpggame.entities.creatures.Player;

public class GameState extends State {
	
	private Player player;

	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);		
	}
	
	@Override
	public void update() {
		player.update();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}
	
}
