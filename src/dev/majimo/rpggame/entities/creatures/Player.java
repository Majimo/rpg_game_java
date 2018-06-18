package dev.majimo.rpggame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import dev.majimo.rpggame.Game;
import dev.majimo.rpggame.Handler;
import dev.majimo.rpggame.gfx.Assets;

public class Player extends Creature {

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 27;
		bounds.y = 11;
		bounds.width = 75;
		bounds.height = 115;
	}

	@Override
	public void update() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	
//		// Collision box on screen
//		g.setColor(Color.RED);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//							bounds.width, bounds.height);
	}

}
