package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import setUp.Board;
import setUp.Deck;
import setUp.Robot;

public class HandListener implements ActionListener {

	private Deck deck;
	private HandHandler handler;
	
	public HandListener(HandHandler hh, Deck newDeck) {
		this.handler = hh;
		this.deck = newDeck;
	}
	
	public void setDeck(Deck newDeck) {
		this.deck = newDeck;	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		int index = Integer.valueOf(arg.getActionCommand());
		
		if(deck.canChoose()) {
			deck.chooseCard(index);
			handler.addChoosenCard(deck.getCard(index));
			handler.removeButton(index);
		}
	}

}
