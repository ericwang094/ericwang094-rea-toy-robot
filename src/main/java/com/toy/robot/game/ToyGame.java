package com.toy.robot.game;

import com.toy.robot.exception.ToyRobotInvalidPlaceException;
import com.toy.robot.model.Board;
import com.toy.robot.model.Direction;
import com.toy.robot.model.Position;
import com.toy.robot.model.Robot;

public class ToyGame {
	private Board board;
	private Robot robot;

	public ToyGame(Board board, Robot robot) {
		this.board = board;
		this.robot = robot;
	}

	/**
	 * Place the robot into a place
	 * @param position This is the new location that the robot will be in
	 * @param direction This is the direction that the robot will face
	 * @throws ToyRobotInvalidPlaceException Throws exception if the board/robot doesn't exist
	 */
	public void placeRobot(Position position, Direction direction) throws ToyRobotInvalidPlaceException {
		if (this.board == null || this.robot == null || position == null) {
			throw new ToyRobotInvalidPlaceException(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
		}
		if (!this.board.isValidMove(position)) {
			throw new ToyRobotInvalidPlaceException(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
		}
		robot.placeRobot(position, direction);
	}

	/**
	 * Move the robot forward
	 * @throws ToyRobotInvalidPlaceException Throws exception if the board/robot doesn't exist
	 */
	public void makeMove() throws ToyRobotInvalidPlaceException {
		if (this.board == null || this.robot == null || this.robot.getPosition() == null) {
			throw new ToyRobotInvalidPlaceException(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
		}

		Position newPosition = robot.makeMove();
		if (!this.board.isValidMove(newPosition)) {
			throw new ToyRobotInvalidPlaceException(ToyRobotInvalidPlaceException.INVALID_PLACE_ERR_MSG);
		}
		robot.makeMove();
	}
}
