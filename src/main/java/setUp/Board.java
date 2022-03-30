package setUp;

import setUp.Tiles.Tile;
import setUp.Tiles.TileType;
import setUp.Movement;

public class Board {
	
	private Tile[][] board;
	private Movement mov;
	private int rows;
	private int cols;
	private int boardsize; 
	private int obstaclenumber;
	
	public Board() {
		this.rows = 8;
		this.cols = 8;
		this.board = new Tile[rows][cols];
		this.mov = new Movement(this);
		
		//still needed for testing
		generateBoard();
	}
	
	//Getters and Setters
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
	
	//TODO: add code for robots colliding, change to work with movement card, and change based on those
	public boolean makeMove(Robot robot, boolean forward, int steps, boolean jump) {
		//gets the next point based on move
		int[] newPoint = mov.getNewPoint(robot.getDir(), robot.getX(), robot.getY(), forward, steps);
		
		if (jump) {
			int [] midPoint = mov.getNewPoint(robot.getDir(), robot.getX(), robot.getY(), forward, steps);
			if (!(mov.checkMove(midPoint))) {
				return false;
			}
		}
		
		//checks move for validity
		if (mov.checkMove(newPoint)) {
			//Code for moving the Robot
			robot.nextTile(this.getTile(newPoint[0], newPoint[1]));
			robot.setX(newPoint[0]);
			robot.setY(newPoint[1]);
			robot.move();
			return true; 
		}
		//Code for when robot can't move forward
		return false;
	}
	
	//TODO: change generation based on boardType
	public void generateBoard() {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(TileType.OPEN_FLOOR, true);
				this.board[j][i] = t;
			}
		}
	}
	
	
	//printing a board without a robot
	public void printBoard() {
		for (Tile[] row : this.board) {
			
			for (Tile col : row) {
				System.out.print(" " + col);
			}
			System.out.println(" ");
		}
	}
	
	public void setBoardSize(int boardSize) {
		this.boardsize = boardSize;
	}
	
	public void setObstacleNumber(int obstacleNumber) {
		this.obstaclenumber = obstacleNumber;
	}



		
	//Overloaded printBoard method for printing a robot
	public void printBoard(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();
		//loop through board
		for (int row = 0; row < board.length; row++)  {
			for (int col = 0; col < board[0].length; col++) {
				//check for robot in current tile
				if (x == col && y == row ) {
					System.out.print(" |R|");
				} else 
				System.out.print(" " + board[row][col]);
			}
			System.out.println(" ");
		}
		
		System.out.println("Robot is facing: " + robot.getDir());
	}
	
}
