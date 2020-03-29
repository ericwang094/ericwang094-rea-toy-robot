package com.toy.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
		String input = "input1.txt";
		toyRobotApp.startGame(new String[]{input});
		assertThat(outContent.toString())
				.isEqualTo("0,1,NORTH");
	}

	@Test
	@DisplayName("Toy game test 2")
	public void testToyGameSet2(){
		String input = "input2.txt";
		toyRobotApp.startGame(new String[]{input});
		assertThat(outContent.toString())
				.isEqualTo("0,0,WEST");
	}

	@Test
	@DisplayName("Toy game test 3")
	public void testToyGameSet3(){
		String input = "input3.txt";
		toyRobotApp.startGame(new String[]{input});
		assertThat(outContent.toString())
				.isEqualTo("3,3,NORTH");
	}

	@Test
	@DisplayName("Toy game test 4")
	public void testToyGameSet4(){
		String input = "input4.txt";
		toyRobotApp.startGame(new String[]{input});
		assertThat(outContent.toString())
				.isEqualTo("0,0,EAST");
	}

	@Test
	@DisplayName("Toy game test place out of bound")
	public void testToyGameSet5(){
		String input = "input5.txt";
		toyRobotApp.startGame(new String[]{input});
		assertThat(outContent.toString())
				.isEqualTo("");
	}

	@Test
	@DisplayName("Toy game test game not start with place")
	public void testToyGameSet6(){
		String input = "input6.txt";
		toyRobotApp.startGame(new String[]{input});
		assertThat(outContent.toString())
				.isEqualTo("");
	}

	@Test
	@DisplayName("Toy game test game move to out of bound")
	public void testToyGameSet7(){
		String input = "input7.txt";
		toyRobotApp.startGame(new String[]{input});
		assertThat(outContent.toString())
				.isEqualTo("4,4,NORTH");
	}
}
