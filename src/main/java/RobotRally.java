import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import setUp.Board;
import setUp.Level;
import setUp.Card;
import setUp.Deck;
import setUp.Tiles.*;
import view.CardListener;
import view.HandHandler;
import setUp.Robot;

public class RobotRally {
	
	public static void main(String[] args) {
				
		JFrame f = new JFrame("RobotRally game");
		
		Deck deck = new Deck();
		//deck.newHand();
		
		Robot robo = new Robot("dev");
		robo.setX(2);
		robo.setY(2);
		
		Board board = new Board();
		Level hard = new Level("Hard", board);
		
		board.loadBoard();
		
		CardListener listener = new CardListener(board);
		
		HandHandler hh = new HandHandler(robo, deck, listener);
		hh.newHand();
		hh.drawCards();
		
		
		HandHandler hh2 = new HandHandler(robo, deck, listener);
		hh2.newHand();
		hh2.drawCards();
		
		//Robot[] roboArray = new Robot[] {robo}; 
		
		//board.printBoard(roboArray);

		Card card1 = new Card("F1");
	    //card1.executeAction(robo, board);
		
	    
	    f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.add(board);
		f.add(hh);
		f.add(hh2);		
		f.setSize(700, 700);
		f.setResizable(false);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
