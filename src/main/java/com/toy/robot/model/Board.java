package com.toy.robot.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	int sizeX;
	int sizeY;
	List<Position> obstacleList = new ArrayList<>();

	public Board(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	public Board(int sizeX, int sizeY, List<Position> obstacleList) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.obstacleList = obstacleList;
	}

	public void setObstacleList(List<Position> obstacleList) {
		this.obstacleList = obstacleList;
	}

	/**
	 * // TODO decide if allow multiple same location obstacles
	 * @param position
	 */
	public void addObstacle(Position position) {
		this.obstacleList.add(position);
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

		// check if the robot is moving towards obstacle
		for(Position obstacle : obstacleList) {
			if (position.getX() == obstacle.getX()
				&& position.getY() == obstacle.getY()) {
				return false;
			}
		}
		return true;
	}
}
