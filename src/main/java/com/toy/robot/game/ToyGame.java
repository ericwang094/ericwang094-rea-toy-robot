package com.toy.robot.game;

import com.toy.robot.command.Command;
import com.toy.robot.model.Board;
import com.toy.robot.model.Direction;
import com.toy.robot.model.Position;
import com.toy.robot.model.Robot;

import java.util.List;

public class ToyGame {
	private Board board;
	private Robot robot;

	public ToyGame(Board board, Robot robot) {
		this.board = board;
		this.robot = robot;
	}

	public void execute(List<String> commandList) {
		for(String commandString : commandList) {
			if (commandString.startsWith("PLACE")) {
				String[] placeArgs = commandString.split("\\s")[1].split(",");
				Position position = new Position(Integer.parseInt(placeArgs[0]),
						Integer.parseInt(placeArgs[1]));
				Direction direction = Direction.valueOf(placeArgs[2]);
				placeRobot(position, direction);
			} else if (commandString.equals("MOVE")) {
				makeMove();
			} else if(commandString.equals("LEFT") || commandString.equals("RIGHT")) {
				rotate(Command.valueOf(commandString));
			} else if (commandString.equals("REPORT")) {
				report();
			}
		}
	}
	/**
	 * Place the robot into a place
	 * @param position This is the new location that the robot will be in
	 * @param direction This is the direction that the robot will face
	 */
	private void placeRobot(Position position, Direction direction) {
		if (!this.board.isValidMove(position)) {
			return;
		}
		robot.placeRobot(position, direction);
	}

	/**
	 * Move the robot forward
	 */
	private void makeMove() {
		if (this.robot.getPosition() == null) {
			return;
		}

		Position newPosition = robot.makeMove();
		if (!this.board.isValidMove(newPosition)) {
			return;
		}
		robot.setPosition(newPosition);
	}

	/**
	 * Rotate robot's direction
	 * @param command This is the command to rotate robot
	 */
	public void rotate(Command command) {
		if (this.robot.getPosition() == null) {
			return;
		}
		switch(command) {
			case LEFT:
				robot.rotateLeft();
				break;
			case RIGHT:
				robot.rotateRight();
				break;
		}
	}

	/**
	 * Report robot's position and direction
	 */
	private void report() {
		if (this.robot.getPosition() == null) {
			System.out.print("");
			return;
		}

		StringBuilder sb = new StringBuilder();
		Position position = this.robot.getPosition();
		sb.append(position.getX())
				.append(",")
				.append(position.getY())
				.append(",")
				.append(this.robot.getDirection());
		System.out.print(sb.toString());
	}
}
