package setUp;

public class Board {
	
	int boardType;
	
	public Board(int i) {
		this.boardType=i;
	}
	
	String[] board1 = {"board level 1"};
	String[] board2 = {"board level 2"};
	String[] board3 = {"board level 3"};
	
	public void printBoard() {
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
		} //must check that difficulty level is range 1-3...
	}
	
}
