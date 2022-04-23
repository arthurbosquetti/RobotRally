import io.cucumber.java.en.When;
import setUp.AI;
import setUp.Board;
import setUp.Level;
import setUp.Card;
import setUp.Deck;
import setUp.Tiles.*;
import setUp.Robot;

public class RobotRally {
	
	public static void main(String[] args) {
			
			Board board = new Board();
			new Level("Easy", board);
			
			Board board2 = board;
			
//			Robot robo = new Robot("Robo");
//			robo.setX(3);
//			robo.setY(3);
			
			
			AI ai = new AI("AI");
			ai.setX(3);
			ai.setY(3);
			
			
			ai.setFlagPosition(board);
			
			AI ai2 = ai;
			
			board.printBoard(ai);
			board2.printBoard(ai2);
			int i=0;
			
			while (!ai.getFlag1()) {
				i++;
				System.out.println(i);
				
				System.out.println("GOAL 1= "+ ai.getFlagPosition(ai.getFlag1()));
				System.out.println("GOAL 2= "+ ai2.getFlagPosition(ai2.getFlag1()));
				Deck deck = new Deck();
				deck.newHand();
				
				System.out.println(deck.getHand());
				ai.setPossibleHands(deck.getHand());
				Card[] chosenHand = ai.findSuggestedCardChoice(board);
				//System.out.println("R  = ("+robo.getX()+","+robo.getY()+")" +", d="+robo.getDir());
			    System.out.println("AI = ("+ai.getX()+","+ai.getY()+")"+", d="+ai.getDir());
			    System.out.println("AI = ("+ai2.getX()+","+ai2.getY()+")"+", d="+ai2.getDir());
			    
			    for (Card c : chosenHand) {
					System.out.print(c + " ");
			    }
			    //System.out.println("");
			    
				for (Card c : chosenHand) {
					System.out.println(c);
				    //c.executeAction(robo, board);
				    //System.out.println("R = ("+robo.getX()+","+robo.getY()+")" );
				    c.executeAction(ai, board);
				    System.out.println("AI  = ("+ai.getX()+","+ai.getY()+")"+", d ="+ai.getDir());
				    c.executeAction(ai2, board2);
				    System.out.println("AI2 = ("+ai2.getX()+","+ai2.getY()+")"+", d2="+ai2.getDir());
				}
			}

		   
			
	
	}
	
}
