package com.toy.robot.model;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);

	private int directionIndex;
	private static final int TURN_LEFT = -1;
	private static final int TURN_RIGHT = 1;
	// initialize a map that map index to direction
	private static Map<Integer, Direction> index2DirectionMap = new HashMap<>();
	static {
		for (Direction direction : Direction.values()) {
			index2DirectionMap.put(direction.directionIndex, direction);
		}
	}
	Direction (int directionIndex) {
		this.directionIndex = directionIndex;
	}

	/**
	 * Rotate current position to left
	 * @return new direction after turn left
	 */
	public Direction rotateLeft() {
		return rotate(TURN_LEFT);
	}

	/**
	 * rotate current position to right
	 * @return new direction after turn right
	 */
	public Direction rotateRight() {
		return rotate(TURN_RIGHT);
	}

	/**
	 * Rotate position based on index
	 * @param rotateIndex This is the direction of next direction
	 * @return new direction after rotate
	 */
	private Direction rotate(int rotateIndex) {
		int newDirectionIndex = this.directionIndex + rotateIndex;
		if (newDirectionIndex < 0) {
			// if it rotate counter clockwise and move from North, return the last position in the map.
			return index2DirectionMap.get(index2DirectionMap.size() - 1);
		}
		// Otherwise, use mode operation to corresponding direction
		return index2DirectionMap.get(newDirectionIndex % index2DirectionMap.size());
	}
}
