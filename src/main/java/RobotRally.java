import java.util.List;

import io.cucumber.java.en.When;
import setUp.AI;
import setUp.Board;
import setUp.Level;
import setUp.Card;
import setUp.Deck;
import setUp.Tiles.*;
import setUp.Robot;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors



public class RobotRally {
	
	public static void main(String[] args) throws IOException {
			
			Board board = new Board();
			new Level("Hard", board);
		
			AI ai = new AI("AI");
			ai.setFlagPosition(board);
			ai.getFlagPosition(ai.getFlag1());			
			
			
			FileWriter myWriter = new FileWriter("AI v1.txt");
			long startTime = System.nanoTime();
			
			for (int i=0; i<100; i++) {				
				if (i%10==0) System.out.println("i= "+i+"/100");
				
				int counter = 0;
				
				ai.setFlag1(false);
				ai.setFlag2(false);
				while (!(ai.getFlag1() && ai.getFlag2())) {
					counter++;
					Deck deck = new Deck();
					deck.newHand();
				
					ai.setPossibleHands(deck.getHand());
					ai.setHand(ai.findSuggestedCardChoice(board));
					for (Card card : ai.getHand()) { 
						card.executeAction(ai, board);
					}
				}
				myWriter.write(counter + "\n");
			} myWriter.close();
			
			long stopTime = System.nanoTime();
			System.out.println("Time elapsed was "+(stopTime - startTime)/1000000000 + " seconds");

	}
	
}
