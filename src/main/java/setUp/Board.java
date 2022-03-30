package setUp;

<<<<<<< HEAD
//import setUp.Level.Easy;
//import setUp.Level.Hard;
//import setUp.Level.Medium;
import setUp.Tiles.*;
=======
import setUp.Tiles.Tile;
import setUp.Tiles.TileType;
import setUp.Movement;
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git

public class Board {
<<<<<<< HEAD

=======
	
	private int boardType;
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	private Tile[][] board;
	private Movement mov;
	private int rows;
	private int cols;
<<<<<<< HEAD
=======
	private int boardsize; 
	private int obstaclenumber;
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	
<<<<<<< HEAD
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
=======
	public Board() {
		this.boardType = type;
		this.rows = 8;
		this.cols = 8;
		this.board = new Tile[rows][cols];
		this.mov = new Movement(this);
		
		//still needed for testing
		generateBoard(type);
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	}
	
<<<<<<< HEAD
// 	String[] board1 = {"Easy Board"};
// 	String[] board2 = {"Medium Board"};
// 	String[] board3 = {"Hard Boardx"};
=======
	String[] board1 = {"Easy Board"};
	String[] board2 = {"Medium Board"};
	String[] board3 = {"Hard Board"};
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	
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
	
	public void setLevel(int i) {
		this.level = i;
	}
	public int getLevel() {
		return level;
	}
	
	
	//TODO: add code for robots colliding, change to work with movement card, and change based on those
	public boolean makeMove(Robot robot, boolean forward, int steps) {
		//gets the next point based on move
		int[] newPoint = robot.getNewPoint(forward, steps);
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
	
<<<<<<< HEAD
// 	TODO: change generation based on boardType
	public void generateBoard(int type) {

		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(TileType.OPEN_FLOOR, false);
=======
	//TODO: change generation based on boardType
	public void generateBoard(int type) {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(TileType.OPEN_FLOOR, true);
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
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
<<<<<<< HEAD



// 	public void setLevel(int i) {
// 		this.level = i;
// 	}
// 	public int getLevel() {
// 		return level;
// 	}
=======
	
	public void setBoardSize(int boardSize) {
		this.boardsize = boardSize;
	}
	
	public void setObstacleNumber(int obstacleNumber) {
		this.obstaclenumber = obstacleNumber;
	}
<<<<<<< HEAD
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git



	


=======
	
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
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	
}
