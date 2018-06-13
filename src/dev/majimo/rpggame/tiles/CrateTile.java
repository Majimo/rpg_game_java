package dev.majimo.rpggame.tiles;

import dev.majimo.rpggame.gfx.Assets;

public class CrateTile extends Tile {

	public CrateTile(int id) {
		super(Assets.crate, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
