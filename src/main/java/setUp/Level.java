package setUp;

public class Level {
	
	private int boardsize; private int obstaclenumber; private String thislevel; private int level; private Board board;
	
	public Level(String a, Board newBoard) {
		this.thislevel = a;
		this.board = newBoard;
		initializeBoard();
	}
	
	//Level easy = new Level("Easy"); do in game class?
	//Level medium = new Level("Medium");
	//Level hard = new Level("Hard");

			
// this is all bullshit rn but just an example
	
	public void initializeBoard() {
		
		switch(thislevel) {
			case "Easy":
				setBoardSize(3);
				setObstacleNumber(2);
			case "Medium":
				setBoardSize(5);
				setObstacleNumber(3);
			case "Hard":
				setBoardSize(7);
				setObstacleNumber(5);
		}
		
	}
	
	public void setBoardSize(int boardSize) {
		this.boardsize = boardSize;
	}
	
	public void setObstacleNumber(int obstacleNumber) {
		this.obstaclenumber = obstacleNumber;
	}
	
	public void setLevel(int i) {
		this.level = i;
	}
	public int getLevel() {
		return level;
	}
}

