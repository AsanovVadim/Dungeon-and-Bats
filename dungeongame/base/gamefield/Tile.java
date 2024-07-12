package org.dungeongame.base.gamefield;

import java.awt.*;


public class Tile extends Rectangle {
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 50;
	private byte tileID;
	private boolean wall;
	
	public Tile(byte id, int posXinRoom, int posYinRoom, boolean isWall) {
		super(posXinRoom * SIZE, posYinRoom * SIZE, SIZE, SIZE);
		this.tileID = id;
		this.wall = isWall;
	}

	// Возвращет ID текстуры
	public byte getID() {
		return tileID;
	}

	// Передаёт значение ячейки стена/пол
	public boolean isWall() {
		return wall;
	}
}