package dev.majimo.rpggame;

public class Launcher {

	public static void main(String[] args) {		
		Game game = new Game("Title", 1024, 768);
		game.start();
	}
	
}
