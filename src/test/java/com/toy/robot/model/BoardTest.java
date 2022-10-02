package com.toy.robot.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
	@Test
	@DisplayName("Test valid move")
	public void testIsValidMove() {
		Board board = new Board(5, 5);
		assertThat(board.isValidMove(new Position(3, 3)))
				.as("Valid move")
				.isTrue();
		assertThat(board.isValidMove(new Position(6, 6)))
				.as("invalid move")
				.isFalse();
		assertThat(board.isValidMove(new Position(-1, -1)))
				.as("invalid move")
				.isFalse();
		assertThat(board.isValidMove(new Position(6, 3)))
				.as("invalid move")
				.isFalse();
		assertThat(board.isValidMove(new Position(3, -1)))
				.as("invalid move")
				.isFalse();
		assertThat(board.isValidMove(new Position(3, 6)))
				.as("Valid move")
				.isFalse();
	}

	@Test
	@DisplayName("Test valid move with obstacle move")
	public void testValidObstacleMove() {
		Board board = new Board(5, 5);
		List<Position> obstacleList = new ArrayList<>();
		Position obstacle = new Position(3, 3);
		obstacleList.add(obstacle);

		board.setObstacleList(obstacleList);

		assertThat(board.isValidMove(new Position(0, 1)))
				.as("Valid move")
				.isTrue();
	}

	@Test
	@DisplayName("Test invalid move with obstacle move")
	public void testInvalidObstacleMove() {
		Board board = new Board(5, 5);
		List<Position> obstacleList = new ArrayList<>();
		Position obstacle = new Position(0, 1);
		obstacleList.add(obstacle);

		board.setObstacleList(obstacleList);

		assertThat(board.isValidMove(new Position(0, 1)))
				.as("Invalid move")
				.isFalse();
	}
}
