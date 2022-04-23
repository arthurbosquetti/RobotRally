package view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import setUp.Card;
import setUp.Deck;

public class ChoosenCardHandler extends JPanel {
	
	private static final long serialVersionUID = -419638239226798711L;
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
		JLabel actLbl = new JLabel(" "+ card.getCardAction()+ " ");
		add(actLbl);
		revalidate();
		repaint();
	}
}
