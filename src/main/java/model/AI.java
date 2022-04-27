
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.paukov.combinatorics3.Generator;

public class AI extends Robot  {
	
	private int flag1X;
	private int flag1Y;
	private int flag2X;
	private int flag2Y;
	private ArrayList<List<String>> possibleHands;
	private ArrayList<Card> cardChoice;

	public AI(String name, int lives) {
		super(name, lives);
	}

	public void setHand(ArrayList<Card> cardChoice) {
		this.cardChoice=cardChoice;
	}
	
	public ArrayList<Card> getHand() {
		return cardChoice;
	}
	
	public void setFlagPosition(Board b) {
		int flagsFound = 0;
		for (int i=0; i<b.getBoardSize(); i++) {
			if (flagsFound==2) {break;}
			for (int j=0; j<b.getBoardSize(); j++) {
				if ((b.getTile(i,j).tileType().equals(" |1|"))){
					this.flag1X=i;
					this.flag1Y=j;
					flagsFound++;
				}
				if ((b.getTile(i,j).tileType().equals(" |2|"))){
					this.flag2X=i;
					this.flag2Y=j;
					flagsFound++;
				}
			}
		}
		
	}
	
	public String getFlagPosition(boolean getflag1) {
		if (!getflag1) return "FL (" + flag1X + "," + flag1Y + ")";
		else return  "FL (" + flag2X + "," + flag2Y + ")";
	}
	
	public void setPossibleHands(ArrayList<Card> possibleHand) {
		Stream<List<String>> possibleHands = (Generator.permutation(			possibleHand.get(0).getCardAction(),
											possibleHand.get(1).getCardAction(),possibleHand.get(2).getCardAction(),
											possibleHand.get(3).getCardAction(),possibleHand.get(4).getCardAction(),
											possibleHand.get(5).getCardAction(),possibleHand.get(6).getCardAction(),
											possibleHand.get(7).getCardAction(),possibleHand.get(8).getCardAction())
											.simple().stream());;
        List<List<String>> listList = possibleHands.collect(Collectors.toList());
        ArrayList<List<String>>result = new ArrayList<List<String>>(listList);
        this.possibleHands = removeDuplicates(result);
	}
	
	public ArrayList<List<String>> removeDuplicates(ArrayList<List<String>> list) {
		Set<List<String>> set = new LinkedHashSet<List<String>>();
		for (List<String> hand : list) {
			ArrayList<String> hand5 = new ArrayList<String>(hand);
			hand5.add(hand.get(0));
			hand5.add(hand.get(1));
			hand5.add(hand.get(2));
			hand5.add(hand.get(3));
			hand5.add(hand.get(4));
			set.add(hand5);
		}
		list.clear();
		list.addAll(set);
		return list;
	}
	
	public ArrayList<List<String>> getPossibleHands(){
		 return this.possibleHands;
	 }
	
	public ArrayList<Card> findSuggestedCardChoice(Board board) {
		
		//initialize a map that stores the different hands and the final distance from the desired flag
		Map<ArrayList<Card>, Integer> distances = new HashMap<ArrayList<Card>, Integer>();
		
		//remember the original data
		int xOriginal = getX();
		int yOriginal = getY();
		int direcOG = getDir().getDirectionInt();
		int lives = getLives();
		
		int counter = 0;
		//iterate through all possible hands
		for (List<String> possibleHand : possibleHands) {

			counter++;
			System.out.println("counter = "+counter);
			
			setX(xOriginal);
			setY(yOriginal);
			setDir(new Direction(direcOG));
			setLives(lives);
			
			//manually generate a copy of the board
			Board boardCopy = new Board();
			boardCopy.setBoardSize(board.getBoardSize());
			boardCopy.setObstacleNumbers(board.getObstacleNumbers()[0],board.getObstacleNumbers()[1],board.getObstacleNumbers()[3],
										 board.getObstacleNumbers()[3],board.getObstacleNumbers()[4],board.getObstacleNumbers()[5]);
			boardCopy.generateBoard();
			for (int i=0; i<boardCopy.getBoardSize(); i++) {
				for (int j=0; j<boardCopy.getBoardSize(); j++) {
						boardCopy.setTile(j, i, board.getTile(j, i));
				}
			}
			ArrayList<Card> hand = new ArrayList<Card>();
			for (String action : possibleHand) {
				hand.add(new Card(action));
			}
			
			
			//iterate through the cards of the current hand:
			for (Card card : hand) {
				System.out.println("Card at "+counter+" is "+card);
				boolean foundFlag1=getFlag1();
				card.executeAction(this, boardCopy);
				System.out.println("AI at ("+getX()+","+getY()+","+getDir().getDirection()+")");

				
				//flag 1 has been found whenever getFlag1() changes (false->true)
				foundFlag1=(foundFlag1!=getFlag1());
						
				//if the AI has just found flag 1, return the hand after resetting the original values
				//(the AI shouldn't change positions in this method, but rather in the main game setting).
				if (getFlag1() && foundFlag1 && (getX()==flag1X) && (getY()==flag1Y)) {
					System.out.println("==============================AI just found flag1!!");
					this.setX(xOriginal);
					this.setY(yOriginal);
					this.setDir(new Direction(direcOG));
					this.setFlag1(false);
					return hand;
				
				//if the AI has just found flag 2, return the hand.
				} else if (getFlag1() && getFlag2() && (getX()==flag2X) && (getY()==flag2Y)) {
					System.out.println("==============================AI just found flag2!!");
					this.setX(xOriginal);
					this.setY(yOriginal);
					this.setDir(new Direction(direcOG));
					this.setFlag2(false);
					return hand;	
					
				}
			}
			//we only get to this part of the code if the hand didn't take the AI to the desired flag...
			
			//if it has not found flag1 yet:
			if (!getFlag1()) {
				distances.put(hand, Math.abs(flag1X-getX())+Math.abs(flag1Y-getY()));
			} 
			//if it has, add the distance compared to flag2
			else {
				distances.put(hand, Math.abs(flag2X-getX())+Math.abs(flag2Y-getY()));
			}
		}		
		
		//find the minimum distance
		int min = Collections.min(distances.values());
		
		//return the first hand Card[] that has the minimum distance value using a linear search
		for (Map.Entry<ArrayList<Card>, Integer> entry : distances.entrySet()) {
			if (entry.getValue()==(min)) {
				this.setX(xOriginal);
				this.setY(yOriginal);
				this.setDir(new Direction(direcOG));
				return entry.getKey();
			}
		}
		//error solving...
		System.out.println("Error: no cards found in AI.findSuggestedCardChoice");
		return null;
	}

}
	























	