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
		return (!(x < 0 || x >= board.getBoardSize() || y < 0 || y >= board.getBoardSize()));
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
