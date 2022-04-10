package setUp;

import setUp.Tiles.Tile;

public class Level {
	
	private String thislevel; private int level;
	
	public Level(String a, Board board) {
		this.thislevel = a;
		initializeBoard(board);
	}

				
	public void initializeBoard(Board board) {
		
		switch(thislevel) {
			case "Easy":
				board.setBoardSize(7);
				board.setObstacleNumber(2);
				board.generateBoard();
				break;
			case "Medium":
				board.setBoardSize(10);
				board.setObstacleNumber(3);
				board.generateBoard();
				break;
			case "Hard":
				board.setBoardSize(15);
				board.setObstacleNumber(5);
				board.generateBoard();
				break;
			default:
				board.setBoardSize(0);
				board.setObstacleNumber(0);
				
		}
		
	}
}

