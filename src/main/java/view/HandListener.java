package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Game;
import model.Board;
import model.Deck;
import model.Robot;

public class HandListener implements ActionListener {

	private Deck deck;
	private HandHandler handler;
	private Game game;
	private Robot robot;
		
	public HandListener(HandHandler hh, Deck newDeck, Game game, Robot robot) {
		this.handler = hh;
		this.deck = newDeck;
		this.game = game;
		this.robot = robot;
	}
	
	public void setDeck(Deck newDeck) {
		this.deck = newDeck;	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		int index = Integer.valueOf(arg.getActionCommand());
		
		//checks if players can choose a new card
		if(deck.canChoose() && index != -1) {
			deck.chooseCard(index);
			handler.addChoosenCard(deck.getCard(index));
			handler.removeButton(index);
		} else if (!deck.canChoose() && index == -1) {
			System.out.println("player done choosing");
			handler.removeButton(9);
			handler.setDone(true);
			//making a new thread to make the moves because why not
			if (game.checkMoves()) {
				new Thread() {
					public void run() {
						game.makeMoves();
					}
				}.start();
				//timer for when the moves are done being shown, updates hands
				Timer timer = new Timer(7000, new ActionListener() {
				    public void actionPerformed(ActionEvent evt) {
				        game.gameEnd();
				    }
				});
				timer.setRepeats(false);
				timer.start();
			}
			
		}	
		
	}
}
