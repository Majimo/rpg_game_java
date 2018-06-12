package dev.majimo.rpggame.entities.creatures;

import dev.majimo.rpggame.entities.Entity;

public abstract class Creature extends Entity {
	
	public int health;

	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}

}
