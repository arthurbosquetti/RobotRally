package model;

import model.tiles.Tile;
import view.BoardScreen;

public class Level {
	
	private String level;
	
	public Level(String level, Board board) {
		this.level = level;
		initializeBoard(board);
	}

				
	public void initializeBoard(Board board) {
		//TODO: change these to final values
		switch(level) {
			case "Easy":
				board.setBoardSize(8);
				board.setObstacleNumbers(0,0,3,2,1,4);
				board.generateBoard();
				BoardScreen.setPixelSize(75);
				break;
			case "Medium":
				board.setBoardSize(12);
				board.setObstacleNumbers(2,2,4,3,3,6);
				board.generateBoard();
				BoardScreen.setPixelSize(66);
				break;
			case "Hard":
				board.setBoardSize(15);
				board.setObstacleNumbers(2,6,8,4,4,6);
				board.generateBoard();
				BoardScreen.setPixelSize(50);
				break;
			default:
				board.setBoardSize(0);
				board.generateBoard();
				BoardScreen.setPixelSize(0);
				break;
		}
	}
	
	//
	public String getLevel() {
		return level.toLowerCase();
//		switch (level) {
//			case "Easy":
//				return "easy";
//			case "Medium":
//				return "medium";
//			case "Hard":
//				return "hard";
//			default:
//				return "easy";
		
	}
}

