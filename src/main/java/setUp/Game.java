package setUp;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.FirstScreen;
import view.HandHandler;

public class Game {
	
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	private JFrame gameFrame;
	
	private Board board = new Board();
	private Level level;
	//TODO: change to array to support more than 2 players
	private Robot robot1;
	private Robot robot2;

	private boolean gameOn;
	
	public Game() {
		FirstScreen fs = new FirstScreen(this); 
		
		System.out.println("here");
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
		
		board.loadBoard();
		
		initGameScreen();
	}
	
	public void initGameScreen() {
		gameFrame = new JFrame("RobotRally game");
		gameFrame.setLayout(gbl);
		
		c.insets = new Insets(2, 2, 2, 2);
		c.weightx = 0.5;
		
		HandHandler hh1 = new HandHandler(robot1);	
		HandHandler hh2 = new HandHandler(robot2);	
		
		//70 * boardSize
		c.gridx = 0;
		c.gridy = 0;
		gameFrame.add(board, c);
		
		JPanel hands = new JPanel();
		hands.setLayout(new BoxLayout(hands, BoxLayout.Y_AXIS));
		hands.add(hh1);
		hands.add(Box.createRigidArea(new Dimension(0, 25)));
		hands.add(hh2);
		c.gridx = 3;
		c.gridy = 0;
		gameFrame.add(hands, c);
		
		gameFrame.setSize(70 * board.getBoardSize() + 700, 600);
		gameFrame.setResizable(false);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		runGame();
	}
	
	public void runGame() {
		
		//temporary code for testing robot on board
		robot1.setX(2);
		robot1.setY(2);
		
		board.makeMove(robot1, true, 1, false);
		
	}
}
