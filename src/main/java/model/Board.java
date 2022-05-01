package model;

import model.tiles.TeleportTile;
import model.tiles.Tile;
import model.tiles.TileFactory;
import view.BoardScreen;

import java.util.Random;


public class Board {
	
	private int boardSize;
	public Tile[][] boardLayout;
	private int[] obstacleNumbers;
	private int flagNumber = 2;
	
	
	//Getters and Setters
	public Tile getTile(int x, int y) {
		return this.boardLayout[y][x];
	}
	
	// Setting a tile to the board
	public void setTile(int x, int y, Tile newTile) {
		// Checks to make sure new tile is within the game board
		if ((x >= 0 && x < boardSize) && (y >= 0 && y < boardSize)) {
			this.boardLayout[y][x] = newTile;
		} 
		else {
		System.out.println("Error: attempted to set tile outside of gameboard");
		}
	}
	
	//size of board
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
		BoardScreen.setBoardSize(boardSize);
	}
	public int getBoardSize() {
		return boardSize;
	}
	
	//sets the different amount of different obstacles
	public void setObstacleNumbers(int teleportNr, int mineNr, int pitNr, int glueNr, int conveyorNr, int tallNr) {
		this.obstacleNumbers = new int[]{teleportNr, mineNr, pitNr, glueNr, conveyorNr, tallNr};
	}
	
    public int[] getObstacleNumbers() {
		return this.obstacleNumbers;
	}
	
	
	// Randomized board generation
	public void generateBoard() {
		
		this.boardLayout = new Tile[boardSize][boardSize];
		// Place players in bottom corners, keep tiles around them empty to avoid trapping them
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
		int ry = 0;
		int rx = 0;
		
//		System.out.println("generateBoard(). randoms OK, boardGenerated= "+boardGenerated);

		//while generating
		while (boardGenerated) {
			// Generating random coords
			int randRow = r.nextInt(boardSize);
			int randCol = r.nextInt(boardSize);
			
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
	
	// A method for finding the two teleport tiles on a board
	public int[][] searchBoard() {
		int[][] tileSpot = new int[2][2];
		int a = boardSize;
		for (int row = 0; row < a; row++)  { //search from top left corner
			for (int col = 0; col < a; col++) {	
				if (this.boardLayout[row][col] instanceof TeleportTile) {
					tileSpot[0][0] = row;
					tileSpot[0][1] = col;
				}
			}
		}
		for (int row = a-1; row > -1; row--)  { //search from bottom right corner
			for (int col = a-1; col > -1; col--) {	
				if (this.boardLayout[row][col] instanceof TeleportTile) {
					tileSpot[1][0] = row;
					tileSpot[1][1] = col;
				}
			}
		}
		return tileSpot;
	}

}
