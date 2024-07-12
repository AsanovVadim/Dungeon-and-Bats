package org.dungeongame.carcass.transportation;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Loader {
	
	public static void load() {
		try {
			File texturesFolder = new File("resources/rooms");
			for(File imgFile : texturesFolder.listFiles()) {
					Resources.ROOMS.put(imgFile.getName(), ImageIO.read(imgFile));
			}
			Resources.TEXTURES.add(Resources.FLOOR, ImageIO.read(new File("resources/textures/floor.png")));
			Resources.TEXTURES.add(Resources.STONE, ImageIO.read(new File("resources/textures/stone.png")));
			Resources.TEXTURES.add(Resources.WALL, ImageIO.read(new File("resources/textures/wall.png")));
			Resources.TEXTURES.add(Resources.TILE, ImageIO.read(new File("resources/textures/tile.png")));
			Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(new File("resources/textures/grass.png")));
			Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(new File("resources/textures/player.png")));
			Resources.TEXTURES.add(Resources.PLAYER_2, ImageIO.read(new File("resources/textures/player_2.png")));
			Resources.TEXTURES.add(Resources.PLAYER_LEFT, ImageIO.read(new File("resources/textures/player_left.png")));
			Resources.TEXTURES.add(Resources.PLAYER_LEFT_2, ImageIO.read(new File("resources/textures/player_left_2.png")));
			Resources.TEXTURES.add(Resources.PLAYER_RIGHT, ImageIO.read(new File("resources/textures/player_right.png")));
			Resources.TEXTURES.add(Resources.PLAYER_RIGHT_2, ImageIO.read(new File("resources/textures/player_right_2.png")));
			Resources.TEXTURES.add(Resources.PLAYER_BACK, ImageIO.read(new File("resources/textures/player_back.png")));
			Resources.TEXTURES.add(Resources.PLAYER_BACK_2, ImageIO.read(new File("resources/textures/player_back_2.png")));
			Resources.TEXTURES.add(Resources.STAIRS, ImageIO.read(new File("resources/textures/stairs.png")));
			Resources.TEXTURES.add(Resources.CHEST, ImageIO.read(new File("resources/textures/chest.png")));
			Resources.TEXTURES.add(Resources.ENEMY, ImageIO.read(new File("resources/textures/enemy.png")));
			Resources.TEXTURES.add(Resources.ENEMY_2, ImageIO.read(new File("resources/textures/enemy_2.png")));
			Resources.TEXTURES.add(Resources.ATTACK, ImageIO.read(new File("resources/textures/attack.png")));
			Resources.TEXTURES.add(Resources.HEART, ImageIO.read(new File("resources/textures/heart.png")));
			Resources.TEXTURES.add(Resources.ARMOR, ImageIO.read(new File("resources/textures/armor.png")));
			Resources.TEXTURES.add(Resources.GOLD, ImageIO.read(new File("resources/textures/gold.png")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}