package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import setUp.Board;
import setUp.Tiles.Tile;

public class GameScreen extends JFrame {
	
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	
	public GameScreen() {
		super("RobotRally game");
		setLayout(gbl);
	}
	
	public void initGameScreen(Board board, HandHandler hh1, HandHandler hh2) {
		//add board to screen
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		add(board, c);
		
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
		setSize((Tile.pixelSize * board.getBoardSize()) + 650, (Tile.pixelSize * board.getBoardSize()) + 50);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
