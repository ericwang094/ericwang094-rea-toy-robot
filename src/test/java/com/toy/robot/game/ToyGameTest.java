package com.toy.robot.game;

import com.toy.robot.exception.ToyRobotInvalidPlaceException;
import com.toy.robot.model.Board;
import com.toy.robot.model.Direction;
import com.toy.robot.model.Position;
import com.toy.robot.model.Robot;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ToyGameTest {
	@Test
	public void testPlaceRobot() {
		Board board = new Board(3, 3);
		Robot robot = null;
		ToyGame toyGame = new ToyGame(board, robot);

		assertThatThrownBy(()-> {
			toyGame.placeRobot(new Position(3,3), Direction.NORTH);
		}).as("Test place robot with null robot")
		.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);

		board = null;
		robot = new Robot(new Position(3, 3), Direction.NORTH);
		ToyGame toyGame2 = new ToyGame(board, robot);
		assertThatThrownBy(()-> {
			toyGame2.placeRobot(new Position(3,3), Direction.NORTH);
		}).as("Test place robot with null board")
				.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);

		board = new Board(4, 4);
		robot = new Robot(new Position(3, 3), Direction.NORTH);
		ToyGame toyGame3 = new ToyGame(board, robot);
		assertThatThrownBy(()-> {
			toyGame3.placeRobot(new Position(6,6), Direction.NORTH);
		}).as("Test place robot with invalid position")
				.hasMessage(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);

		board = new Board(4, 4);
		robot = new Robot(new Position(3, 3), Direction.NORTH);
		ToyGame toyGame4 = new ToyGame(board, robot);
		toyGame4.placeRobot(new Position(2,2), Direction.NORTH);

	}
}
