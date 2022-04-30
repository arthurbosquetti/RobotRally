package view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Card;
import model.Deck;

import java.awt.*;

public class ChoosenCardHandler extends JPanel {
	
	private static final long serialVersionUID = -419638239226798711L;
	private String player;
	private Deck deck;	
	
	public ChoosenCardHandler(String player, Deck deck) {
		setBackground(Color.DARK_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.player = player;
		this.deck = deck;

		JLabel choosenLbl = new JLabel("Choosen cards: ");
		add(choosenLbl);
		choosenLbl.setForeground(Color.WHITE);
	}
	
	public void addCard(Card card) {
		JLabel actLbl = new JLabel(" "+ card.getCardAction()+ " ");
		add(actLbl);
		actLbl.setForeground(Color.PINK);
		this.revalidate();
		this.repaint();
	}
	
	public void clear() {
		removeAll();
		
		JLabel choosenLbl = new JLabel("Choosen cards: ");
		add(choosenLbl);
	}
}
