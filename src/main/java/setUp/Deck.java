package setUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck{
	
	private ArrayList<Card> hand = new ArrayList<Card>(); 
	private Random rnd = new Random();

	
	public void newHand() {
		for (int i=0; i<=9; i++) {
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
	
	public ArrayList<Card> getHand() {
		return hand;
	}

}








