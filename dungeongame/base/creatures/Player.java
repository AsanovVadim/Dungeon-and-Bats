package org.dungeongame.base.creatures;

import org.dungeongame.carcass.transportation.Resources;
import org.dungeongame.carcass.tools.MathHelper;
import org.dungeongame.base.gamefield.Tile;

import java.awt.*;


public class Player extends Subject {

	private static final long serialVersionUID = 1L;
	private int hp;
	private int maxHp;
	private byte regenDelay;
	private int armor;
	private int gold;
	
	private byte attackTime;
	private byte damageTime;
	
	public Player() {
		super(Resources.PLAYER, MathHelper.randomInt(2, 14), MathHelper.randomInt(2, 7));
		this.hp = 20;
		this.maxHp = 20;
		this.regenDelay = 0;
		this.armor = 0;
		this.gold = 0;
		this.attackTime = 0;
		this.damageTime = 0;
	}
	
	public void replaceRandomly() {
		super.x = MathHelper.randomInt(2, 14) * Tile.SIZE;
		super.y = MathHelper.randomInt(2, 7) * Tile.SIZE;
	}

	public int getHp() {
		return hp;
	}

	// Обработка исключения отрицательного хп
	public void lostHp() {
		if(this.hp < 0) this.hp = 0;
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	// Мгновенное исцеление
	public void instantHeal(int amount) {
		this.hp += amount;
		if(this.hp > this.maxHp) this.hp = this.maxHp;
	}

	// Регенерация здоровья
	public void regenerateHealth() {
		if(this.hp < this.maxHp) this.regenDelay++;
		else this.regenDelay = 0;
		
		if(this.regenDelay == 100) {
			this.hp++;
			this.regenDelay = 0;
		}
	}

	public int getArmor() {
		return armor;
	}

	// Получение брони и лимит ограничения
	public void addArmor(int amount) {
		this.armor += amount;
		if(this.armor > 75) this.armor = 75;
	}
	
	public int getGold() {
		return gold;
	}

	// Получение монет
	public void giveGold(int amount) {
		this.gold += amount;
	}

	// Смена направления взгляда персонажа игрока
	@Override
	public void move() {
		if(this.attackTime == 0) {
			super.move();
			switch(super.facing) {
			case NORTH: super.entityID = Resources.PLAYER_BACK; break;
			case SOUTH: super.entityID = Resources.PLAYER; break;
			case WEST: super.entityID = Resources.PLAYER_LEFT; break;
			case EAST: super.entityID = Resources.PLAYER_RIGHT; break;
			}
		}
	}

	// Откат атаки и получения урона
	public void decreaseTime() {
		if(this.attackTime > 0) {
			this.attackTime--;
		}
		if(this.damageTime > 0) {
			this.damageTime--;
		}
	}

	// Регулирование задержки после атаки
	public void attack() {
		if(this.attackTime == 0) {
			this.attackTime = 30;
		}
	}

	// Атака по направлению взгляда персонажа игрока
	public Rectangle getAttackBox() {
		if(this.attackTime == 20) {
			switch(super.facing) {
			case NORTH:
				return new Rectangle(super.x, super.y - super.height, super.width, super.height);
			case SOUTH:
				return new Rectangle(super.x, super.y + super.height, super.width, super.height);
			case WEST:
				return new Rectangle(super.x - super.width, super.y, super.width, super.height);
			case EAST:
				return new Rectangle(super.x + super.width, super.y, super.width, super.height);
			default:
				break;
			}
		}
		return new Rectangle(0, 0, 0, 0);
	}

	// Отрисовка анимации атаки
	@Override
	public void render(Graphics graphics) {
		if((up || down || left || right) && this.attackTime == 0) {
			super.animationDelay++;
			if(super.animationDelay == 70) {
				super.animationDelay = 0;
				super.animationFrame = (byte) (1 - super.animationFrame);
			}
		}
		graphics.drawImage(Resources.TEXTURES.get(entityID + animationFrame),
				super.x, super.y, super.width, super.height, null);
	}

	// Получение урона и задержка между его получением
	public void damage(int amount) {
		if(this.damageTime == 0) {
			this.hp -= amount;
			this.damageTime = 50;
		}
	}
}