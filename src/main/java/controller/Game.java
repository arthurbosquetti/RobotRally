package controller;

import view.BoardScreen;
import view.EndScreen;
import view.FirstScreen;
import view.FlagView;
import view.GameScreen;
import view.HandHandler;
import view.LifeView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import view.CoinFlip;
import model.AI;
import model.Board;
import model.Card;
import model.Level;
import model.Robot;

//TODO: add singleton principle code
public class Game {
	private GameScreen gs;
	private HandHandler hh1, hh2;
	private LifeView lv1, lv2;
	private FlagView fv1, fv2;
	private BoardScreen bs;
	private Board board = new Board();
	private Level level;
	private Robot robot1, robot2;
	private boolean isRobot1AI = false;
	private boolean isRobot2AI = false;
	
	private boolean gameOn;
	
	public Game() { FirstScreen fs = new FirstScreen(this); }
	
	public void setGameStatus(boolean b) { this.gameOn = b; }
	
	public boolean getGameStatus() { return gameOn; }
	
	public void setP1AI(boolean b) { this.isRobot1AI = b;}
	
	public void setP2AI(boolean b) { this.isRobot2AI = b;}
	
	public void robotInitializer(int lives, String name1, String name2) {

		if (isRobot1AI && isRobot2AI){
			robot1 = new AI(name1, lives, this, board);
			((AI) robot1).setFlagPosition(board);
			robot2 = new AI(name2, lives, this, board);
			((AI) robot2).setFlagPosition(board);
			}
		
		else if (isRobot1AI & !isRobot2AI) {
			robot1 = new AI(name1, lives, this, board);	
			((AI) robot1).setFlagPosition(board);
			
			robot2=  new Robot(name2, lives, this, board);
		}
		else if (isRobot2AI & !isRobot1AI) {
			robot1 =  new Robot(name1, lives, this, board);
			robot2 = new AI(name2, lives, this, board);
			((AI) robot2).setFlagPosition(board);


		}
		else{
			robot1 = new Robot(name1, lives, this, board);
			robot2 = new Robot(name2, lives, this, board );
	  	}
		
		lv1 = new LifeView(lives, 1);
	  	lv2 = new LifeView(lives, 2);
	}
	
