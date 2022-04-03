package setUp;

import setUp.Tiles.Tile;

public class Level {
	
	private String thislevel; private int level;
	
	public Level(String a, Board board) {
		this.thislevel = a;
		initializeBoard(board);
	}

			
// this is all bullshit rn but just an example
	
	public void initializeBoard(Board board) {
		
		switch(thislevel) {
			case "Easy":
				board.setBoardSize(3);
				board.setObstacleNumber(2);
				board.generateBoard();
				break;
			case "Medium":
				board.setBoardSize(5);
				board.setObstacleNumber(3);
				break;
			case "Hard":
				board.setBoardSize(7);
				board.setObstacleNumber(5);
				break;
			default:
				board.setBoardSize(0);
				board.setObstacleNumber(0);
				
		}
		
	}
	
//	public void setLevel(int i) {
//		this.level = i;
//	}
//	public int getLevel() {
//		return level;
//	}
}

