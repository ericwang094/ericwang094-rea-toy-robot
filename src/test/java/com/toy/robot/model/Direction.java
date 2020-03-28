package com.toy.robot.model;

public enum Direction {
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);

	private int directionIndex;

	private Direction (int directionIndex) {
		this.directionIndex = directionIndex;
	}
}
