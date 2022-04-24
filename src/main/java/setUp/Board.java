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
	private static int boardSize;
	private Tile[][] boardLayout;
	private Movement mov= new Movement(this);
	private int[] obstacleNumbers;
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
	
	public void setObstacleNumbers(int teleportNr, int mineNr, int pitNr, int glueNr, int conveyorNr, int tallNr) {
		this.obstacleNumbers = new int[]{teleportNr, mineNr, pitNr, glueNr, conveyorNr, tallNr};
	}
	
	public void setTile(int x, int y, Tile newTile) {
		//checks to make sure new tile is within the game board
		if ((x > 0 && x < boardSize) && (y > 0 && y < boardSize)) {
			this.boardLayout[y][x] = newTile;
		} 
		else {
		System.out.println("Error: attempted to set tile outside of gameboard");
		}
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
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3 ; j++){
				this.boardLayout[boardSize - i -1][j] = TileFactory.getTile("EMPTY");
				this.boardLayout[boardSize - i -1][boardSize - j - 1] = TileFactory.getTile("EMPTY");
			}
		}
		this.boardLayout[boardSize - 2][1] = TileFactory.getTile("SPAWN1");
		this.boardLayout[boardSize - 2][boardSize - 2] = TileFactory.getTile("SPAWN2");

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
				}
				else if (obstacleNumbers[0] != 0 ){
					this.boardLayout[randCol][randRow] = TileFactory.getTile("TELEPORT");
					obstacleNumbers[0]--;
				}
				else if (obstacleNumbers[1] != 0 ){
					this.boardLayout[randCol][randRow] = TileFactory.getTile("MINE");
					obstacleNumbers[1]--;
				}
				else if (obstacleNumbers[2] != 0 ){
					this.boardLayout[randCol][randRow] = TileFactory.getTile("PIT");
					obstacleNumbers[2]--;
				}
				else if (obstacleNumbers[3] != 0 ){
					this.boardLayout[randCol][randRow] = TileFactory.getTile("GLUE");
					obstacleNumbers[3]--;
				}
				else if (obstacleNumbers[4] != 0 ){
					this.boardLayout[randCol][randRow] = TileFactory.getTile("CONVEYOR");
					obstacleNumbers[4]--;
				}
				else if (obstacleNumbers[5] != 0 ){
					this.boardLayout[randCol][randRow] = TileFactory.getTile("TALL");
					obstacleNumbers[5]--;
				}
				else {
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
	
	public void loadBoard() {
		setLayout(new GridLayout(boardSize, boardSize));
		for (Tile[] row : boardLayout) {
			for (Tile tile : row) {
				add(tile);
			}
		}
	}
}
