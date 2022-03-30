package setUp;

public class MovingCard {
	private int steps;
	
	public void detMove(String action, Robot robot, Board board) {
		if (action == "F1") {
			board.makeMove(robot, true, 1, false);
		}
		else if (action == "F2") {
			board.makeMove(robot, true, 1, false);
			board.makeMove(robot, true, 1, false);
		}
		else if (action == "F3") {
			board.makeMove(robot, true, 1, false);
			board.makeMove(robot, true, 1, false);
			board.makeMove(robot, true, 1, false);
		}
		else if (action == "B")	{
			board.makeMove(robot, false, 1, false);
		}
		else if (action == "J") {
			board.makeMove(robot, true, 2, true);
		}
	}
}
