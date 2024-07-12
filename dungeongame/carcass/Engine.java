package org.dungeongame.carcass;

import  org.dungeongame.carcass.gamelayers.GameLayersManager;
import  org.dungeongame.carcass.gameinterface.WindowManager;
import org.dungeongame.base.layers.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Engine {
	private static GameLayersManager gameLayerManager;
	private static WindowManager windowManager;
	private static Timer timer;

	public static void init() {
		gameLayerManager = new GameLayersManager();
		windowManager = new WindowManager();
		timer = new Timer(20, new MainGameLoop());
	}

	public static void start() {
		gameLayerManager.stackLayer(new MainMenu(gameLayerManager));
		windowManager.addPanel(new GameScreen());
		windowManager.addKeyListener(new Keyboard());
		windowManager.createWindow();
		timer.start();
	}

	private static class MainGameLoop implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			gameLayerManager.loop();
		}
	}

	private static class GameScreen extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			gameLayerManager.render(g);
			repaint();
		}
	}

	private static class Keyboard implements KeyListener {

		@Override
		public void keyPressed(KeyEvent key) {
			gameLayerManager.keyPressed(key.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent key) {
			gameLayerManager.keyReleased(key.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent arg0) {}
	}
}