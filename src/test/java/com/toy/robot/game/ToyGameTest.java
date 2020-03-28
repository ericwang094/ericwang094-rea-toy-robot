package com.toy.robot.game;

import com.toy.robot.exception.ToyRobotInvalidPlaceException;
import com.toy.robot.model.Board;
import com.toy.robot.model.Direction;
import com.toy.robot.model.Position;
import com.toy.robot.model.Robot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

public class ToyGameTest {
	@Test
	@DisplayName("Test place robot with null robot")
	public void testPlaceRobotFail1() {
		Board board = new Board(3, 3);
		Robot robot = null;
		ToyGame toyGame = new ToyGame(board, robot);

		assertThatThrownBy(()-> {
			toyGame.placeRobot(new Position(3,3), Direction.NORTH);
		}).as("Test place robot with null robot")
		.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
	}

	@Test
	@DisplayName("Test place robot with null board")
	public void testPlaceRobotFail2() {
		Board board = null;
		Robot robot = new Robot(new Position(3, 3), Direction.NORTH);

		ToyGame toyGame = new ToyGame(board, robot);
		assertThatThrownBy(()-> {
			toyGame.placeRobot(new Position(3,3), Direction.NORTH);
		}).as("Test place robot with null board")
				.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
	}

	@Test
	@DisplayName("Test place robot with invalid position")
	public void testPlaceRobotFail3() {
		Board board = new Board(4, 4);
		Robot robot = new Robot(new Position(3, 3), Direction.NORTH);
		ToyGame toyGame = new ToyGame(board, robot);
		assertThatThrownBy(()-> {
			toyGame.placeRobot(new Position(6,6), Direction.NORTH);
		}).as("Test place robot with invalid position")
				.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
	}

	@Test
	@DisplayName("Test place robot")
	public void testPlaceRobot(){
		Board board = new Board(4, 4);
		Robot robot = new Robot(new Position(3, 3), Direction.NORTH);
		ToyGame toyGame = new ToyGame(board, robot);
		assertThatCode(()-> {
			toyGame.placeRobot(new Position(2,2), Direction.NORTH);
		}).as("Test place robot with invalid position").doesNotThrowAnyException();
	}

	@Test
	@DisplayName("Test make move with null robot")
	public void testMakeMoveFailWithNullRobot(){
		Board board = new Board(3, 3);
		Robot robot = null;
		ToyGame toyGame = new ToyGame(board, robot);
		assertThatThrownBy(()->{
			toyGame.makeMove();
		}).as("Test make move fail with null robot")
		.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
	}

	@Test
	@DisplayName("Test make move fail with null board")
	public void testMakeMoveFailWithNullBoard(){
		Board board = null;
		Robot robot = new Robot(new Position(3, 3), Direction.NORTH);

		ToyGame toyGame = new ToyGame(board, robot);
		assertThatThrownBy(()->{
			toyGame.makeMove();
		}).as("Test make move fail with null board")
				.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
	}

	@Test
	@DisplayName("Test make move fail with invalid position")
	public void testMakeMoveFailWithInvalidPosition(){
		Board board = new Board(3, 3);
		Robot robot = new Robot(new Position(7, 7), Direction.NORTH);

		ToyGame toyGame = new ToyGame(board, robot);
		assertThatThrownBy(toyGame::makeMove).as("Test make move fail with invalid position")
				.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
	}

	@Test
	@DisplayName("Test make move")
	public void testMakeMove(){
		Board board = new Board(4, 4);
		Robot robot = new Robot(new Position(2, 2), Direction.NORTH);
		ToyGame toyGame = new ToyGame(board, robot);
		assertThatCode(toyGame::makeMove).as("Test place robot with invalid position").doesNotThrowAnyException();
	}
}
