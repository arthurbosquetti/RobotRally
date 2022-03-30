package setUp;

public class Level {
	
	private String thislevel; private int level; private Board board;
	
	public Level(String a, Board newBoard) {
		this.thislevel = a;
		this.board = newBoard;
		initializeBoard();
	}

			
// this is all bullshit rn but just an example
	
	public void initializeBoard() {
		
		switch(thislevel) {
			case "Easy":
				board.setBoardSize(3);
				board.setObstacleNumber(2);
			case "Medium":
				board.setBoardSize(5);
				board.setObstacleNumber(3);
			case "Hard":
				board.setBoardSize(7);
				board.setObstacleNumber(5);
			default:
				board.setBoardSize(0);
				board.setObstacleNumber(0);
				
		}
		
	}
	
	public void setLevel(int i) {
		this.level = i;
	}
	public int getLevel() {
		return level;
	}
}

