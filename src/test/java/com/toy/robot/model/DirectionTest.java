package com.toy.robot.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class DirectionTest {

	@Test
	public void testRotate() {
		Direction direction = Direction.NORTH;
		Direction directionEast = direction.rotateRight();
		assertThat(directionEast)
				.as("Rotate clockwise from North to East")
				.isEqualToComparingFieldByField(Direction.EAST);

		Direction directionSouth = directionEast.rotateRight();
		assertThat(directionSouth)
				.as("Rotate clockwise from East to South")
				.isEqualToComparingFieldByField(Direction.SOUTH);

		Direction directionWest = directionSouth.rotateRight();
		assertThat(directionWest)
				.as("Rotate clockwise from South to West")
				.isEqualToComparingFieldByField(Direction.WEST);

		Direction directionNorth = directionWest.rotateRight();
		assertThat(directionNorth)
				.as("Rotate clockwise from West to North")
				.isEqualToComparingFieldByField(Direction.NORTH);

		directionWest = direction.rotateLeft();
		assertThat(directionWest)
				.as("Rotate counterclockwise from North to West")
				.isEqualToComparingFieldByField(Direction.WEST);

		directionSouth = directionWest.rotateLeft();
		assertThat(directionSouth)
				.as("Rotate counterclockwise from West to South")
				.isEqualToComparingFieldByField(Direction.SOUTH);

		assertEquals("Rotate counterclockwise from West to South", Direction.SOUTH, directionSouth);
		directionEast = directionSouth.rotateLeft();
		assertEquals("Rotate counterclockwise from South to East", Direction.EAST, directionEast);
		directionNorth = directionEast.rotateLeft();
		assertEquals("Rotate counterclockwise from East to North", Direction.NORTH, directionNorth);
	}
}
