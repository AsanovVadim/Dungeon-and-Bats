package org.dungeongame.carcass.gamelayers;

import java.awt.*;


public abstract class GameLayers {
	protected GameLayersManager gameLayerManager;
	protected GameLayers(GameLayersManager manager) {
		this.gameLayerManager = manager;
	}
	protected abstract void loop();
	protected abstract void render(Graphics graphics);
	protected abstract void keyPressed(int keyCode);
	protected abstract void keyReleased(int keyCode);
}