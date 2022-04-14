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
				board.setBoardSize(8);
				//Defining different numbers of obstacles (TeleportNr,MineNr,PitNr,GlueNr,ConveyorNr,TallN)
				board.setObstacleNumber(0, 0, 3,2,1,4);
				board.generateBoard();
				break;
			case "Medium":
				board.setBoardSize(12);
				board.setObstacleNumber(2,2,4,3,3,6);
				board.generateBoard();
				break;
			case "Hard":
				board.setBoardSize(15);
				board.setObstacleNumber(2,6,8,4,4,6);
				board.generateBoard();
				break;
			default:
				board.setBoardSize(0);
				board.setObstacleNumber(0,0,0,0,0,0);
				
		}
		
	}
}

