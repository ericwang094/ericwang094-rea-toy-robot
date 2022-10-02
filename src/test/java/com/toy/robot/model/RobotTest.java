package com.toy.robot.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RobotTest {
	private Robot robot;

	@BeforeEach
	public void setup() {
		Position position = new Position(2,2);
		Direction direction = Direction.NORTH;
		robot = new Robot(position, direction);
	}

	@Test
	@DisplayName("Place a robot")
	public void placeRobotTest() {
		Position newPosition = new Position(1, 1);
		robot.placeRobot(newPosition, Direction.SOUTH);
		assertThat(robot.getPosition())
				.as("Test place position")
				.isEqualToComparingFieldByField(newPosition);
		assertThat(robot.getDirection())
				.as("Test place direction")
				.isEqualTo(Direction.SOUTH);
	}

	@Test
	@DisplayName("Make a robot move North")
	public void moveRobotNorthTest() {
		Position newRobotPosition = robot.nextRobotPosition();
		Position newPosition = new Position(2, 3);
		assertThat(newRobotPosition)
				.as("Test move position")
				.isEqualToComparingFieldByField(newPosition);
		assertThat(robot.getDirection())
				.as("Test move direction")
				.isEqualTo(Direction.NORTH);
	}

	@Test
	@DisplayName("Make a robot move South")
	public void moveRobotSouthTest() {
		robot.setDirection(Direction.SOUTH);
		Position newRobotPosition = robot.nextRobotPosition();
		Position newPosition = new Position(2, 1);
		assertThat(newRobotPosition)
				.as("Test move position")
				.isEqualToComparingFieldByField(newPosition);
		assertThat(robot.getDirection())
				.as("Test move direction")
				.isEqualTo(Direction.SOUTH);
	}

	@Test
	@DisplayName("Make a robot move West")
	public void moveRobotWestTest() {
		robot.setDirection(Direction.WEST);
		Position newRobotPosition = robot.nextRobotPosition();
		Position newPosition = new Position(1, 2);
		assertThat(newRobotPosition)
				.as("Test move position")
				.isEqualToComparingFieldByField(newPosition);
		assertThat(robot.getDirection())
				.as("Test move direction")
				.isEqualTo(Direction.WEST);
	}

	@Test
	@DisplayName("Make a robot move East")
	public void moveRobotEastTest() {
		robot.setDirection(Direction.EAST);
		Position newRobotPosition = robot.nextRobotPosition();
		Position newPosition = new Position(3, 2);
		assertThat(newRobotPosition)
				.as("Test move position")
				.isEqualToComparingFieldByField(newPosition);
		assertThat(robot.getDirection())
				.as("Test move direction")
				.isEqualTo(Direction.EAST);
	}

	@Test
	@DisplayName("Test rotate a robot left")
	public void rotateRobotLeftTest() {
		robot.rotateLeft();
		assertThat(robot.getDirection())
				.as("Test rotate a robot")
				.isEqualTo(Direction.WEST);
	}

	@Test
	@DisplayName("Test rotate a robot right")
	public void rotateRobotRightTest() {
		robot.rotateRight();
		assertThat(robot.getDirection())
				.as("Test rotate a robot")
				.isEqualTo(Direction.EAST);
	}
}
