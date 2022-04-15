package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import setUp.Board;
import setUp.Card;
import setUp.Deck;

public class HandHandler extends JPanel {
	private static final long serialVersionUID = -1363523608759469440L;
	private GridBagConstraints c = new GridBagConstraints();

	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	
	public HandHandler() {setLayout(new GridBagLayout());}
	
	
	public void drawNewHand(ArrayList<Card> hand) {
		clearHand();
		for (int i = 0; i < hand.size(); i ++) {
			String action = hand.get(i).getCardAction();
			JButton button = new JButton(action);
			button.setActionCommand(action);
			//TODO: make this change to fit two columns
			c.gridx = i;
			c.gridy = i;
			buttons.add(button);
			add(button, c);
		}
	}
	
	public void clearHand() {
		for (JButton button : buttons) {
			remove(button);
		}
		buttons.clear();
	}
}
