package com.toy.robot.model;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Get next position by given direction
	 * @param direction is a direction that a robot facing
	 * @return A new position based on current location and direction
	 */
	public Position forwardPosition(Direction direction) {
		int newX = this.x;
		int newY = this.y;

		switch (direction) {
			case NORTH:
				newY += 1;
				break;
			case EAST:
				newX += 1;
				break;
			case SOUTH:
				newY -= 1;
				break;
			case WEST:
				newX -= 1;
				break;
		}

		return new Position(newX, newY);
	}
}
