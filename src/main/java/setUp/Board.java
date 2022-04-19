package setUp;

import setUp.Tiles.EmptyTile;
import setUp.Tiles.Tile;
import setUp.Tiles.TileFactory;

import java.awt.GridLayout;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import setUp.Movement;

@SuppressWarnings("unused")
public class Board extends JPanel {
	
	private static final long serialVersionUID = -8623078556898821308L;
	private Tile[][] boardLayout;
	private Movement mov= new Movement(this);
	private int boardSize;
	private int obstacleNumber;
	private int flagNumber = 2;
	
	//Getters and Setters
	public Tile getTile(int x, int y) {
		return this.boardLayout[y][x];
	}
	
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public void setObstacleNumber(int obstacleNumber) {
		this.obstacleNumber = obstacleNumber;
	}
	
	public void setTile(int x, int y, Tile newTile) {
		//checks to make sure new tile is within the game board
		if (x > 0 || x < boardSize || y > 0 || y < boardSize) {
			this.boardLayout[y][x] = newTile;
		} else
		System.out.println("Error: attempted to set tile outside of gameboard");
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
		//checks move for validity: runs code to move robot
		if (mov.checkMove(newPoint)) {
			//remove robot from previous tile
			this.getTile(robot.getX(), robot.getY()).setRobotOff();
			//add robot to next tile
			this.getTile(newPoint[0], newPoint[1]).setRobotOn(robot);;
			//moves robot
			robot.nextTile(this.getTile(newPoint[0], newPoint[1]));
			robot.setX(newPoint[0]);
			robot.setY(newPoint[1]);
			robot.move();
			return true;
		}
		//Code for when robot can't move forward
		return false;
	}

	// Randomized board generation
	public void generateBoard() {
		this.boardLayout = new Tile[boardSize][boardSize];

		// Place players in bottom corners, rn keep always keep them empty
		this.boardLayout[boardSize - 1][0] = TileFactory.getTile("EMPTY");
		this.boardLayout[boardSize - 1][boardSize - 1] = TileFactory.getTile("EMPTY");

		Random r = new Random();
		boolean boardGenerated = true;
		//while generating
		while (boardGenerated) {
			// Generating random coords
			int randRow = r.nextInt(boardSize);
			int randCol = r.nextInt(boardSize);
			int randObstacle = r.nextInt(2);
			// Go to coords and set tile
			if (this.boardLayout[randCol][randRow] == null) {
				if (flagNumber != 0) {
					this.boardLayout[randCol][randRow] = TileFactory.getTile("FLAG" + flagNumber);
					flagNumber--;
				} else if (obstacleNumber != 0) {
					if (randObstacle == 0) {
						this.boardLayout[randCol][randRow] = TileFactory.getTile("PIT");
					} else {
						this.boardLayout[randCol][randRow] = TileFactory.getTile("TALL");
					}
					obstacleNumber--;
				} else {
					boardGenerated = false;
				}
			}
		}
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (this.boardLayout[i][j] == null) {
					this.boardLayout[i][j] = TileFactory.getTile("EMPTY");
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
		
	//Overloaded printBoard method for printing a robot
	public void printBoard(Robot[] robot) {
		//loop through board
		for (int row = 0; row < boardLayout.length; row++)  {
			for (int col = 0; col < boardLayout[0].length; col++) {
				//check for robot in current tile
				boolean robotOn = false;
				for (Robot robo : robot) {
					if (robo.getX() == col && robo.getY() == row ) {
						System.out.print("   |R| ");
						robotOn = true;
					}
				}
				if (!robotOn) {
					System.out.print(" " + boardLayout[row][col]);		
				}
			}
			System.out.println(" ");
		}
	}
	
	public void searchBoard(Tile tile) {
		//TODO
	}
	
	public void loadBoard() {
		setLayout(new GridLayout(boardSize, boardSize));
		for (Tile[] row : boardLayout) {
			for (Tile tile : row) {
				add(tile);
			}
		}
	}
}
