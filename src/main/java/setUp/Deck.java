package setUp;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck{
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() { //generates cards: 20F1, 15F2,10F3,B10,R20,L20,J5

		for (int i=0; i<20; i++) {
			cards.add(new Card("F1"));
		}
		for (int i=0; i<15; i++) {
			cards.add(new Card("F2"));
		}
		for (int i=0; i<10; i++) {
			cards.add(new Card("F3"));
		}
		for (int i=0; i<10; i++) {
			cards.add(new Card("B"));
		}
		for (int i=0; i<20; i++) {
			cards.add(new Card("L"));
		}
		for (int i=0; i<20; i++) {
			cards.add(new Card("R"));
		}
		for (int i=0; i<5; i++) {
			cards.add(new Card("J"));
		}
	}
	public Card getCard(int index) {
		return cards.get(index);
	}

	public void printcards() {
		for (int i=0; i<100; i++) {
			System.out.println((cards.get(i)).toString());
		}
	}

}








