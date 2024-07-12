package org.dungeongame.base.layers;

import org.dungeongame.carcass.gamelayers.GameLayers;
import org.dungeongame.carcass.gamelayers.GameLayersManager;
import org.dungeongame.carcass.transportation.Resources;
import org.dungeongame.carcass.tools.MathHelper;
import org.dungeongame.base.creatures.Enemy;
import org.dungeongame.base.creatures.Player;
import org.dungeongame.base.gamefield.Subtleties;
import org.dungeongame.base.gamefield.Tile;
import org.dungeongame.base.gamefield.World;
import org.dungeongame.base.gamefield.generator.LevelGenerator;
import org.dungeongame.base.gamefield.generator.RoomData;

import org.dungeongame.carcass.Engine;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PlayingField extends GameLayers {
	private LevelGenerator generator;
	private World world;
	private Player player;
	private int signal = 0;

	protected PlayingField(GameLayersManager manager) {
		super(manager);
		this.generator = new LevelGenerator();
		this.player = new Player();
		this.generateLevel();
	}

	@Override
	protected void loop() {
		this.player.move();
		this.world.changeRoom(player);
		this.collisions();
		this.world.getRoom().featureInteraction(player);
		this.player.regenerateHealth();
		this.playerAttacks();
	}

	// Отрисовка параметров игрока
	@Override
	protected void render(Graphics graphics) {
		this.world.getRoom().render(graphics);
		this.player.render(graphics);
		
		graphics.drawImage(Resources.TEXTURES.get(Resources.ATTACK), this.player.getAttackBox().x,
				this.player.getAttackBox().y, this.player.getAttackBox().width,
				this.player.getAttackBox().height, null);
		
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("arial", Font.PLAIN, 15));
		graphics.drawImage(Resources.TEXTURES.get(Resources.HEART), 0, 0, Tile.SIZE * 2 / 3,
				Tile.SIZE * 2 / 3, null);
		graphics.drawString(this.player.getHp()+"/"+this.player.getMaxHp(), Tile.SIZE *2 / 3 + 5, 20);
		graphics.drawImage(Resources.TEXTURES.get(Resources.ARMOR), 80, 0, Tile.SIZE * 2 / 3,
				Tile.SIZE * 2 / 3, null);
		graphics.drawString(this.player.getArmor()+"", Tile.SIZE * 2 / 3 + 85, 20);
		graphics.drawImage(Resources.TEXTURES.get(Resources.GOLD), 160, 0, Tile.SIZE * 2 / 3,
				Tile.SIZE * 2 / 3, null);
		graphics.drawString(this.player.getGold()+"", Tile.SIZE * 2 / 3 + 165, 20);

		if(this.player.getHp() <= 0){
			graphics.setColor(Color.RED);
			graphics.setFont(new Font("arial", Font.PLAIN, 48));
			graphics.drawString("You are dead!", 270, 230);
			signal = 1;
		}
	}

	// Клавиши управления
	@Override
	protected void keyPressed(int keyCode) {
		switch(keyCode) {
		case KeyEvent.VK_W:
			this.player.setMovingUp(true);
			break;
		case KeyEvent.VK_A:
			this.player.setMovingLeft(true);
			break;
		case KeyEvent.VK_S:
			this.player.setMovingDown(true);
			break;
		case KeyEvent.VK_D:
			this.player.setMovingRight(true);
			break;
		case KeyEvent.VK_Q:
			this.player.attack();
			break;
		case KeyEvent.VK_ESCAPE:
			gameLayerManager.stackLayer(new MainMenu(gameLayerManager));
			break;
		}
	}

	// Реализация движения
	@Override
	protected void keyReleased(int keyCode) {
		switch(keyCode) {
		case KeyEvent.VK_W:
			this.player.setMovingUp(false);
			break;
		case KeyEvent.VK_A:
			this.player.setMovingLeft(false);
			break;
		case KeyEvent.VK_S:
			this.player.setMovingDown(false);
			break;
		case KeyEvent.VK_D:
			this.player.setMovingRight(false);
			break;
		}
	}

	// Генерация уровней
	private void generateLevel() {
		this.generator.reset();

		while(!this.generator.finished()) {
			this.generator.generate();
		}

		// Генерация этажа
		this.world = new World(this.generator.getRoomsData());

		// Генерация лестницы, симулятор перехода на новый этаж
		this.world.getRoomRandom().placeFeature(new Subtleties(Resources.STAIRS, this::generateLevel));

		// Генерация сундуков, получение рандомного лута
		for(int i = 0; i < 12; i++) {
			this.world.getRoomRandom().placeFeature(new Subtleties(Resources.CHEST, this::givePlayerRandomLoot));
		}

		// Генерация спавна врагов и игрока
		for(int i = 0; i < 25; i++) {
			this.world.getRoomRandom().spawnEnemy(new Enemy(Resources.ENEMY, 8, this.player));
		}

		this.spawnPlayer();
	}
	
	private void spawnPlayer() {
		// Спавн игрока
		if(this.world.getRoom(0, 0).getData().getTileAt(player.x / Tile.SIZE,
				player.y / Tile.SIZE).getID() != Resources.FLOOR) {
			this.player.replaceRandomly();
			this.spawnPlayer();
		}
	}

	private void collisions() {
		// Столкновения
		RoomData roomIn = this.world.getRoom().getData();
		for(int i = 0; i < roomIn.getSizeX(); i++) {
			for(int j = 0; j < roomIn.getSizeY(); j++) {
				this.player.handleCollisionWith(roomIn.getTileAt(i, j));
				for(Enemy enemy : this.world.getRoom().getEnemies()) {
					enemy.handleCollisionWith(roomIn.getTileAt(i, j));
				}
			}
		}
	}
	
	private void givePlayerRandomLoot() {
		// Рандомный лут из сундука
		switch(MathHelper.randomInt(3)) {
		case 0: this.player.addArmor(MathHelper.randomInt(1, 3)); break;
		case 1: this.player.giveGold(MathHelper.randomInt(3, 7)); break;
		case 2: this.player.instantHeal(MathHelper.randomInt(5, 10)); break;
		}
	}

	private void playerAttacks() {
		// Распределение урона
		this.player.decreaseTime();
		for(int i = 0; i < this.world.getRoom().getEnemies().size();i++) {
			this.world.getRoom().getEnemies().get(i).move();

			// Получение урона игроком при соприкосневеннии с враждебным мобом
			if(this.world.getRoom().getEnemies().get(i).intersects(this.player)) {
				this.player.damage(5 -  5 * this.player.getArmor() / 100);
				// Урон 5 - броня * 5 / 100
				this.player.lostHp();
				// Если хп игрока меньше 0 - игра окончена
				if(signal == 1){
				//if(this.player.getHp() <= 0){
					try{Thread.sleep(3000);} catch(InterruptedException e) {e.printStackTrace();}
					gameLayerManager.stackLayer(new MainMenu(gameLayerManager));
				}
			}

			// Нанесение урона игроком при попадании по ним атакой
			if(this.world.getRoom().getEnemies().get(i).intersects(this.player.getAttackBox())) {
				this.world.getRoom().getEnemies().get(i).damage(3, this.player.getFacing());
				if(this.world.getRoom().getEnemies().get(i).getHp() <= 0) {
					// Если хп моба меньше нуля
					this.world.getRoom().getEnemies().remove(i);
					// Моб удаляется
					this.player.giveGold(MathHelper.randomInt(2, 5));
					// Выдача игроку от 2 до 5 монет
				}
			}
		}
	}
}