package setUp;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import view.HandHandler;

public class Game {
	private boolean gameOn;
	Board board = new Board();
	HandHandler hh = new HandHandler();
	
	public void setGameStatus(boolean b) {
		this.gameOn = b;
	}
	public boolean getGameStatus(){
		return gameOn;
	}
	
	
	public void gameStart(String level, String p1, String p2) {
		setGameStatus(true);
	
		if (level == "easy") {
		  	Level easy = new Level("Easy", board);
		  	
		  	Player player1 = new Player(p1, 5);
		  	Player player2 = new Player(p2, 5);
		  	}
		else if (level == "mid") {
		  	Level easy = new Level("Medium", board);
		  	
		  	Player player1 = new Player(p1, 3);
		  	Player player2 = new Player(p2, 3);
		  	}
		else if (level == "hard") {
		  	Level easy = new Level("Hard", board);
		  	
		  	Player player1 = new Player(p1, 1);
		  	Player player2 = new Player(p2, 1);
		  	}
		
		gameScreen();
	}
	
	public void gameScreen() {
		JFrame f = new JFrame("RobotRally game");
		Deck deck = new Deck();
		deck.newHand();
		board.loadBoard();
		
		hh.drawNewHand(deck.getHand());
	
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.add(board);
		f.add(hh);
		f.setSize(1000, 700);
		f.setResizable(false);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
