package setUp;

public class Board {
	
	int boardType;
	
	public Board(int i) {
		this.boardType=i;
	}
	
	String[] board1 = {"Easy Board"};
	String[] board2 = {"Medium Board"};
	String[] board3 = {"Hard Boardx"};
	
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
		} else System.out.println("Not a valid difficulty level");
	}


	
}
