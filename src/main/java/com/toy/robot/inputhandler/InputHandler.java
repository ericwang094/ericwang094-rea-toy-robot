package com.toy.robot.inputhandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
	private static final String INPUT_FILE_PATH = "./inputFiles/";
	InputStream inputStream;

	public InputHandler(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return Get commands based on commandLine input
	 */
	public List<String> getCommands(String[] args) {
		switch (args.length) {
			case 0:
				return getCommandsFromCommandLine();
			case 1:
				return getCommandLineFromFile(args[0]);
			default:
				return new ArrayList<String>();
		}
	}

	/**
	 * @return A list of valid commands from command line
	 */
	private List<String> getCommandsFromCommandLine() {
		Scanner scanner = new Scanner(inputStream);
		System.out.println("ToyGame started");
		System.out.println("Please input command");
		System.out.println("Invalid input will be ignored, CTRL + D to execute command, enjoy");
		return filterCommandFromInput(scanner);
	}

	/**
	 *
	 * @param filePath This is the file path that will be used to get command
	 * @return A list of valid command
	 */
	private List<String> getCommandLineFromFile(String filePath) {
		List<String> commandList = new ArrayList<>();
		try {
			File file = new File(INPUT_FILE_PATH + filePath);
			Scanner scanner = new Scanner(file);
			commandList = filterCommandFromInput(scanner);
			return commandList;
		} catch (IOException e) {
			System.out.println("Cannot read content from file");
			return commandList;
		}
	}

	/**
	 * @param scanner This is the scanner to get input
	 * @return A list of valid command
	 */
	private List<String> filterCommandFromInput(Scanner scanner) {
		List<String> commandList = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String commandLine = scanner.nextLine();
			if (!InputValidator.validateInput(commandLine)) {
				continue;
			}
			commandList.add(commandLine.toUpperCase().trim());
		}
		return commandList;
	}
}
