package view;

import java.awt.*;
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
	
	private boolean donePicking; 
	private Robot robot;
	private Deck deck;
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private HandListener listener;
	private ChoosenCardHandler cch;
	
	public HandHandler(Robot robot, Game game) {
		setBackground(Color.DARK_GRAY);
		setLayout(gbl);
		
		this.robot = robot;
		this.deck = robot.getDeck();
		listener = new HandListener(this, deck, game, robot);
		
		JLabel cardLbl = new JLabel(robot.getName() + "'s cards: ");
		cardLbl.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 0;
		add(cardLbl, c);
		
		drawCards();
	}		
	
	public void clearHand() {
		setBackground(Color.DARK_GRAY);

		removeAll();

		JLabel cardLbl = new JLabel(robot.getName() + "'s cards: ");
		cardLbl.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 0;
		add(cardLbl, c);
		
		buttons.clear();
		cch.clear();
		revalidate();
		repaint();
	}
	
	public void drawCards() {
		setBackground(Color.DARK_GRAY);
		ArrayList<Card> hand = deck.getHand();
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
		
		cch = new ChoosenCardHandler(robot.getName(), deck);
		c.gridx = 0;
		c.gridy = 2;
		add(cch, c);
	}
	
	public void removeButton(int index) {
		setBackground(Color.DARK_GRAY);
		Component button = this.getComponent(index+1);
		button.setVisible(false);
		repaint(button.getX(), button.getY(), button.getWidth(), button.getHeight());
	}
	
	public void setDone(boolean isDone) {
		donePicking = true;
	}
	public boolean isDone() {
		return donePicking;
	}
	
	public void addChoosenCard(Card card) {
		cch.addCard(card);
	}


}
