package org.dungeongame.base;

import org.dungeongame.carcass.tools.MathHelper;
import org.dungeongame.base.gamefield.generator.RoomData;


public class Generation {
	public static final RoomData[] ROOMS = new RoomData[] {
			// Шаблон генерации 1
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
									   {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									   {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
									   {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
									   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
									   {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.NORTH),

			// Шаблон генерации 2
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
									   {1, 1, 1, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 1, 1},
									   {1, 0, 0, 0, 0, 1, 4, 4, 4, 0, 0, 0, 0, 0, 0, 1},
									   {1, 0, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 0, 1, 1},
									   {1, 1, 1, 0, 0, 0, 4, 4, 0, 0, 1, 0, 0, 0, 1, 1},
									   {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
									   {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.SOUTH),

			// Шаблон генерации 3
			new RoomData(new byte[][] {{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {2, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 2},
									   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 2},
									   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {2, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 2},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}},
					MathHelper.Direction.WEST),

			// Шаблон генерации 4
			new RoomData(new byte[][] {{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2},
									   {2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
									   {2, 0, 2, 0, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
									   {2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2},
									   {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}},
					MathHelper.Direction.EAST),

			// Шаблон генерации 5
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 2, 3, 3, 2, 1, 1, 1, 1, 1, 1},
									   {1, 2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 2, 2, 1},
									   {1, 2, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 2, 1},
									   {1, 2, 0, 2, 0, 2, 0, 3, 3, 0, 2, 0, 2, 0, 2, 1},
									   {1, 2, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 2, 1},
									   {1, 2, 0, 2, 0, 2, 0, 3, 3, 0, 2, 0, 2, 0, 2, 1},
									   {1, 2, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 2, 1},
									   {1, 2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 2, 2, 1},
									   {1, 1, 1, 1, 1, 1, 2, 3, 3, 2, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.NORTH, MathHelper.Direction.SOUTH),

			// Шаблон генерации 6
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
									   {1, 0, 0, 1, 1, 4, 4, 4, 0, 0, 0, 0, 0, 0, 1, 1},
									   {0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0},
									   {0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0},
									   {0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0},
									   {1, 1, 1, 0, 0, 0, 4, 4, 4, 4, 0, 0, 1, 0, 0, 1},
									   {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.WEST, MathHelper.Direction.EAST),

			// Шаблон генерации 7
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
									   {1, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
									   {1, 2, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
									   {1, 2, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
									   {1, 2, 3, 3, 3, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0},
									   {1, 2, 3, 3, 3, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1},
									   {1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 1},
									   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.NORTH, MathHelper.Direction.EAST),

			// Шаблон генерации 8
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									   {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
									   {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
									   {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
									   {1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
									   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.NORTH, MathHelper.Direction.WEST),

			// Шаблон генерации 9
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
									   {1, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									   {1, 2, 3, 3, 3, 2, 0, 0, 0, 0, 4, 4, 0, 0, 0, 1},
									   {1, 2, 3, 3, 3, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0},
									   {1, 2, 3, 3, 3, 2, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0},
									   {1, 2, 2, 0, 2, 2, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
									   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1},
									   {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.SOUTH, MathHelper.Direction.EAST),

			// Шаблон генерации 10
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1},
									   {1, 2, 2, 2, 2, 2, 2, 2, 0, 2, 0, 0, 0, 0, 0, 1},
									   {1, 2, 0, 0, 0, 0, 0, 2, 0, 2, 2, 2, 2, 0, 2, 2},
									   {0, 0, 0, 2, 2, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2},
									   {0, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2},
									   {0, 0, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2},
									   {1, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2},
									   {1, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 0, 2, 0, 1},
									   {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 2, 2, 1, 1}},
					MathHelper.Direction.SOUTH, MathHelper.Direction.WEST),

			// Шаблон генерации 11
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
									   {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									   {1, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
									   {1, 1, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
									   {1, 1, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
									   {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									   {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
									   {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.NORTH, MathHelper.Direction.EAST, MathHelper.Direction.SOUTH),

			// Шаблон генерации 12
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
									   {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1},
									   {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 2, 0, 1},
									   {0, 0, 0, 0, 0, 0, 0, 2, 2, 1, 1, 0, 0, 3, 0, 0},
									   {0, 0, 0, 0, 0, 2, 0, 2, 1, 1, 0, 0, 0, 3, 0, 0},
									   {0, 0, 0, 1, 1, 0, 0, 2, 2, 2, 0, 0, 1, 1, 0, 0},
									   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 1},
									   {1, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 1},
									   {1, 1, 1, 1, 1, 1, 1, 0, 4, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.WEST, MathHelper.Direction.EAST, MathHelper.Direction.SOUTH),

			// Шаблон генерации 13
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 1, 1, 1, 1, 1, 1},
									   {1, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2, 1},
									   {2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
									   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 2, 1},
									   {0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 3, 3, 3, 0, 2, 1},
									   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 2, 1},
									   {2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
									   {1, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2, 1},
									   {1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.WEST, MathHelper.Direction.NORTH, MathHelper.Direction.SOUTH),

			// Шаблон генерации 14
			new RoomData(new byte[][] {{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
									   {1, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
									   {1, 0, 4, 1, 4, 4, 4, 4, 4, 0, 1, 0, 0, 0, 0, 1},
									   {0, 0, 4, 4, 4, 4, 1, 4, 4, 4, 0, 0, 0, 0, 0, 0},
									   {0, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 0, 1, 0, 0},
									   {0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0},
									   {1, 0, 1, 0, 0, 0, 4, 4, 1, 4, 4, 4, 4, 0, 0, 1},
									   {1, 0, 0, 0, 1, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 1},
									   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
					MathHelper.Direction.WEST, MathHelper.Direction.NORTH, MathHelper.Direction.EAST),

			// Шаблон генерации 15
			new RoomData(new byte[][] {{2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2, 2},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {2, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2},
									   {0, 0, 3, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 3, 0, 0},
									   {0, 0, 3, 3, 3, 3, 3, 2, 2, 3, 3, 3, 3, 3, 0, 0},
									   {0, 0, 3, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 3, 0, 0},
									   {2, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2},
									   {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
									   {2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2, 2}},
					MathHelper.Direction.NORTH, MathHelper.Direction.SOUTH, MathHelper.Direction.WEST, MathHelper.Direction.EAST),
	};
}