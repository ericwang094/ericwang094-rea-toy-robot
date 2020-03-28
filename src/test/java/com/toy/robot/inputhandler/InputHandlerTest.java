package com.toy.robot.inputhandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
	private InputHandler inputHandler;
	private InputStream inputStream;

	@BeforeEach
	public void setup() {
		inputHandler = new InputHandler(inputStream);
	}

	@Test
	@DisplayName("Test get input from command line")
	public void getCommandsTest() {
		List<String> inputCommandList = prepareTestInputString();
		inputHandler.inputStream = new ByteArrayInputStream(prepareTestInput(inputCommandList).getBytes());
		List<String> commandList = inputHandler.getCommands(new String[]{});
		List<String> benchMark = prepareTestInputString();
		assertThat(commandList)
				.as("Two command should be the same")
				.isEqualTo(benchMark);
	}

	@Test
	@DisplayName("Test get input from command line with 1 incorrect command")
	public void getCommandsTestWithOneIncorrectCommand() {
		List<String> inputCommandList = prepareTestInputStringWithOneInvalidCommand();
		inputHandler.inputStream = new ByteArrayInputStream(prepareTestInput(inputCommandList).getBytes());
		List<String> commandList = inputHandler.getCommands(new String[]{});
		List<String> benchMark = prepareTestInputString();
		assertThat(commandList)
				.as("Two command should be the same")
				.isEqualTo(benchMark);
	}

	@Test
	@DisplayName("Test get input from File")
	public void getCommandsFileTest() {
		List<String> inputCommandList = prepareTestInputString();
		inputHandler.inputStream = new ByteArrayInputStream(prepareTestInput(inputCommandList).getBytes());
		List<String> commandList = inputHandler.getCommands(new String[]{"inputText.txt"});
		List<String> benchMark = prepareTestInputString();
		assertThat(commandList)
				.as("Two command should be the same")
				.isEqualTo(benchMark);
	}

	@Test
	@DisplayName("Test get input from File with 1 wrong command")
	public void getCommandsFileTestWithOneWrongCommand() {
		List<String> inputCommandList = prepareTestInputString();
		inputHandler.inputStream = new ByteArrayInputStream(prepareTestInput(inputCommandList).getBytes());
		List<String> commandList = inputHandler.getCommands(new String[]{"inputTextWithWrongInput"});
		List<String> benchMark = prepareTestInputString();
		assertThat(commandList)
				.as("Test get input from File with 1 wrong command")
				.isEqualTo(benchMark);
	}

	private String prepareTestInput(List<String> testInputList) {
		StringBuilder sb = new StringBuilder();

		for (String s : testInputList) {
			sb.append(s).append("\n");
		}

		return sb.toString();
	}

	private List<String> prepareTestInputString() {
		List<String> list = new ArrayList<>();
		list.add("PLACE 0,0,NORTH");
		list.add("LEFT");
		list.add("MOVE");
		list.add("REPORT");
		return list;
	}

	private List<String> prepareTestInputStringWithOneInvalidCommand() {
		List<String> list = new ArrayList<>();
		list.add("PLACE 0,0,NORTH");
		list.add("LEFT");
		list.add("asdf");
		list.add("MOVE");
		list.add("REPORT");
		return list;
	}
}
