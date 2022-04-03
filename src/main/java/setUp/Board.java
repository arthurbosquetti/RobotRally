package setUp;

import setUp.Tiles.EmptyTile;
import setUp.Tiles.Tile;
import setUp.Tiles.TileFactory;
import setUp.Tiles.TileType;

import java.util.Random;
//import setUp.Movement;

public class Board {
	
	private Tile[][] boardLayout;
//	private Movement mov;
	private int boardSize;
	private int obstacleNumber;
	private int flagNumber = 2;
	
	public Board() {
//		this.mov = new Movement(this);

		//still needed for testing

//		generateBoard();
	}

	//Getters and Setters
	public Tile getTile(int x, int y) {
		return this.boardLayout[y][x];
	}
	public void setTile(int x, int y, Tile newTile) {
		//checks to make sure new tile is within the game board
		if (x > 0 || x < boardSize || y > 0 || y < boardSize) {
			this.boardLayout[y][x] = newTile;
		} else
		System.out.println("Error: attempted to set tile outside of gameboard");
	}

//	public int getCols() {
//		return cols;
//	}
//	public int getRows() {
//		return rows;
//	}

	//TODO: add code for robots colliding, change to work with movement card, and change based on those
//	public boolean makeMove(Robot robot, boolean forward, int steps) {
//		//gets the next point based on move
//		int[] newPoint = robot.getNewPoint(forward, steps);
//		//checks move for validity
//		if (mov.checkMove(newPoint)) {
//			//Code for moving the Robot
//			robot.nextTile(this.getTile(newPoint[0], newPoint[1]));
//			robot.setX(newPoint[0]);
//			robot.setY(newPoint[1]);
//			robot.move();
//			return true;
//		}
//		//Code for when robot can't move forward
//		return false;
//	}

	//TODO: change generation based on boardType
	public void generateBoard() {
		this.boardLayout = new Tile[boardSize][boardSize];
		Random r = new Random();
		for (int k = 0; k < boardSize*boardSize; k++) {
			for (int j = 0; j < boardSize; j++) {
				for (int i = 0; i < boardSize; i++) {
					int randTile = r.nextInt(boardSize*boardSize);
					int randObstacle = r.nextInt(2);
					if (randTile < 2) {
						this.boardLayout[j][i] = TileFactory.getTile("FLAG");
					} else if (randTile < 2 + obstacleNumber) {
						if (randObstacle == 0) {
							this.boardLayout[j][i] = TileFactory.getTile("PIT");
						} else {
							this.boardLayout[j][i] = TileFactory.getTile("TALL");
						}
					} else {
						this.boardLayout[j][i] = TileFactory.getTile("EMPTY");
					}

//					if (flagNumber == 0 && obstacleNumber == 0) {
//						this.boardLayout[j][i] = TileFactory.getTile("EMPTY");
//					} else if (obstacleNumber == 0) {
//						if (randInt == 0) {
//							this.boardLayout[j][i] = TileFactory.getTile("EMPTY");
//						} else {
//							this.boardLayout[j][i] = TileFactory.getTile("FLAG");
//							flagNumber--;
//						}
//					} else if (flagNumber == 0) {
//						if (randObstacle == 0) {
//							this.boardLayout[j][i] = TileFactory.getTile("EMPTY");
//						} else if (randObstacle == 1) {
//							this.boardLayout[j][i] = TileFactory.getTile("PIT");
//							obstacleNumber--;
//						} else {
//							this.boardLayout[j][i] = TileFactory.getTile("TALL");
//							obstacleNumber--;
//						}
//					} else {
//						if (randTile == 0) {
//							this.boardLayout[j][i] = TileFactory.getTile("EMPTY");
//						} else if (randTile == 1) {
//							this.boardLayout[j][i] = TileFactory.getTile("FLAG");
//							flagNumber--;
// 						} else if (randTile == 2) {
//							this.boardLayout[j][i] = TileFactory.getTile("PIT");
//							obstacleNumber--;
//						} else {
//							this.boardLayout[j][i] = TileFactory.getTile("TALL");
//							obstacleNumber--;
//						}
//					}
				}
			}
		}
	}
	
	
	//printing a board without a robot
	public void printBoard() {
		for (Tile[] row : this.boardLayout) {
			
			for (Tile col : row) {
				System.out.print(" " + col);
			}
			System.out.println(" ");
		}
	}
	
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	public void setObstacleNumber(int obstacleNumber) {
		this.obstacleNumber = obstacleNumber;
	}

	public void setFlag() {
		this.flagNumber--;
	}

	public int getFlagNumber() {
		return flagNumber;
	}

	public int getObstacleNumber() { return obstacleNumber; }

	public int getBoardSize() { return boardSize; }


		
	//Overloaded printBoard method for printing a robot
	public void printBoard(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();
		//loop through board
		for (int row = 0; row < boardLayout.length; row++)  {
			for (int col = 0; col < boardLayout[0].length; col++) {
				//check for robot in current tile
				if (x == col && y == row ) {
					System.out.print(" |R|");
				} else 
				System.out.print(" " + boardLayout[row][col]);
			}
			System.out.println(" ");
		}
		
		System.out.println("Robot is facing: " + robot.getDir());
	}
	
}
