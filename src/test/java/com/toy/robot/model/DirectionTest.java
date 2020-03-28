package com.toy.robot.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

	@Test
	public void testRotate() {
		Direction direction = Direction.NORTH;
		Direction directionEast = direction.rotateRight();
		assertEquals("Rotate clockwise from North to East", Direction.EAST, directionEast);
		Direction directionSouth = directionEast.rotateRight();
		assertEquals("Rotate clockwise from East to South", Direction.SOUTH, directionSouth);
		Direction directionWest = directionSouth.rotateRight();
		assertEquals("Rotate clockwise from South to West", Direction.WEST, directionWest);
		Direction directionNorth = directionWest.rotateRight();
		assertEquals("Rotate clockwise from West to North", Direction.NORTH, directionNorth);

		directionWest = direction.rotateLeft();
		assertEquals("Rotate counterclockwise from North to West", Direction.WEST, directionWest);
		directionSouth = directionWest.rotateLeft();
		assertEquals("Rotate counterclockwise from West to South", Direction.SOUTH, directionSouth);
		directionEast = directionSouth.rotateLeft();
		assertEquals("Rotate counterclockwise from South to East", Direction.EAST, directionEast);
		directionNorth = directionEast.rotateLeft();
		assertEquals("Rotate counterclockwise from East to North", Direction.NORTH, directionNorth);
	}
}
