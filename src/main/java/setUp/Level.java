package setUp;

import setUp.Tiles.Tile;

public class Level {
	
	private String thislevel; private int level;
	
	public Level(String a, Board board) {
		this.thislevel = a;
		initializeBoard(board);
	}

				
	public void initializeBoard(Board board) {
		//TODO: change these to final values
		switch(thislevel) {
			case "Easy":
				board.setBoardSize(8);
				board.setObstacleNumber(10);
				board.generateBoard();
				break;
			case "Medium":
				board.setBoardSize(10);
				board.setObstacleNumber(20);
				board.generateBoard();
				break;
			case "Hard":
				board.setBoardSize(14);
				board.setObstacleNumber(30);
				board.generateBoard();
				break;
			default:
				board.setBoardSize(0);
				board.setObstacleNumber(0);
				
		}
		
	}
}

