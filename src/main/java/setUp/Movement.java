package setUp;

import setUp.Board;
import setUp.Direction;

public class Movement {
	
	private Board board;
	
	public Movement(Board newBoard) {
		this.board = newBoard;
	}
	
	public boolean checkMove(int[] point) {
		int x = point[0];
		int y = point[1];
		if (x < 0 || x >= board.getCols() || y < 0 || y >= board.getRows()) {
			System.out.println("Error: move out of board");
			return false;
		} else if (board.getTile(x, y).validTile()) {
			return true;
		} else 
			System.out.println("move failed, obstacle in the way");
			return false;
	}	

}
