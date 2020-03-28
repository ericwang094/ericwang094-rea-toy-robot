package com.toy.robot;

import com.toy.robot.exception.ToyRobotInvalidPlaceException;
import com.toy.robot.ToyRobotApp;
import com.toy.robot.game.ToyGame;
import com.toy.robot.model.Board;
import com.toy.robot.model.Direction;
import com.toy.robot.model.Position;
import com.toy.robot.model.Robot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

public class ToyRobotAppTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	ToyRobotApp toyRobotApp;
	@BeforeEach
	public void setup() {
		System.setOut(new PrintStream(outContent));

		toyRobotApp = new ToyRobotApp();
	}

	@Test
	@DisplayName("Toy game test 1")
	public void testToyGameSet1(){
		String input1 = "input1.txt";
		toyRobotApp.startGame(new String[]{input1});
		assertThat(outContent.toString())
				.isEqualTo("0,1,NORTH");
	}

	@Test
	@DisplayName("Toy game test 2")
	public void testToyGameSet2(){
		String input1 = "input2.txt";
		toyRobotApp.startGame(new String[]{input1});
		assertThat(outContent.toString())
				.isEqualTo("0,0,WEST");
	}

	@Test
	@DisplayName("Toy game test 3")
	public void testToyGameSet3(){
		String input1 = "input3.txt";
		toyRobotApp.startGame(new String[]{input1});
		assertThat(outContent.toString())
				.isEqualTo("3,3,NORTH");
	}

	@Test
	@DisplayName("Toy game test 4")
	public void testToyGameSet4(){
		String input1 = "input4.txt";
		toyRobotApp.startGame(new String[]{input1});
		assertThat(outContent.toString())
				.isEqualTo("0,0,EAST");
	}

	@Test
	@DisplayName("Toy game test place out of bound")
	public void testToyGameSet5(){
		String input1 = "input5.txt";
		toyRobotApp.startGame(new String[]{input1});
		assertThat(outContent.toString())
				.isEqualTo("");
	}
}
