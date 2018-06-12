package dev.majimo.rpggame.states;

import java.awt.Graphics;

import dev.majimo.rpggame.gfx.Assets;

public class GameState extends State {

	public GameState() {
		
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.ground, 0, 0, null);
	}
	
}
