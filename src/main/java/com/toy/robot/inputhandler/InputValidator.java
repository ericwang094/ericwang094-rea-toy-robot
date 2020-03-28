package com.toy.robot.inputhandler;

import com.toy.robot.command.Command;
import com.toy.robot.model.Direction;

public class InputValidator {
	/**
	 * @param input This is the raw input command string
	 * @return Whether the input comment is valid or not
	 */
	public static boolean validateInput(String input) {
		String inputVal = input.trim();
		// input should not be empty
		if (inputVal.equals("")) {
			return false;
		}

		String[] placeArgs = inputVal.split("\\s");

		if (placeArgs.length > 0 && placeArgs[0].toUpperCase().equals(Command.PLACE.name())) {
			return validatePlaceCommand(placeArgs);
		} else {
			return validateCommand(inputVal);
		}
	}

	/**
	 * @param stringArray This is the raw input string array
	 * @return Whether the Place command is valid or not
	 */
	private static boolean validatePlaceCommand(String[] stringArray) {
		// ensure input string array is not empty
		if (stringArray.length == 0) {
			return false;
		}

		// ensure PLACE command has 3 elements follows
		String[] positionDirectionArray = stringArray[1].split(",");
		if (positionDirectionArray.length != 3) {
			return false;
		}

		// ensure the Direction is valid
		String directionStr = positionDirectionArray[2];
		if (!validateDirectionInput(directionStr)) {
			return false;
		}

		return true;
	}

	/**
	 * @param directionStr This is the raw input command string
	 * @return Whether it is a valid direction
	 */
	private static boolean validateDirectionInput(String directionStr) {
		boolean match = false;
		Direction[] allDirections = Direction.values();
		for (Direction direction : allDirections) {
			if (directionStr.trim().toUpperCase().equals(direction.name())) {
				match = true;
			}
		}

		return match;
	}

	/**
	 * @param commandStr This is the raw input command string
	 * @return Whether it is a valid command
	 */
	private static boolean validateCommand(String commandStr) {
		boolean match = false;
		Command[] commandArray = Command.values();
		for (Command c : commandArray) {
			if (commandStr.trim().toUpperCase().equals(c.name())) {
				match = true;
			}
		}
		return match;
	}
}
