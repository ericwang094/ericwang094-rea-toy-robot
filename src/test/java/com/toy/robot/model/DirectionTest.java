package com.toy.robot.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class DirectionTest {

	@Test
	@DisplayName("Test direction rotate")
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

		directionEast = directionSouth.rotateLeft();
		assertThat(directionEast)
				.as("Rotate counterclockwise from South to East")
				.isEqualToComparingFieldByField(Direction.EAST);

		directionNorth = directionEast.rotateLeft();
		assertThat(directionNorth)
				.as("Rotate counterclockwise from East to North")
				.isEqualToComparingFieldByField(Direction.NORTH);
	}
}
