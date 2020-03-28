package com.toy.robot.inputhandler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
	@Test
	@DisplayName("Valid empty input")
	public void validateInputWithEmptyInput() {
		String input = " ";
		boolean validResult = InputValidator.validateInput(input);
		assertThat(validResult)
				.as("Valid empty input, should return false")
				.isFalse();
	}

	@Test
	@DisplayName("Valid Incorrect Place command")
	public void validateInputWithInvalidPlace() {
		String input = "PLACE";
		boolean validResult = InputValidator.validateInput(input);
		assertThat(validResult)
				.as("Valid Incorrect Place command, should return false")
				.isFalse();
	}

	@Test
	@DisplayName("Valid Incorrect Place command")
	public void validateInputWithInvalidPlace2() {
		String input = "PLACE 0";
		boolean validResult = InputValidator.validateInput(input);
		assertThat(validResult)
				.as("Valid Incorrect Place command, should return false")
				.isFalse();
	}

	@Test
	@DisplayName("Valid Incorrect Place command with wrong direction")
	public void validateInputWithInvalidPlaceWrongDirection() {
		String input = "PLACE 0,0,WRONGDIRECTION";
		boolean validResult = InputValidator.validateInput(input);
		assertThat(validResult)
				.as("Valid Incorrect Place command with wrong direction")
				.isFalse();
	}

	@Test
	@DisplayName("Valid correct Place command ")
	public void validateCorrectPlace() {
		String input = "PLACE 0,0,NORTH";
		boolean validResult = InputValidator.validateInput(input);
		assertThat(validResult)
				.as("Valid Incorrect Place command with wrong direction")
				.isTrue();
	}
}
