package setUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck{
	
	private ArrayList<Card> Hand = new ArrayList<Card>(); 
	private Random rnd = new Random();

	
	public void newHand() {
		for (int i=0; i<9; i++) {
			double val = rnd.nextDouble();
			if (val < 0.20) {
				Hand.add(new Card("F1"));
			}
			else if (val < 0.35) {
				Hand.add(new Card("F2"));
			}
			else if (val < 0.45) {
				Hand.add(new Card("F3"));
			}
			else if (val < 0.65) {
				Hand.add(new Card("R"));
			}
			else if (val < 0.85) {
				Hand.add(new Card("L"));
			}
			else if (val < 0.95) {
				Hand.add(new Card("B"));
			}
			else if (val < 1) {
				Hand.add(new Card("J"));
			}
		}
		System.out.println(Hand);
	}
	

}








