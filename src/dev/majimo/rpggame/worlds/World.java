package dev.majimo.rpggame.worlds;

import java.awt.Graphics;

import dev.majimo.rpggame.Handler;
import dev.majimo.rpggame.tiles.Tile;
import dev.majimo.rpggame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tilesArray;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		// Rendering only the tile on screen
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(width, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y ++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.groundTile;
		
		Tile t = Tile.tiles[tilesArray[x][y]];
		if(t == null)
			return Tile.groundTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tilesArray = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tilesArray[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
				// Génération aléatoire ?
				// tilesArray[x][y] = (int) ((Math.random() * ( 16 - 0 )) / 4);
			}
		}
	}
	
}
