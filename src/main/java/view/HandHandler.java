package view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import setUp.Board;
import setUp.Card;
import setUp.Deck;
import setUp.Robot;

public class HandHandler extends JPanel {
	private static final long serialVersionUID = -1363523608759469440L;
	
	private Robot robot;
	private Deck deck;
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private HandListener listener;
	private ChoosenCardHandler cch;
	
	public HandHandler(Robot robot) {
		setLayout(gbl);
		
		this.robot = robot;
		this.deck = robot.getDeck();
		listener = new HandListener(this, deck);
		
		drawCards();
		
		cch = new ChoosenCardHandler(robot.getName(), deck);
		c.gridx = 0;
		c.gridy = 2;
		add(cch, c);
	}		
	
	public void clearHand() {
		if (buttons.size() != 0) {
			for (JButton button : buttons) {
				remove(button);
			}
		}
		buttons.clear();
		revalidate();
		repaint();
	}
	
	public void drawCards() {
		ArrayList<Card> hand = deck.getHand();
		JLabel cardLbl = new JLabel(robot.getName() + "'s cards: ");
		c.gridx = 0;
		c.gridy = 0;
		add(cardLbl, c);
		for (int i = 0; i < hand.size(); i ++) {
			String action = hand.get(i).getCardAction();
			JButton button = new JButton(action);
			button.setActionCommand(""+i);
			button.addActionListener(listener);
			//TODO: make this change to fit two rows better
			c.gridx = i % 6 + 1;
			c.gridy = i / 6 ;
			buttons.add(button);
			add(button, c);
		}
	}
	
	public void removeButton(int index) {
		Component button = this.getComponent(index+1);
		button.setVisible(false);
		repaint(button.getX(), button.getY(), button.getWidth(), button.getHeight());
	}
	
	public void addChoosenCard(Card card) {
		cch.addCard(card);
	}
	
}
