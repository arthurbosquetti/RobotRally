package setUp;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import setUp.Tiles.Tile;
import view.FirstScreen;
import view.GameScreen;
import view.HandHandler;

public class Game {
	
	private GameScreen gs;
	
	private HandHandler hh1;
	private HandHandler hh2;
	
	private Board board = new Board();
	private Level level;
	//TODO: change to array to support more than 2 players
	private Robot robot1;
	private Robot robot2;

	private boolean gameOn;
	
	public Game() {
		FirstScreen fs = new FirstScreen(this); 
		
		System.out.println("here");
	}
	
	public void setGameStatus(boolean b) {
		this.gameOn = b;
	}
	
	public boolean getGameStatus(){
		return gameOn;
	}
	
	public void gameStart(String newLevel, String p1, String p2) {
		setGameStatus(true);
	
		if (newLevel == "easy") {
			Tile.setDifficulty("easy");
			Tile.setPixelSize(75);
		  	level = new Level("Easy", board);
		  	
		  	robot1 = new Robot(p1, 5);
			robot2 = new Robot(p2, 5);
		  	}
		else if (newLevel == "mid") {
			Tile.setDifficulty("medium");
			Tile.setPixelSize(66);
		  	level = new Level("Medium", board);
		  	
		  	robot1 = new Robot(p1, 3);
			robot2 = new Robot(p2, 3);
		  	}
		else if (newLevel == "hard") {
			Tile.setDifficulty("hard");
			Tile.setPixelSize(50);
		  	level = new Level("Hard", board);

		  	robot1 = new Robot(p1, 1);
			robot2 = new Robot(p2, 1);
		}
		
		board.loadBoard();
		
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
				board.repaint();
			}
			
			//Code to move select again, etc
		}
	}
}
