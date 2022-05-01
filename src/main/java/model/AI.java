package model;

import controller.Game;
import org.paukov.combinatorics3.Generator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AI extends Robot  {

	private int flag1X;
	private int flag1Y;
	private int flag2X;
	private int flag2Y;
	private ArrayList<List<String>> possibleHands;
	private ArrayList<Card> cardChoice;

	public AI(String name, int lives, Game game, Board board) {
		super(name, lives, game, board);
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
				if (b.getTile(i,j).getType().equals("flag1.png")){
					this.flag1X=i;
					this.flag1Y=j;
					flagsFound++;
				}
				else if (b.getTile(i,j).getType().equals("flag2.png")){
					this.flag2X=i;
					this.flag2Y=j;
					flagsFound++;
				}
			}
		}

	}

	public String getFlagPosition(boolean getflag1) {
		if (!getflag1) return getName()+"FL1 (" + flag1X + "," + flag1Y + ")";
		else return  getName()+"FL2 (" + flag2X + "," + flag2Y + ")";
	}

	public void setPossibleHands(ArrayList<Card> possibleHand) {
		Stream<List<String>> possibleHands = (Generator.permutation(			possibleHand.get(0).getCardAction(),
											possibleHand.get(1).getCardAction(),possibleHand.get(2).getCardAction(),
											possibleHand.get(3).getCardAction(),possibleHand.get(4).getCardAction(),
											possibleHand.get(5).getCardAction(),possibleHand.get(6).getCardAction(),
											possibleHand.get(7).getCardAction(),possibleHand.get(8).getCardAction())
											.simple().stream());;
        List<List<String>> listList = possibleHands.collect(Collectors.toList());
        ArrayList<List<String>> arrayList = new ArrayList<List<String>>(listList);
        ArrayList<List<String>> result 	  = new ArrayList<List<String>>();
        result = removeDuplicates(arrayList);
        this.possibleHands = result;

	}

	public ArrayList<List<String>> removeDuplicates(ArrayList<List<String>> list) {
		Set<List<String>> set = new LinkedHashSet<List<String>>();
		for (List<String> hand : list) {
			ArrayList<String> hand5 = new ArrayList<String>();
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
		Map<ArrayList<Card>, Integer> distancesFl1 = new HashMap<ArrayList<Card>, Integer>();
		Map<ArrayList<Card>, Integer> distancesFl2 = new HashMap<ArrayList<Card>, Integer>();

		//remember the original data
		int xOriginal = getX();
		int yOriginal = getY();
		int direcOG	  = getDir().getDirectionInt();
		int lives 	  = getLives();

		//manually generate a copy of the board
		Board boardCopy = new Board();
		Movement move = new Movement(boardCopy);
		boardCopy.setBoardSize(board.getBoardSize());
		boardCopy.setObstacleNumbers(board.getObstacleNumbers()[0],board.getObstacleNumbers()[1],
									 board.getObstacleNumbers()[3],board.getObstacleNumbers()[3],
									 board.getObstacleNumbers()[4],board.getObstacleNumbers()[5]);
		boardCopy.generateBoard();

		for (int i=0; i<boardCopy.getBoardSize(); i++) {
			for (int j=0; j<boardCopy.getBoardSize(); j++) {
				boardCopy.setTile(j, i, board.getTile(j, i));
			}
		}

		//iterate through all possible hands
		for (List<String> possibleHand : possibleHands) {

			//booleans to compare if a flag has been found
			boolean foundFlag1 = getFlag1();
			boolean foundFlag2 = getFlag2();

			//make a new hand for the cards and play the cards
			ArrayList<Card> hand = new ArrayList<Card>();
			for (String action : possibleHand) {
				Card card = new Card(action);
				hand.add(card);
				if (canMove()) {
					card.executeAction(this, move);
				}
			}

			//check if the foundFlagX status has changed
			foundFlag1 = (foundFlag1!=getFlag1());
			foundFlag2 = (foundFlag2!=getFlag2());

			if (!getFlag1() & !getFlag2() & isAlive()) {
				//if it still has not found flag1, still looking for flag1
				distancesFl1.put(hand, Math.abs(flag1X-getX())+Math.abs(flag1Y-getY()));
			}
			else if (getFlag1() & !getFlag2() & isAlive()) {
				//reset getFlag1() for the next iteration if F1 has just been found
				if (foundFlag1) {setFlag1(false);}

				//flag1 has been found, looking for flag2
				distancesFl2.put(hand,Math.abs(flag2X-getX())+Math.abs(flag2Y-getY()));
				}
			else if (!getFlag1() & getFlag2() & isAlive()) {
				//reset getFlag2() for the next iteration if F2 has just been found
				if (foundFlag2) {setFlag2(false);}

				//flag1 has been found, looking for flag2
				distancesFl1.put(hand,Math.abs(flag1X-getX())+Math.abs(flag1Y-getY()));
			}



			//reset the AI parameters
			boardCopy.getTile(getX(), getY()).setRobotOff();
			setX(xOriginal);
			setY(yOriginal);
			setDir(new Direction(direcOG));
			setLives(lives);
			setCanMove(true);
			setLivingStatus(true);
			boardCopy.getTile(xOriginal, yOriginal).setRobotOn(this);

			if (foundFlag1) {setFlag1(false);}
			if (foundFlag2) {
				System.out.println("========================= "+getName()+" FOUND FLAG2!!");
				setFlag2(false);
				setWinner(false);
				return hand;
			}

		}

		if (distancesFl2.size()>0) {
			System.out.println("====== "+getName()+" IN DISTANCESFL2");
			return findMin(distancesFl2,Collections.min(distancesFl2.values()));
		}
		else if (distancesFl1.size()>0) {
			System.out.println("====== "+getName()+" IN DISTANCESFL1");
			return findMin(distancesFl1, Collections.min(distancesFl1.values()));
		}
		else {
			System.out.println(getName()+"===== ONLY BAD MOVES :( BYE!");
			ArrayList<Card> deathReturn = new ArrayList<Card>();
			for (String action : possibleHands.get(0)) {
				Card card = new Card(action);
				deathReturn.add(card);
			}
			return deathReturn;
		}
	}

	public ArrayList<Card> findMin(Map<ArrayList<Card>, Integer> distanceMap, int min){
		System.out.println(getName()+" min ="+min);
		for (Map.Entry<ArrayList<Card>, Integer> entry : distanceMap.entrySet()) {
			if (entry.getValue() == min){
				System.out.println(getName()+" HAND= "+entry.getKey()+", distance = "+entry.getValue());
				return entry.getKey();
			}
		}
		System.out.println("Error in AI.findMin() : nothing found!");
		return null;
	}

}