	public void gameStart(String newLevel, String name1, String name2) {
		setGameStatus(true);
	
		if (Objects.equals(newLevel, "easy")) {
			
		  	level = new Level("Easy", board);
		  	BoardScreen.setLevel("easy");
		  	robotInitializer(5, name1, name2);
		  	
		} else if (Objects.equals(newLevel, "medium")) {
		  	level = new Level("Medium", board);
		  	BoardScreen.setLevel("medium");
		  	robotInitializer(3, name1, name2);
		}
		else if (Objects.equals(newLevel, "hard")) {
		  	level = new Level("Hard", board);
		  	BoardScreen.setLevel("hard");
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
	
	//initializes the game JFrame with all Components
	public void initGameScreen() {
		gs = new GameScreen();
		
		hh1 = new HandHandler(robot1, this);	
		hh2 = new HandHandler(robot2, this);	
		
		fv1 = new FlagView();
		fv2 = new FlagView();
		
		bs = new BoardScreen(board);
		bs.addRobots(robot1, robot2);
		
		gs.initGameScreen(bs, new LifeView[] {lv1,lv2}, new HandHandler[] {hh1, hh2}, new FlagView[] {fv1, fv2});
	}
	
	//makes moves from the cards the players selected
	public void makeMoves() {
		
    	//removes submit button if it still exists
		hh1.removeButton(9);
		hh2.removeButton(9);

		int robot1Lives = robot1.getLives();
		int robot2Lives = robot2.getLives();
		
		boolean[] robot1Flags = new boolean[] {robot1.getFlag1(), robot1.getFlag2()};
		boolean[] robot2Flags = new boolean[] {robot2.getFlag1(), robot2.getFlag2()};
		
		ArrayList<Card> choosen1 = robot1.getDeck().getChoosen();
		ArrayList<Card> choosen2 = robot2.getDeck().getChoosen();
	
		//use AI method if robot1 it's an AI
		if (isRobot1AI) {
			((AI) robot1).setPossibleHands(robot1.getDeck().getHand());
			choosen1 = ((AI) robot1).findSuggestedCardChoice(board);
		}
		//use regular method otherwise
		else {choosen1 = robot1.getDeck().getChoosen();}
		
		//use AI method if robot2 it's an AI
		if (isRobot2AI) {
			((AI) robot2).setPossibleHands(robot2.getDeck().getHand());
			choosen2 = ((AI) robot2).findSuggestedCardChoice(board);
		}
		//use regular method otherwise
		else {choosen2 = robot2.getDeck().getChoosen();}
							
		System.out.println(robot1.getName()+" Deck= "+robot1.getDeck().getHand());
		System.out.println(robot2.getName()+" Deck= "+robot2.getDeck().getHand());

		
		for (int i = 0; i < 5; i++) {
			
			System.out.println(robot1.getName()+" Card = "+choosen1.get(i));
			System.out.println(robot2.getName()+" Card = "+choosen2.get(i));

			makeMove(i, choosen1.get(i), choosen2.get(i));
			
			if (robot1.getLives() <= 0 || robot1.getLives() <= 0 || robot1.getWinner()== true || robot2.getWinner()== true) {
				this.gameEnd();
				break;
			}
			
//				System.out.println("AI is at ("+robot1.getX()+","+robot1.getY()+","+robot1.canMove()+")");
//				System.out.println(((AI) robot1).getFlagPosition(((AI) robot1).getFlag1()));

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {  }
			
		}
		
		if (robot1.getLives() != robot1Lives) { lv1.removeLife(); };
		if (robot2.getLives() != robot2Lives) { lv2.removeLife(); };
		
		if(robot1.getFlag1() != robot1Flags[0]) { fv1.addFlag(1); } 
		else if (robot1.getFlag2() != robot1Flags[1]) { fv1.addFlag(2); }
		
		if(robot2.getFlag1() != robot2Flags[0]) { fv2.addFlag(1); } 
		else if (robot2.getFlag2() != robot2Flags[1]) { fv2.addFlag(2); }
		
		robot1.setCanMove(true);
		robot2.setCanMove(true);
	}
	
	//checks if both robots are done selecting their cards
	public boolean checkMoves() {
		if (!(robot1.getDeck().canChoose()) & !(robot2.getDeck().canChoose())) {
			return true;
		}
		return false;
	}
	
	public void makeMove(int i, Card choosen1, Card choosen2) {		
		bs.removeRobots(robot1, robot2);
		
		if (robot1.canMove()) { choosen1.executeAction(robot1, board); }
				
		if (robot2.canMove()) { choosen2.executeAction(robot2, board); }
		
		bs.addRobots(robot1, robot2);
	}
	
	public void newRound() {
		robot1.getDeck().newHand();
		robot2.getDeck().newHand();
		
		gs.newRound();
	}
	
	//this always hurts robot2, what did robot2 do wrong?
	public void hurtOtherPlayer(Robot robot) {
		if (robot == robot1) {
			robot2.hurt(1);
		}
		else if (robot == robot2) {
			robot1.hurt(1);
		}
	}
	
	public int[] findOtherPlayer(Robot robot) {
		if (robot == robot1) {
			int[] other = new int[2];
			other[0] = robot2.getX();
			other[1] = robot2.getY();
			return other;
		}
		else if (robot == robot2) {
			int[] other = new int[2];
			other[0] = robot1.getX();
			other[1] = robot1.getY();
			return other;
		}
		return null;
	}
	
	public void gameEnd(){
		System.out.println("robot.getWinner() =("+robot1.getWinner()+","+robot2.getWinner()+")");
		System.out.println("robot.getFlags() =({"+robot1.getFlag1()+","+robot1.getFlag2()+"}, {"+robot2.getFlag1()+","+robot2.getFlag2()+"})");

		
		if ((robot1.isAlive() == false && robot2.isAlive() == false)||(robot1.getWinner() == true && robot2.getWinner() == true)){
			CoinFlip cf = new CoinFlip(robot1.getName(), robot2.getName());
		}
		else if (robot1.isAlive() == false || robot2.getWinner()== true) {
			EndScreen es = new EndScreen(robot2.getName());
		}
		else if (robot2.isAlive() == false || robot1.getWinner()== true) {
			EndScreen es = new EndScreen(robot1.getName());
		} else {
			newRound();
		}
	}
}



