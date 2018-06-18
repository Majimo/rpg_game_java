package dev.majimo.rpggame.states;

import java.awt.Graphics;

import dev.majimo.rpggame.Game;
import dev.majimo.rpggame.Handler;
import dev.majimo.rpggame.entities.creatures.Player;
import dev.majimo.rpggame.gfx.Assets;
import dev.majimo.rpggame.tiles.StoneTile;
import dev.majimo.rpggame.tiles.Tile;
import dev.majimo.rpggame.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 128, 128);
	}
	
	@Override
	public void update() {
		world.update();
		player.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
	
}
