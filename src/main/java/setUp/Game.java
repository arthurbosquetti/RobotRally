package setUp;

import view.EndScreen;
import view.FirstScreen;
import view.GameScreen;
import view.HandHandler;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Game {
	
	private GameScreen gs;
	
	private HandHandler hh1;
	private HandHandler hh2;
	
	private Board board = new Board();
	private Level level;
	private Robot robot1;
	private Robot robot2;

	private boolean gameOn;
	
	public Game() {FirstScreen fs = new FirstScreen(this);}
	
	public void setGameStatus(boolean b) {this.gameOn = b;}
	
	public boolean getGameStatus(){return gameOn;}
	
	public void gameStart(String newLevel, String p1, String p2) {
		setGameStatus(true);
	
		if (Objects.equals(newLevel, "easy")) {
		  	level = new Level("Easy", board);
		  	
		  	robot1 = new Robot(p1, 5);
			robot2 = new Robot(p2, 5);
		  	}
		else if (Objects.equals(newLevel, "mid")) {
		  	level = new Level("Medium", board);
		  	
		  	robot1 = new Robot(p1, 3);
			robot2 = new Robot(p2, 3);
		  	}
		else if (Objects.equals(newLevel, "hard")) {
		  	level = new Level("Hard", board);

		  	robot1 = new Robot(p1, 1);
			robot2 = new Robot(p2, 1);
		}
		

		initGameScreen();
	}
	
	public void initGameScreen() {
		gs = new GameScreen();
		
		hh1 = new HandHandler(robot1, this);	
		hh2 = new HandHandler(robot2, this);	
		
		gs.initGameScreen(board, hh1, hh2);
		
		//temp for testing
		robot1.setX(3);
		robot1.setY(3);
		robot2.setX(5);
		robot2.setY(5);

	}
	
	public void playerDone() {
		
		ArrayList<Card> choosen1 = robot1.getDeck().getChoosen();
		ArrayList<Card> choosen2 = robot2.getDeck().getChoosen();
		if (!(robot1.getDeck().canChoose()) & !(robot2.getDeck().canChoose())) {
			//removes submit button if it still exists
			hh1.removeButton(9);
			hh2.removeButton(9);
			
			//executes moves selected
			System.out.println("starting moves:");
			for (int i = 0; i < 5; i++) {
				choosen1.get(i).executeAction(robot1, board);
				//one second pause to slow things down a bit
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					}
				choosen2.get(i).executeAction(robot1, board);
//				board.repaint();
			}
			robot1.setGlue(true);
			robot2.setGlue(true);
			//Code to move select again, etc
		}
	}
	
	public void hurtOtherPlayer(Robot robot1) {
		robot2.hurt(1);
	}
	
	public int[] findOtherPlayer(Robot robot1) {
		int[] other = new int[2];
		other[0] = robot2.getX();
		other[1] = robot2.getY();
		return other;
	}
	
	public void gameEnd(){
		if (robot1.isAlive() == false || robot2.getWinner()== true) {
			EndScreen es = new EndScreen(robot2.getName());
		}
		else if (robot2.isAlive() == false || robot1.getWinner()== true) {
			EndScreen es = new EndScreen(robot1.getName());
		}
		
	}
}
