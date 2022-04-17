package setUp;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import view.FirstScreen;
import view.HandHandler;

public class Game {
	
	private boolean gameOn;
	
	private Board board = new Board();
	private Level level;
	//TODO: change to array to support more than 2 players
	private Robot robot1;
	private Robot robot2;

	
	public Game() {
		FirstScreen fs = new FirstScreen(this); 
	}
	
	public void setGameStatus(boolean b) {
		this.gameOn = b;
	}
	
	public boolean getGameStatus(){
		return gameOn;
	}
	
	public void gameStart(String newLevel, String p1, String p2) {
		setGameStatus(true);
	
		if (newLevel == "easy") {
		  	level = new Level("Easy", board);
		  	
		  	robot1 = new Robot(p1, 5);
			robot2 = new Robot(p2, 5);
		  	}
		else if (newLevel == "mid") {
		  	level = new Level("Medium", board);
		  	
		  	robot1 = new Robot(p1, 3);
			robot2 = new Robot(p2, 3);
		  	}
		else if (newLevel == "hard") {
		  	level = new Level("Hard", board);
		  	
		  	robot1 = new Robot(p1, 1);
			robot2 = new Robot(p2, 1);
		}
		
		gameScreen();
	}
	
	public void gameScreen() {
		JFrame f = new JFrame("RobotRally game");
		
		
		Deck deck = new Deck();
		deck.newHand();
		board.loadBoard();
		
		HandHandler hh1 = new HandHandler(robot1);	
		hh1.drawCards(robot1.getDeck().getHand());
		
		HandHandler hh2 = new HandHandler(robot2);	
		hh2.drawCards(robot2.getDeck().getHand());
	
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.add(board);
		f.add(hh1);
		f.add(hh2);
		f.setSize(1000, 700);
		f.setResizable(false);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
