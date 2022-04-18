package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import setUp.Card;
import setUp.Deck;

public class ChoosenCardHandler extends JPanel {
	
	private String player;
	private Deck deck;	
	
	public ChoosenCardHandler(String player, Deck deck) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.player = player;
		this.deck = deck;
		

		JLabel choosenLbl = new JLabel("Choosen cards: ");
		add(choosenLbl);
	}
	
	public void addCard(Card card) {
		System.out.println("here");
		JLabel actLbl = new JLabel(" "+ card.getCardAction()+ " ");
		add(actLbl);
		revalidate();
		repaint();
	}
	
	
	
	
}
