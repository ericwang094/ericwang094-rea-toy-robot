package com.toy.robot;

import com.toy.robot.game.ToyGame;
import com.toy.robot.inputhandler.InputHandler;
import com.toy.robot.model.Board;
import com.toy.robot.model.Robot;

import java.util.List;

public class ToyRobotApp {
	private static final int SIZE_X = 5;
	private static final int SIZE_Y = 5;

	public static void main(String[] args) {
		new ToyRobotApp().startGame(args);
	}

	/**
	 * Start game
	 * @param args This is the args that can provide input file
	 */
	public void startGame(String[] args) {
		List<String> inputCommands = new InputHandler(System.in).getCommands(args);

		Board board = new Board(SIZE_X, SIZE_Y);
		Robot robot = new Robot();
		ToyGame toyGame = new ToyGame(board, robot);
		toyGame.execute(inputCommands);
	}
}
