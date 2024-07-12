package org.dungeongame.base.layers;

import org.dungeongame.carcass.gamelayers.GameLayers;
import org.dungeongame.carcass.gamelayers.GameLayersManager;
import org.dungeongame.carcass.gameinterface.WindowManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends GameLayers {
	private String[] optionsMenu;
	private static final String START_GAME = "Start Game!";
	private static final String QUIT_GAME = "Quit game, please no :c";
	private int selected;

	public MainMenu(GameLayersManager manager) {
		super(manager);
		this.optionsMenu = new String[] {START_GAME, QUIT_GAME};
		this.selected = 0;
	}

	@Override
	protected void loop() {
	}

	@Override
	protected void render(Graphics graphics) {
		graphics.setColor(new Color(32, 178, 170));
		graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);

		graphics.setFont(new Font("IBM 3270", Font.PLAIN, 25));
		for(int i = 0; i < this.optionsMenu.length; i++) {
			if(i == this.selected) graphics.setColor(new Color(0, 250, 154));
			else graphics.setColor(new Color(0, 100, 0));
			graphics.drawString(this.optionsMenu[i], 20, 50 + i * 40);
		}
	}

	@Override
	protected void keyPressed(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_UP:
				if(this.selected > 0) this.selected--;
				break;
			case KeyEvent.VK_DOWN:
				if(this.selected < this.optionsMenu.length-1) this.selected++;
				break;
			case KeyEvent.VK_ENTER:
				switch(this.optionsMenu[selected]) {
					case START_GAME:
						super.gameLayerManager.stackLayer(new PlayingField(gameLayerManager));
						break;
					case QUIT_GAME:
						System.exit(0);
						break;
				}
				break;
		}
	}

	@Override
	protected void keyReleased(int keyCode) {}
}