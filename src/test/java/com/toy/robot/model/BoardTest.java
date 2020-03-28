package com.toy.robot.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
