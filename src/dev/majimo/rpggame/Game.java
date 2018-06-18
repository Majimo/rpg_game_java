package dev.majimo.rpggame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.majimo.rpggame.display.Display;
import dev.majimo.rpggame.gfx.Assets;
import dev.majimo.rpggame.gfx.GameCamera;
import dev.majimo.rpggame.input.KeyManager;
import dev.majimo.rpggame.states.GameState;
import dev.majimo.rpggame.states.MenuState;
import dev.majimo.rpggame.states.State;

public class Game implements Runnable {
	
	private Display display;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	public String title;
	private int width, height;
	
	// States
	private State gameState;
	private State menuState;	//TODO
	
	// Inputs
	private KeyManager keyManager;
	
	// Camera
	private GameCamera gameCamera;
	
	// Handler
	private Handler handler;
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}

	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			// Check if fps is good or not
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frame : " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}
	
	private void update() {
		keyManager.update();
		
		if (State.getState() != null)
			State.getState().update();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// Clear Screen
		g.clearRect(0, 0, width, height);
		
		// Drawing stuff
		if (State.getState() != null)
			State.getState().render(g);
		// End drawing
			
		bs.show();
		g.dispose();
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
