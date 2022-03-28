package setUp;

//import setUp.Level.Easy;
//import setUp.Level.Hard;
//import setUp.Level.Medium;
import setUp.Tiles.*;

public class Board {

	private Tile[][] board;
	private int rows;
	private int cols;
	
	public Board(int i) {
	    if (i == 1) {
// 	        Easy level = new Easy();
	        this.rows = 8;
	        this.cols = 8;
	        this.board = new Tile[rows][cols];
	    }
	    else if (i == 2) {
// 	        Medium level = new Medium();
            this.rows = 10;
            this.cols = 10;
            this.board = new Tile[rows][cols];
	    }
	    else if (i == 3) {
// 	        Hard level = new Hard();
            this.rows = 12;
            this.cols = 12;
            this.board = new Tile[rows][cols];
	    }
	    else {
			this.board = null;
	    }
    }
		
		
		
// 		if (type==1 || type==2 || type==3) {
// 			this.boardType = type;
// 			this.rows = 8;
// 			this.cols = 8;
// 			this.board = new Tile[rows][cols];
// 		}
// 		else {
// 			this.board = null;
// 		}
//
// 		//generateBoard(type);
//
//
// 	}
	
	public Tile[][] getBoard() {
		return board;
	}
	
// 	String[] board1 = {"Easy Board"};
// 	String[] board2 = {"Medium Board"};
// 	String[] board3 = {"Hard Boardx"};
	
	public Tile getTile(int x, int y) {
		return this.board[y][x];
	}
	
	public void setTile(int x, int y, Tile newTile) {
		//TODO fix for indexOutOfBounds
		 this.board[y][x] = newTile;
	}
	
// 	TODO: change generation based on boardType
	public void generateBoard(int type) {

		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(TileType.OPEN_FLOOR, false);
				this.board[j][i] = t;
			}
		}
	}
	
	public void printBoard() {
		for (Tile[] row : this.board) {
			for (Tile col : row) {
				System.out.print(" " + col);
			}
			System.out.println(" ");
		}

// 		if (boardType==1) {
// 			for (String row : board1) {
// 				System.out.println(row);
// 			}
// 		} else if (boardType==2) {
// 			for (String row : board2) {
// 				System.out.println(row);
// 			}
// 		} else if (boardType==3) {
// 			for (String row : board3) {
// 				System.out.println(row);
// 			}
// 		} else {
// 			System.out.println("Not a valid difficulty level");
// 		}
	}



// 	public void setLevel(int i) {
// 		this.level = i;
// 	}
// 	public int getLevel() {
// 		return level;
// 	}


	
}
