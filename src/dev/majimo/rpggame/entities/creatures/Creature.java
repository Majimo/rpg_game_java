package dev.majimo.rpggame.entities.creatures;

import dev.majimo.rpggame.Game;
import dev.majimo.rpggame.Handler;
import dev.majimo.rpggame.entities.Entity;
import dev.majimo.rpggame.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 4.5f;
	public static final int DEFAULT_CREATURE_WIDTH = 128;
	public static final int DEFAULT_CREATURE_HEIGHT = 128;
	
	public int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if (xMove > 0) {			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}
		}
		else if (xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}
		}
	}
	
	public void moveY() {
		if (yMove > 0) {			
			int tx = (int) (y + yMove + bounds.y ) / Tile.TILE_HEIGHT;			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, tx) && !collisionWithTile(tx, (int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH)) {
				y += yMove;
			}
		}
		else if (yMove < 0) {
			int tx = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, tx) && !collisionWithTile(tx, (int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH)) {
				y += yMove;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
