package dev.majimo.rpggame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 160, height = 160;
	
	public static BufferedImage player, zombieMale, zombieFemale, ground, crate, stone, bush;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite_sheet.png"));
		
		player = sheet.crop(0, 0, width, height);
		zombieFemale = sheet.crop(width, 0, width, height);
		zombieMale = sheet.crop(width * 2, 0, width, height);		
		ground = sheet.crop(width * 3, 0, width, height);
		crate = sheet.crop(0, height, width, height);
		stone = sheet.crop(width * 2, height, width, height);
		bush = sheet.crop(width * 3, height, width, height);
	}
	
}
