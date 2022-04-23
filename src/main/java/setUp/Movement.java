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
		if (x < 0 || x >= board.getBoardSize() || y < 0 || y >= board.getBoardSize()) {
			//System.out.println("Error: move out of board");
			return false;
		} else if (board.getTile(x, y).validTile()) {	// no clue what a valid tile is... any tile that's not null?
			return true;
		} else
			//System.out.println("move failed, obstacle in the way");
			return false;
	}

	public int[] getNewPoint(Direction dir, int x, int y, boolean forward, int step) {
		switch (dir.getDirection()) {
			case "north":
				return (forward)? new int[]{x, y - step} : new int[]{x, y + step};
			case "east":
				return (forward)? new int[]{x + step, y} : new int[]{x - step, y};

			case "south":
				return (forward)? new int[]{x, y + step} : new int[]{x, y - step};

			case "west":
				return (forward)? new int[]{x - step, y} : new int[]{x + step, y};

			default:
				System.out.println("Error in getNewPoint, direction not found");
				return new int[]{x, y};
		}
	}
}
