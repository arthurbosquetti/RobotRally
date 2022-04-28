package model;

import java.util.Random;

import model.tiles.TeleportTile;
import model.tiles.Tile;
import model.tiles.TileFactory;
import view.BoardScreen;

@SuppressWarnings("unused")
public class Board {
	
	private int boardSize;
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
		BoardScreen.setBoardSize(boardSize);
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public void setObstacleNumbers(int teleportNr, int mineNr, int pitNr, int glueNr, int conveyorNr, int tallNr) {
		this.obstacleNumbers = new int[]{teleportNr, mineNr, pitNr, glueNr, conveyorNr, tallNr};
	}
	
	public int[] getObstacleNumbers() {
		return this.obstacleNumbers;
	}
	
	public void setTile(int x, int y, Tile newTile) {
		//checks to make sure new tile is within the game board
		if ((x >= 0 && x < boardSize) && (y >= 0 && y < boardSize)) {
			this.boardLayout[y][x] = newTile;
		} 
		else {
		System.out.println("Error: attempted to set tile outside of gameboard");
		}
	}
	

	//TODO: add code for robots colliding, change to work with movement card, and change based on those
	public boolean makeMove(Robot robot, boolean forward, int steps, boolean jump) {
		//gets the next point based on move
		int xO=robot.getX();
		int yO=  robot.getY();
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
			boardLayout[robot.getY()][robot.getX()].setRobotOff();
			//moves robot
			robot.nextTile(this.getTile(newPoint[0], newPoint[1]));
			robot.setX(newPoint[0]);
			robot.setY(newPoint[1]);
			robot.move();
			try {
				updateRobotPos(robot);
			} catch (Exception e) {
				System.out.println("The robot is "+robot.getName());
				System.out.println("Robot starts at ("+xO+","+yO+")");
				System.out.println("newPoint[][]= {"+newPoint[0]+","+newPoint[1]+"}");
				System.out.println("Next tile is "+getTile(newPoint[0], newPoint[1]).getType());
				System.out.println("Robot is at ("+robot.getX()+","+robot.getX()+")");
				
				e.printStackTrace();
			}
			return true;
			
		}
		//Code for when robot can't move forward
		return false;
	}
	
	public void updateRobotPos(Robot robot) throws Exception {
		int x = robot.getX();
		int y = robot.getY();
		
		boardLayout[robot.getY()][robot.getX()].setRobotOn(robot);
	}
	
	// Randomized board generation
	public void generateBoard() {
		this.boardLayout = new Tile[boardSize][boardSize];
//		System.out.println("generateBoard().boardLayout OK");
		// middle teleport tile
		if (this.boardSize == 12 || this.boardSize == 15) {
			this.boardLayout[6][6] = TileFactory.getTile("TELEPORT");
		}
//		System.out.println("generateBoard(). middleTeleport tile OK");


		// Place players in bottom corners, rn keep always keep them empty
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3 ; j++){
				this.boardLayout[boardSize - i -1][j] = TileFactory.getTile("EMPTY");
				this.boardLayout[boardSize - i -1][boardSize - j - 1] = TileFactory.getTile("EMPTY");
			}
		}
//		System.out.println("generateBoard().forforLoop OK");

		this.boardLayout[boardSize - 2][1] = TileFactory.getTile("SPAWN1");
		this.boardLayout[boardSize - 2][boardSize - 2] = TileFactory.getTile("SPAWN2");

//		System.out.println("generateBoard().spawnTiles OK");

		
		Random r = new Random();
		boolean boardGenerated = true;
		int ry = 0;
		int rx = 0;
		
//		System.out.println("generateBoard(). randoms OK, boardGenerated= "+boardGenerated);

		//while generating
		while (boardGenerated) {
			// Generating random coords
			int randRow = r.nextInt(boardSize);
			int randCol = r.nextInt(boardSize);
			int randObstacle = r.nextInt(2);
			
//			System.out.println("generateBoard(). int's OK");

			// Go to coords and set tile
			if (this.boardLayout[randCol][randRow] == null) {
//				System.out.println("generateBoard(). boardLayout[][] is null");
				if (flagNumber == 2) {
//					System.out.println("generateBoard(). flag#==2");
					this.boardLayout[randCol][randRow] = TileFactory.getTile("FLAG" + flagNumber);
					rx = randCol;
					ry = randRow;
					flagNumber--;
				}
				
				else if (flagNumber == 1) {
//					System.out.println("generateBoard(). flag#==1");
					if ((Math.abs(rx-randCol) >= boardSize/2)||(Math.abs(ry-randRow) >= boardSize/2)) {
						this.boardLayout[randCol][randRow] = TileFactory.getTile("FLAG" + flagNumber);
						flagNumber--;
					}
				}
				else if (obstacleNumbers[0] != 0 ){
//					System.out.println("generateBoard(). OBSnumbers[0]!=0");
					this.boardLayout[randCol][randRow] = TileFactory.getTile("TELEPORT");
					obstacleNumbers[0]--;
				}
				else if (obstacleNumbers[1] != 0 ){
//					System.out.println("generateBoard(). OBSnumbers[1]!=0");

					this.boardLayout[randCol][randRow] = TileFactory.getTile("MINE");
					obstacleNumbers[1]--;
				}
				else if (obstacleNumbers[2] != 0 ){
//					System.out.println("generateBoard(). OBSnumbers[2]!=0");
					this.boardLayout[randCol][randRow] = TileFactory.getTile("PIT");
					obstacleNumbers[2]--;
				}
				else if (obstacleNumbers[3] != 0 ){
//					System.out.println("generateBoard(). OBSnumbers[3]!=0");
					this.boardLayout[randCol][randRow] = TileFactory.getTile("GLUE");
					obstacleNumbers[3]--;
				}
				else if (obstacleNumbers[4] != 0 ){
//					System.out.println("generateBoard(). OBSnumbers[4]!=0");
					this.boardLayout[randCol][randRow] = TileFactory.getTile("CONVEYOR");
					obstacleNumbers[4]--;
				}
				else if (obstacleNumbers[5] != 0 ){
//					System.out.println("generateBoard(). OBSnumbers[5]!=0");
					this.boardLayout[randCol][randRow] = TileFactory.getTile("TALL");
					obstacleNumbers[5]--;
				}
				else {
//					System.out.println("generateBoard(). boardGenerated=false!");
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
	
	public int[][] searchBoard() { // currently built for finding 2 teleport tiles :P
		int[][] tileSpot = new int[2][2];
		for (int row = 0; row < boardLayout.length; row++)  { //search from top left corner
			for (int col = 0; col < boardLayout[0].length; col++) {	
				if (this.boardLayout[row][col] instanceof TeleportTile) {
					tileSpot[0][0] = row;
					tileSpot[0][1] = col;
				}
			}
		}
		for (int row = boardLayout.length-1; row > -1; row--)  { //search from bottom right corner
			for (int col = boardLayout.length-1; col > -1; col--) {	
				if (this.boardLayout[row][col] instanceof TeleportTile) {
					tileSpot[1][0] = row;
					tileSpot[1][1] = col;
				}
			}
		}
		return tileSpot;
	}

}
