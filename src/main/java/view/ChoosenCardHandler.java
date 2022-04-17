package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import setUp.Card;

public class ChoosenCardHandler extends JPanel {
	
	private String player;
	
	
	public ChoosenCardHandler(String player) {
		this.player = player;
		
		setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel choosenLbl = new JLabel("Choosen cards: ");
		add(choosenLbl);
	}
	
	public void addCard(Card card) {
		
	}
	
	
	
	
}
