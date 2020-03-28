package com.toy.robot.exception;

public class ToyRobotInvalidPlaceException extends Exception {
	public static final String INVALID_PLACE_ERR_MSG = "Ops, your robot is falling off table, please place it again";
	public ToyRobotInvalidPlaceException(String string) {
		super(string);
	}
}
