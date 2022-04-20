package setUp;

import setUp.Tiles.Tile;

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
				break;
			case "Medium":
				board.setBoardSize(12);
				board.setObstacleNumbers(2,2,4,3,3,6);
				board.generateBoard();
				break;
			case "Hard":
				board.setBoardSize(15);
				board.setObstacleNumbers(2,6,8,4,4,6);
				board.generateBoard();
				break;
			default:
				board.setBoardSize(0);
				board.generateBoard();
				break;
		}
		
	}
}

