package view;

import javax.swing.*;

import model.Board;

import java.awt.*;

public class GameScreen extends JFrame {
	
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	
	private HandHandler hh1, hh2;
	private LifeView lv1, lv2;
	private FlagView fv1, fv2;
		
	public GameScreen() {
		super("RobotRally game");
		setLayout(gbl);
	}
	
	public void initGameScreen(BoardScreen bs, LifeView[] lv, HandHandler[] hh, FlagView[] fv) {
		Image img = Toolkit.getDefaultToolkit().getImage("src/main/resources/gamescreenbg.png");
		JPanel bg = new BackgroundPanel(img);
		//add board to screen
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		bg.add(bs, c);
		
		this.hh1 = hh[0];
		this.hh2 = hh[1];
		
		this.lv1 = lv[0];
		this.lv2 = lv[1];
		
		this.fv1 = fv[0];
		this.fv2 = fv[1];
		
		//create new panel for right side of board

		Image handimg = Toolkit.getDefaultToolkit().getImage("src/main/resources/blank.png");
		JPanel hands = new BackgroundPanel(handimg);
		hands.setSize(450,450);
		hands.setLayout(new BoxLayout(hands, BoxLayout.Y_AXIS));
		hands.add(hh1);
		hands.add(lv1);
		hands.add(fv1);
		hands.add(Box.createRigidArea(new Dimension(0, 25)));
		hands.add(hh2);
		hands.add(lv2);
		hands.add(fv2);
		c.gridx = 3;
		c.gridy = 0;
		add(bg);
		bg.add(hands, c);
		
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
	}
}
