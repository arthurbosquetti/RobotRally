package setUp;

import setUp.Tiles.Tile;
import setUp.Tiles.TileType;

public class Board {
	
	private int boardType;
	private Tile[][] board;
	private int rows;
	private int cols;
	
	public Board(int type) {
		this.boardType = type;
		this.rows = 8;
		this.cols = 8;
		this.board = new Tile[rows][cols];

		
		generateBoard(type);
		
		
	}
	
	String[] board1 = {"Easy Board"};
	String[] board2 = {"Medium Board"};
	String[] board3 = {"Hard Boardx"};
	
	public Tile getTile(int x, int y) {
		return this.board[y][x];
	}
	
	public void setTile(int x, int y, Tile newTile) {
		//TODO fix for indexOutOfBounds
		 this.board[y][x] = newTile;
	}
	
	//TODO: change generation based on boardType
	public void generateBoard(int type) {
		
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(TileType.OPEN_FLOOR);
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
		
		if (boardType==1) {
			for (String row : board1) {
				System.out.println(row);
			}
		} else if (boardType==2) {
			for (String row : board2) {
				System.out.println(row);
			}
		} else if (boardType==3) {
			for (String row : board3) {
				System.out.println(row);
			}
		} else {
			System.out.println("Not a valid difficulty level"); 
		}
	}


	
}
