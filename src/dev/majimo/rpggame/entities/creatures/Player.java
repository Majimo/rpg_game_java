package dev.majimo.rpggame.entities.creatures;

import java.awt.Graphics;

import dev.majimo.rpggame.Game;
import dev.majimo.rpggame.gfx.Assets;

public class Player extends Creature {
	
	private Game game;

	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void update() {
		if(game.getKeyManager().up) {
			y -= 3;
		}
		if(game.getKeyManager().down) {
			y += 3;
		}
		if(game.getKeyManager().left) {
			x -= 3;
		}
		if(game.getKeyManager().right) {
			x += 3;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, 128, 128, null);
	}

}