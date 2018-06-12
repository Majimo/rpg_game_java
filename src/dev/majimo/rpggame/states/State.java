package dev.majimo.rpggame.states;

import java.awt.Graphics;

import dev.majimo.rpggame.Game;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}

	public abstract void update();
	
	public abstract void render(Graphics g);
}
