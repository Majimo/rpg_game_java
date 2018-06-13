package dev.majimo.rpggame.tiles;

import dev.majimo.rpggame.gfx.Assets;

public class StoneTile extends Tile {

	public StoneTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
