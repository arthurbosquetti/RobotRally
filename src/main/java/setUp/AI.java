package setUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.paukov.combinatorics3.Generator;

import setUp.Tiles.FlagTile;
import setUp.Tiles.Tile;

public class AI extends Robot  {
	
	private int flag1X;
	private int flag1Y;
	private int flag2X;
	private int flag2Y;
	private List<List<String>> possibleHands;

	public AI(String name) {
		super(name);
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
		if (!this.getFlag1()) return "(" + flag1X + "," + flag1Y + ")";
		else return  "(" + flag2X + "," + flag2Y + ")";
	}
	
	public void setPossibleHands(ArrayList<Card> possibleHand) {
		Stream<List<String>> possibleHands = (Generator.permutation(			possibleHand.get(0).getCardAction(),
											possibleHand.get(1).getCardAction(),possibleHand.get(2).getCardAction(),
											possibleHand.get(3).getCardAction(),possibleHand.get(4).getCardAction(),
											possibleHand.get(5).getCardAction(),possibleHand.get(6).getCardAction(),
											possibleHand.get(7).getCardAction(),possibleHand.get(8).getCardAction())
											.simple().stream());
		
        List<List<String>> result = possibleHands.collect(Collectors.toList());
        this.possibleHands = result;
	}
	 
	public List<List<String>> getPossibleHands(){
		 return this.possibleHands;
	 }
	
	public Card[] findSuggestedCardChoice(Board board) {
		//store possible hands and their distance from the flag.
		Map<Card[], Integer> distances = new HashMap<Card[], Integer>();
		
		//remember original data
		int xOriginal = getX();
		int yOriginal = getY();
		Direction direcOG = getDir();
		Board boardCopy;
		
		//iterate through all possible hands
		for (int i=0; i<possibleHands.size(); i++) {
		
			this.setX(xOriginal);
			this.setY(yOriginal);
			this.setDir(direcOG);
			boardCopy = board;
			
			//create hand of cards
			Card[] hand = {new Card(possibleHands.get(i).get(0)),new Card(possibleHands.get(i).get(1)),
						   new Card(possibleHands.get(i).get(2)),new Card(possibleHands.get(i).get(3)),
						   new Card(possibleHands.get(i).get(4))};
			//iterate through the card actions from the hand:
			for (Card card : hand) {
				//move the AI piece
				card.executeAction(this, boardCopy);
				//if it lands on the flag it wants, return that hand.
//				if ((!this.getFlag1() && this.getX()==this.flag1X && this.getY()==this.flag1Y) ||
//					( this.getFlag1() && this.getX()==this.flag2X && this.getY()==this.flag2Y)) {
				
				if ((this.getX()==this.flag1X && this.getY()==this.flag1Y)) {
					
//				if ((!this.getFlag1() && this.getX()==this.flag1X)) {
					
//					if ((!this.getFlag1() && this.getX()==this.flag1X ) ||
//					( this.getFlag1() && this.getX()==this.flag2X )) {
					System.out.println("======================A FLAG HAS BEEN FOUND!!!!============================");
					this.setFlag1(true);
					this.setX(xOriginal);
					this.setY(yOriginal);
					this.setDir(direcOG);
					return hand;
				}
			//if it didn't find the flag it wants when "playing" that hand, put hand and final distance
			//into the distances dictionary
			if (!getFlag1()) {distances.put(hand, Math.abs(flag1X-getX())+Math.abs(flag1Y-getY()));}
			else {distances.put(hand, Math.abs(flag2X-getX())+Math.abs(flag2Y-getY()));}}
		}
		//find the minimum distance value
		int min = Collections.min(distances.values());
		//return the first hand Card[] that has the minimum distance value
		for (Map.Entry<Card[], Integer> entry : distances.entrySet()) {
			if (entry.getValue().equals(min)) {
				this.setX(xOriginal);
				this.setY(yOriginal);
				this.setDir(direcOG);
				return entry.getKey();
			}
		}
		//something is wrong if the above don't return anything
		System.out.println("Error in findSuggestedCardChoice()!!");
		return null;
	}		
		
	


}
	
	





