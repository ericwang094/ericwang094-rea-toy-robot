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

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Get next position by given direction
	 * @param direction
	 * @return
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
