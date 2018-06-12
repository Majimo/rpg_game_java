package dev.majimo.rpggame.entities.creatures;

import java.awt.Graphics;

import dev.majimo.rpggame.gfx.Assets;

public class Player extends Creature {

	public Player(float x, float y) {
		super(x, y);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, 128, 128, null);
	}

}
