package model;

import java.util.ArrayList;
import java.util.Random;

public class Deck{
	
	private ArrayList<Card> hand = new ArrayList<Card>(); 
	private ArrayList<Card> choosenCards = new ArrayList<Card>();
	private Random rnd = new Random();
	
	public void newHand() {
		hand = new ArrayList<Card>(); 
		choosenCards = new ArrayList<Card>();
		for (int i=0; i<9; i++) {
			double val = rnd.nextDouble();
			if (val < 0.20) {
				hand.add(new Card("F1"));
			}
			else if (val < 0.35) {
				hand.add(new Card("F2"));
			}
			else if (val < 0.45) {
				hand.add(new Card("F3"));
			}
			else if (val < 0.65) {
				hand.add(new Card("R"));
			}
			else if (val < 0.85) {
				hand.add(new Card("L"));
			}
			else if (val < 0.95) {
				hand.add(new Card("B"));
			}
			else if (val < 1) {
				hand.add(new Card("J"));
			}
		}
	}
	
	public boolean canChoose() {
		return (choosenCards.size() < 5)? true : false;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public ArrayList<Card> getChoosen() {
		return choosenCards;
	}
	
	public Card getCard(int index) {
		return hand.get(index);
	}
	
	public void setCard(int index, Card card) {
		hand.set(index, card);
	}
	
	public void chooseCard(int index) {
		choosenCards.add(hand.get(index));
	}
//	//overloaded method in order to use with AI in HandListener
	public void chooseCard(Card card) {
		choosenCards.add(card);
	}
	
	public void setChoosenCards(ArrayList<Card> hand) {
		choosenCards = hand;
	}
}