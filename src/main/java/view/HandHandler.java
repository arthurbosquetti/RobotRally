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
	private HandListener listener = new HandListener();
	private ChoosenCardHandler cch;

	
	public HandHandler(Robot robot) {
		this.robot = robot;
		this.deck = robot.getDeck();
		listener.setDeck(deck);
		listener.setRobot(robot);
		listener.setHandler(this);
		
		setLayout(gbl);
	}	
	
	public HandHandler() { setLayout(new GridBagLayout()); }
	
	
	public void drawNewHand(ArrayList<Card> hand) {
		//clearHand();
		for (int i = 0; i < hand.size(); i ++) {
			String action = hand.get(i).getCardAction();
			JButton button = new JButton(action);
			button.setActionCommand(action);
			//TODO: make this change to fit two columns
			c.gridx = i % 6;
			c.gridy = i / 6;
			buttons.add(button);
			add(button, c);
		}
	}
	
	public void clearHand() {
		buttons.clear();
		revalidate();
		repaint();
	}
	
	public void drawCards(ArrayList<Card> hand) {
		JLabel cardLbl = new JLabel(robot.getName() + "'s cards: ");
		c.gridx = 0;
		c.gridy = 0;
		add(cardLbl, c);
		for (int i = 0; i < hand.size(); i ++) {
			//System.out.println(hand.get(i));
			String action = hand.get(i).getCardAction();
			JButton button = new JButton(action);
			button.setActionCommand(""+i);
			button.addActionListener(listener);
			//TODO: make this change to fit two rows better
			c.gridx = i % 6 + 1;
			c.gridy = i / 6;
			buttons.add(button);
			add(button, c);
		}
	}
	
	//In desperate need of testing
	public void removeButton(int index) {
		Component button = this.getComponent(index+1);
		GridBagConstraints contraints = gbl.getConstraints(button);
		
		JButton newButton = new JButton("");
		newButton.setVisible(false);
		this.remove(button);
		
		addImpl(newButton, contraints, index+1);
		repaint();
	}
	
	public void drawChoosen() {
		ArrayList<Card> choosen = deck.getChoosen();
		for (int i = 0; i < choosen.size(); i ++) {
			String action = choosen.get(i).getCardAction();
			JLabel actLbl = new JLabel(action);
			c.gridx = choosen.size()+1;
			c.gridy = 2;
			add(actLbl, c);
		}
		repaint();
	}
	
	public void addChoosenCard(String action) {
		JLabel actLbl = new JLabel(" "+ action+ " ");
		c.gridx = deck.getChoosen().size();
		c.gridy = 2;
		add(actLbl, c);
		revalidate();
		repaint();
	}
	
}
