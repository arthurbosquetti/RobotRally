package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import setUp.Board;
import setUp.Deck;
import setUp.Game;
import setUp.Robot;

public class HandListener implements ActionListener {

	private Deck deck;
	private HandHandler handler;
	private Game game;
	
	public HandListener(HandHandler hh, Deck newDeck, Game game) {
		this.handler = hh;
		this.deck = newDeck;
		this.game = game;
	}
	
	public void setDeck(Deck newDeck) {
		this.deck = newDeck;	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		int index = Integer.valueOf(arg.getActionCommand());
		
		if(deck.canChoose() && index != -1) {
			deck.chooseCard(index);
			handler.addChoosenCard(deck.getCard(index));
			handler.removeButton(index);
		} else if (!deck.canChoose() && index == -1) {
			System.out.println("player done choosing");
			handler.removeButton(9);
			game.playerDone();
		}
	}
}
