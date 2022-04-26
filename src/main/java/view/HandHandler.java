package view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Game;
import model.Card;
import model.Deck;
import model.Robot;

public class HandHandler extends JPanel {
	private static final long serialVersionUID = -1363523608759469440L;
	
	private Robot robot;
	private Deck deck;
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private HandListener listener;
	private ChoosenCardHandler cch;
	
	public HandHandler(Robot robot, Game game) {
		setLayout(gbl);
		
		this.robot = robot;
		this.deck = robot.getDeck();
		listener = new HandListener(this, deck, game);
		
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
			c.gridx = i % 5 + 1;
			c.gridy = i / 5 ;
			buttons.add(button);
			add(button, c);
		}
		
		JButton submitButton = new JButton("submit");
		submitButton.setActionCommand("-1");
		submitButton.addActionListener(listener);
		//TODO: make this change to fit two rows better
		c.gridx = 5;
		c.gridy = 1;
		buttons.add(submitButton);
		add(submitButton, c);
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
