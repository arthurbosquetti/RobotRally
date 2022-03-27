package setUp;

import setUp.Tiles.Tile;
import setUp.Tiles.TileType;
import setUp.Movement;

public class Board implements Level{
	
	private int boardType;
	private Tile[][] board;
	private Movement mov;
	private int rows;
	private int cols;
	private int level;
	
	public Board(int type) {
		this.boardType = type;
		this.rows = 8;
		this.cols = 8;
		this.board = new Tile[rows][cols];
		this.mov = new Movement(this);
		
		//still needed for testing
		generateBoard(type);
		
	}
	
	String[] board1 = {"Easy Board"};
	String[] board2 = {"Medium Board"};
	String[] board3 = {"Hard Boardx"};
	
	public Tile getTile(int x, int y) {
		return this.board[y][x];
	}
	
	public void setTile(int x, int y, Tile newTile) {
		//checks to make sure new tile is within the game board
		if (x > 0 || x < cols || y > 0 || y < rows) {
			this.board[y][x] = newTile;
		} else 
		System.out.println("Error: attempted to set tile outside of gameboard");
		
	}
	
	public int getCols() {
		return cols;
	}
	public int getRows() {
		return rows;
	}
	
	//change to work with movement card, and change based on those
	public boolean makeMove(Robot robot, boolean forward, int steps) {
		//gets the next point based on move
		int[] newPoint = mov.newPoint(robot.getDir(), robot.getX(), robot.getY(), forward, steps);
		//checks move for validity
		if (mov.checkMove(newPoint)) {
			//Code for moving the Robot
			robot.nextTile(this.getTile(newPoint[0], newPoint[1]));
			robot.move();
			robot.setX(newPoint[0]);
			robot.setY(newPoint[1]);	
			return true;
		}
		//Code for when robot can't move forward
		return false;
	}
	
	//TODO: change generation based on boardType
	public void generateBoard(int type) {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(TileType.OPEN_FLOOR, true);
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



	public void setLevel(int i) {
		this.level = i;
	}
	public int getLevel() {
		return level;
	}


	
}
