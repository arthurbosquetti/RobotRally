package view;

import javax.swing.*;

import model.Board;

import java.awt.*;

public class GameScreen extends JFrame {
	
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	
	private HandHandler hh1;
	private HandHandler hh2;
		
	public GameScreen() {
		super("RobotRally game");
		setLayout(gbl);
	}
	
	public void initGameScreen(BoardScreen bs, HandHandler hh1, HandHandler hh2) {
		//add board to screen
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		add(bs, c);
		
		this.hh1 = hh1;
		this.hh2 = hh2;
		
		//create new panel for right side of board
		JPanel hands = new JPanel();
		hands.setLayout(new BoxLayout(hands, BoxLayout.Y_AXIS));
		hands.add(hh1);
		hands.add(Box.createRigidArea(new Dimension(0, 25)));
		hands.add(hh2);
		c.gridx = 3;
		c.gridy = 0;
		add(hands, c);
		
		//initialize frame
		setSize((BoardScreen.pixelSize * BoardScreen.size) + 650, (BoardScreen.pixelSize * BoardScreen.size) + 50);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void newRound() {
		hh1.clearHand();
		hh2.clearHand();
		hh1.drawCards();
		hh2.drawCards();
		repaint();
	}
	
	public void refresh() {
		repaint();
	}
}
