package org.dungeongame.base.gamefield;

import org.dungeongame.carcass.transportation.Resources;
import org.dungeongame.base.creatures.Player;
import org.dungeongame.base.creatures.Enemy;
import org.dungeongame.base.gamefield.generator.RoomData;

import java.awt.*;
import java.util.ArrayList;


public class Room {
	private RoomData data;
	private ArrayList<Subtleties> features;
	private ArrayList<Enemy> enemies;
	
	public Room(RoomData data) {
		this.data = data;
		this.features = new ArrayList<>();
		this.enemies = new ArrayList<>();
	}
	
	public RoomData getData() {
		return data;
	}
	
	public void placeFeature(Subtleties feature) {
		if(data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.FLOOR ||
			data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.GRASS ||
			data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.TILE) {
			this.features.add(feature);
		}
		else {
			this.placeFeature(new Subtleties(feature));
		}
	}
	
	public void featureInteraction(Player player) {
		for(int i = 0; i < this.features.size(); i++) {
			if(this.features.get(i).intersects(player)) {
				this.features.remove(i);
			}
		}
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public void spawnEnemy(Enemy enemy) {
		if(data.getTileAt(enemy.x / Tile.SIZE, enemy.y / Tile.SIZE).getID() == Resources.FLOOR)
			this.enemies.add(enemy);
		else
			this.spawnEnemy(new Enemy(enemy));
	}
	
	public void render(Graphics graphics) {
		this.data.render(graphics);
		for(Subtleties feature : features) {
			feature.render(graphics);
		}
		for(Enemy enemy : enemies) {
			enemy.render(graphics);
		}
	}
}