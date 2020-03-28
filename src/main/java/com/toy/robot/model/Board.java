package com.toy.robot.model;

public class Board {
	int sizeX;
	int sizeY;

	public Board(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	/**
	 * Check if the position is out of bound
	 * @param position
	 * @return
	 */
	public boolean isValidMove(Position position) {
		if (position.getX() < 0 || position.getX() >= sizeX) {
			return false;
		}

		if (position.getY() < 0 || position.getY() >= sizeY) {
			return false;
		}

		return true;
	}
}
