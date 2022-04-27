package controller;

import view.BoardScreen;
import view.EndScreen;
import view.FirstScreen;
import view.GameScreen;
import view.HandHandler;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import model.AI;
import model.Board;
import model.Card;
import model.Level;
import model.Robot;

//TODO: add singleton principle code
public class Game {
	
	private GameScreen gs;
	
	private HandHandler hh1, hh2;
	
	private BoardScreen bs;
	
	private Board board = new Board();
	private Level level;
	private Robot robot1, robot2;
	private boolean isRobot1AI =false;
	private boolean isRobot2AI = false;
	
	private boolean gameOn;
	
	public Game() { FirstScreen fs = new FirstScreen(this); }
	
	public void setGameStatus(boolean b) { this.gameOn = b; }
	
	public boolean getGameStatus() { return gameOn; }
	
	public void setP1AI(boolean b) { this.isRobot1AI = b;}
	
	public void setP2AI(boolean b) { this.isRobot2AI = b;}
	
	public void robotInitializer(int lives, String name1, String name2) {

		if (isRobot1AI && isRobot2AI){
			robot1 = new AI(name1, lives);
			robot2 = new AI(name2, lives);
		}
		
		else if (isRobot1AI) {
			robot1 = new AI(name1, lives);
			robot2=  new Robot(name2, lives);
		}
		else if (isRobot2AI) {
			robot1 =  new Robot(name1, lives);
			robot2 = new AI(name2, lives);
		}
		else{
			robot1 = new Robot(name1, lives);
			robot2 = new Robot(name2, lives);
	  	}
	}
	
	public void gameStart(String newLevel, String name1, String name2) {
		setGameStatus(true);
	
		if (Objects.equals(newLevel, "easy")) {
			
		  	level = new Level("Easy", board);
		  	
		  	robotInitializer(5, name1, name2);
		  	
		} else if (Objects.equals(newLevel, "mid")) {
		  	level = new Level("Medium", board);
		  	
		  	robotInitializer(3, name1, name2);
		}
		else if (Objects.equals(newLevel, "hard")) {
		  	level = new Level("Hard", board);

		  	robotInitializer(1, name1, name2);
		}
		
		robot1.setNum(1);
		robot2.setNum(2);
		
		robot1.setX(1);
		robot1.setY(BoardScreen.size - 2);
		robot2.setX(BoardScreen.size - 2);
		robot2.setY(BoardScreen.size - 2);
		
		robot1.setSpawn(new int[] {robot1.getX(), robot1.getY()});
		robot2.setSpawn(new int[] {robot2.getX(), robot2.getY()});
		
		board.getTile(1, BoardScreen.size - 2).setRobotOn(robot1);
		board.getTile(BoardScreen.size - 2, BoardScreen.size - 2).setRobotOn(robot2);
		
		initGameScreen();
	}
	
	public void initGameScreen() {
		gs = new GameScreen();
		
		hh1 = new HandHandler(robot1, this);	
		hh2 = new HandHandler(robot2, this);	
		
		bs = new BoardScreen(board, level.getLevel());
		bs.addRobots(robot1, robot2);
		
		gs.initGameScreen(bs, hh1, hh2);
	}
	
	public void playerDone() {
		
		
		if (!(robot1.getDeck().canChoose()) & !(robot2.getDeck().canChoose())) {
			//removes submit button if it still exists
			hh1.removeButton(9);
			hh2.removeButton(9);
			
			ArrayList<Card> choosen1 = robot1.getDeck().getChoosen();
			ArrayList<Card> choosen2 = robot2.getDeck().getChoosen();
			
			//executes moves selected
			System.out.println("starting moves:");
			
			for (int i = 0; i < 5; i++) {
				makeMove(i, choosen1.get(i), choosen2.get(i));
			
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {  }
				
			}
			
			robot1.setGlue(true);
			robot2.setGlue(true);
			gameEnd();
			
			newRound();
		}
	}
	
	public void makeMove(int i, Card choosen1, Card choosen2) {		
		bs.removeRobots(robot1, robot2);
		
		choosen1.executeAction(robot1, board);
		
		choosen2.executeAction(robot2, board);
		
		bs.addRobots(robot1, robot2);
	}
	
	public void newRound() {
		robot1.getDeck().newHand();
		robot2.getDeck().newHand();
		
		gs.newRound();
	}
	
	public void hurtOtherPlayer(Robot robot1) {
		robot2.hurt(1);
	}
	
	public int[] findOtherPlayer(Robot robot1) {
		int[] other = new int[2];
		other[0] = robot2.getX();
		other[1] = robot2.getY();
		return other;
	}
	
	public void gameEnd(){
		if (robot1.isAlive() == false || robot2.getWinner()== true) {
			EndScreen es = new EndScreen(robot2.getName());
		}
		else if (robot2.isAlive() == false || robot1.getWinner()== true) {
			EndScreen es = new EndScreen(robot1.getName());
		}
	}
}
