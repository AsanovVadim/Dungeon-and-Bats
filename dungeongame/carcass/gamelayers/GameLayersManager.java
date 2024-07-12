package org.dungeongame.carcass.gamelayers;

import org.dungeongame.base.layers.MainMenu;
import org.dungeongame.base.layers.PlayingField;

import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;


public class GameLayersManager {
	private Stack<GameLayers> layers;
	public GameLayersManager() {
		this.layers = new Stack<>();
	}
	public void stackLayer(GameLayers layer) {
		this.layers.add(layer);
	}

	public void backToPreviousLayer() {
		this.layers.pop();
	}
	
	public void clearStack() {
		this.layers.clear();
	}

	public void loop() {
		try {
			this.layers.peek().loop();
		} catch(EmptyStackException e) {
			System.err.println("[GameLayersManager]: Error! GameLayers stack is empty!");
			System.exit(-1);
		}
	}

	public void render(Graphics graphics) {
		try {
			this.layers.peek().render(graphics);
		} catch(EmptyStackException e) {
			System.err.println("[GameLayersManager]: Error! GameLayers stack is empty!");
			System.exit(-1);
		}
	}
	
	public void keyPressed(int keyCode) {
		try {
			this.layers.peek().keyPressed(keyCode);
		} catch(EmptyStackException e) {
			System.err.println("[GameLayersManager]: Error! GameLayers stack is empty!");
			System.exit(-1);
		}
	}
	
	public void keyReleased(int keyCode) {
		try {
			this.layers.peek().keyReleased(keyCode);
		} catch(EmptyStackException e) {
			System.err.println("[GameLayersManager]: Error! GameLayers stack is empty!");
			System.exit(-1);
		}
	}
}