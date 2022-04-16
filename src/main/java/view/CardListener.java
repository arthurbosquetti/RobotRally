package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import setUp.Board;
import setUp.Deck;
import setUp.Robot;

public class CardListener implements ActionListener {

	private Board board;
	private Robot robot;
	private Deck deck;
	private HandHandler handler;
	
	public CardListener(Board board) {
		this.board = board;
	}
	
	public void setRobot(Robot robot) {
		this.robot = robot;	
	}
	
	public void setDeck(Deck newDeck) {
		this.deck = newDeck;	
	}
	
	public void setHandler(HandHandler hh) {
		handler = hh;
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		int index = Integer.valueOf(arg.getActionCommand());
		
		deck.chooseCard(index);
		handler.addChoosenCard(deck.getCard(index).getCardAction());
		handler.removeButton(index);
		
	}

}
