package com.toy.robot.model;

public class Robot {
	private Position position;
	private Direction direction;

	public Robot() {}

	public Robot(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void placeRobot(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public Position makeMove() {
		return this.position.forwardPosition(direction);
	}

	/**
	 * rotate robot direction to left
	 */
	public void rotateLeft() {
		this.direction =  this.direction.rotateLeft();
	}

	/**
	 * rotate robot direction to right
	 */
	public void rotateRight() {
		this.direction = this.direction.rotateRight();
	}
}
