package org.dungeongame.base.gamefield;

import org.dungeongame.carcass.transportation.Resources;
import org.dungeongame.carcass.tools.MathHelper;
import org.dungeongame.carcass.tools.FunctionalInterface;

import java.awt.*;


public class Subtleties extends Tile {
	private static final long serialVersionUID = 1L;
	private FunctionalInterface action;
	
	public Subtleties(byte id, FunctionalInterface action) {
		super(id, MathHelper.randomInt(2, 14),
				MathHelper.randomInt(2, 7), false);
		this.action = action;
	}
	
	public Subtleties(Subtleties copy) {
		this(copy.getID(), copy.action);
	}

	// Пересечения
	@Override
	public boolean intersects(Rectangle r) {
		if(super.intersects(r)) {
			this.action.action();
			return true;
		}
		return false;
	}
	
	public void render(Graphics graphics) {
		graphics.drawImage(Resources.TEXTURES.get(super.getID()),
				super.x, super.y, super.width, super.height, null);
	}
}